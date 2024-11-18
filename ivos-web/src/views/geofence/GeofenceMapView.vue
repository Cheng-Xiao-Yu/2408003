<template>
  <div style="height: 6vh;background-color:#fff;padding:10px 20px;">
    <span style="line-height:60px;font-size:20px;">围栏管理</span>
    <el-button type="primary" style="float:right;margin-top:13px;" @click="router.push('/geofenceMap')">新建围栏</el-button>
  </div>
  <div id="mapContainer" style="width: 100%;height: 84vh;"></div>

  <!-- 新增电子围栏弹窗 -->
  <el-dialog title="围栏信息" v-model="dialogVisible" :before-close="closeDialog">
    <el-form label-width="80px">
      <el-form-item label="围栏名称">
        <el-input placeholder="请输入围栏名称" v-model="geofence.name"></el-input>
      </el-form-item>
    </el-form>
    <template #footer>
      <el-button @click="closeDialog">取消</el-button>
      <el-button type="primary" @click="saveGeofence">确定</el-button>
    </template>
  </el-dialog>
</template>

<script setup>
import router from "@/router";
import {nextTick, onMounted, ref} from "vue";
import {DrawScene,DrawControl,OperateEventType } from 'bmap-draw';
import {ElMessage} from "element-plus";
import qs from "qs";
import axios from "axios";
//定义变量控制弹窗是否出现
const dialogVisible = ref(false);
const geofence=ref({
  name:'',
  position:{}
});
var map;
onMounted(()=>{
  nextTick(()=>{
    map=new BMapGL.Map("mapContainer");
    let point=new BMapGL.Point(123.4543,41.8028);
    map.centerAndZoom(point,16);
    // 添加鼠标绘制控件
    const scene = new DrawScene(map);
    const drawContrl = new DrawControl(scene, {
      enableTips: false,
      anchor: BMAP_ANCHOR_TOP_RIGHT,
      drawingItems: [
        'circle',
        'rectangle'
      ]
  });
    //5.监听围栏(覆盖物)绘制完成事件,返回触发完成事件的event对象
    //注意:OperateEventType需要导入!
    //OperateEventType.COMPLETE代表绘制完成,也就是用户点"√"的时候
    scene.addEventListener(OperateEventType.COMPLETE,(event)=>{
      //9.用户绘制完围栏后,立即显示弹窗,供用户输入围栏名称
      dialogVisible.value = true;
      console.log(event.target);
      let overlay=event.target.overlay;
      console.log(overlay);
      if (overlay instanceof BMapGL.Circle){
        geofence.value.position.type='circle';
        geofence.value.position.radius=overlay.getRadius();
        //设置圆心的经纬度
        geofence.value.position.longitude = overlay.getCenter().lng;
        geofence.value.position.latitude = overlay.getCenter().lat;
        console.log(geofence.value);
      } else {//绘制的围栏是矩形
        //定义数组用来保存矩形的四个顶点坐标值
        let recPoints = [];
        //依次遍历获取每个点的经纬度
        for (let i = 0; i < 4; i++) {
          recPoints.push(overlay.points[i].latLng.lng+'-'+overlay.points[i].latLng.lat);
        }
        //设置围栏类型为矩形
        geofence.value.position.type = 'rectangle';
        //将上面准备好的四个顶点坐标数组转为字符串
        geofence.value.position.recPoints =  recPoints.join(',');
        console.log(geofence.value);
      }
    })
    //4.将绘制控件添加到地图上
    map.addControl(drawContrl);
  })
})
//定义新增围栏的方法
const saveGeofence = ()=>{
  if(!geofence.value.name || geofence.value.name.trim()==''){
    ElMessage.error('围栏名称不能为空!');
    return;
  }
  //geofence对象中的position也是一个对象,需要先转为JSON格式的字符串
  geofence.value.position = JSON.stringify(geofence.value.position);
  //再将geofence对象转为查询字符串
  let data = qs.stringify(geofence.value);
  //给后端发送新增围栏的请求
  axios.post(BASE_URL+'/v1/geofence/save',data).then((response)=>{
    if(response.data.code==2000){
      ElMessage.success('围栏新增成功!');
      dialogVisible.value = false;//关闭弹窗
      router.push('/geofence');//跳转至围栏列表页
    }else{
      ElMessage.error(response.data.msg);
    }
  })
}
//定义关闭弹窗的方法
const closeDialog = ()=>{
  if(confirm('您确认要关闭弹窗吗?')){
    dialogVisible.value = false;
    //清空地图上绘制的覆盖物
    map.clearOverlays();
    //清空输入框中输入的围栏名称和围栏位置数据
    geofence.value = {name:'',position:{}};
  }
}
</script>

<style scoped>

</style>