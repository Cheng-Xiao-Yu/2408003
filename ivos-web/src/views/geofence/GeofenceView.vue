<!--电子围栏页 GeofenceView.vue-->
<template>
  <div style="height: 6vh;background-color:#fff;padding:10px 20px;">
    <span style="line-height:60px;font-size:20px;">围栏管理</span>
    <el-button type="primary" style="float:right;margin-top:13px;" @click="router.push('/geofenceMap')">新建围栏</el-button>
  </div>
  <!-- 围栏查询卡片 -->
  <el-card style="margin:20px;height: 70px;">
    <el-form :inline="true">
      <el-form-item label="围栏名称">
        <el-input placeholder="请输入" style="width:220px;"
                  v-model="geoSearchForm.name" @keydown.enter="loadGeo"></el-input>
      </el-form-item>
      <el-form-item label="围栏状态" style="width:290px;">
        <el-select placeholder="请选择" v-model="geoSearchForm.status" @change="loadGeo">
          <el-option label="启用" value="1"/>
          <el-option label="禁用" value="0"/>
        </el-select>
      </el-form-item>
      <el-form-item>
        <el-button @click="resetSearch">重置</el-button>
        <el-button type="primary" @click="loadGeo">查询</el-button>
      </el-form-item>
    </el-form>
  </el-card>
  <!-- 围栏表格数据 -->
  <el-card style="margin:20px;">
    <el-table stripe :data="geoTableData">
      <el-table-column label="编号" prop="id" type="index" align="center" width="100"></el-table-column>
      <el-table-column label="围栏名称" prop="name" align="center"></el-table-column>
      <el-table-column label="围栏坐标点" prop="position" align="center" show-overflow-tooltip="true" width="500"></el-table-column>
      <el-table-column label="创建时间" prop="createTime" align="center"></el-table-column>
      <el-table-column label="围栏状态" align="center">
        <template #default="scope">
          <el-switch inactive-value="0" active-value="1" v-model="scope.row.status" @change="changeStatus(scope.row.id,scope.row.status)"></el-switch>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center">
        <template #default="scope">
          <el-button type="primary" link @click="loadVehicle(scope.row.id)">管理车辆</el-button>
          <el-button type="primary" link @click="deleteGeo">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
  </el-card>
  <!-- 已绑定车辆弹窗 -->
  <el-dialog title="已绑定车辆" v-model="bindVehicleDialogVisible" style="padding:40px;">
    <el-button type="primary" style="margin:10px 0;" @click="showUnbindVehicleList">添加绑定车辆</el-button>
    <el-table :data="bindVehicleArr">
      <el-table-column prop="brand" label="车辆品牌" align="center"></el-table-column>
      <el-table-column prop="license" label="车牌号" align="center"></el-table-column>
      <el-table-column prop="type" label="车辆类型" align="center"></el-table-column>
      <el-table-column
          label="操作"
          fixed="right"
          width="200"
          align="center">
        <template #default="scope">
          <el-button link type="primary" @click="removeBindVehicle(scope.row.id)">移除</el-button>
        </template>
      </el-table-column>
    </el-table>
  </el-dialog>
  <!-- 添加可绑定车辆列表弹窗 -->
  <el-dialog title="可绑定车辆列表" v-model="AddBindVehicleDialogVisible"
             :before-close="handleClose">
    <el-table :data="unBindVehicleArr">
      <el-table-column label="编号" type="index" align="center" width="80px"></el-table-column>
      <el-table-column prop="brand" label="车辆品牌" align="center"></el-table-column>
      <el-table-column prop="license" label="车牌号" align="center"></el-table-column>
      <el-table-column prop="type" label="车辆类型" align="center"></el-table-column>
      <el-table-column prop="status" label="车辆状态" align="center"></el-table-column>
      <el-table-column label="操作" align="center">
        <template #default="scope">
          <el-button link type="primary" @click="bindNewVehicle(scope.row.id)">绑定</el-button>
        </template>
      </el-table-column>
    </el-table>
  </el-dialog>
</template>
<script setup>
import {onMounted, ref} from "vue";
import {ElMessage} from "element-plus";
import axios from "axios";
import qs from "qs";
import router from "@/router";

//控制"已绑定车辆弹窗"是否显示
const bindVehicleDialogVisible = ref(false);
//控制"可绑定车辆列表"是否显示
const AddBindVehicleDialogVisible = ref(false);

//定义对象保存围栏搜索条件
const geoSearchForm = ref({name:'',status:''});
//定义数组用来保存围栏列表数据
const geoTableData = ref([]);
//定义加载围栏的方法
const loadGeo = () => {
  //把接收到的查询参数转为查询字符串格式
  let data = qs.stringify(geoSearchForm.value);
  //给后端发送查询请求
  axios.get(BASE_URL+'/v1/geofence/select?'+data).then((response)=>{
    if(response.data.code==2000){
      geoTableData.value = response.data.data;
    }else{
      ElMessage.error(response.data.msg);
    }
  })
}
//定义重置搜索的方法
const resetSearch = () => {
  geoSearchForm.value = {name:'',status:''};
  loadGeo();
}
//一进入到围栏页面立即加载
onMounted(()=>{
  loadGeo();
})
//定义数组用来保存围栏已绑定车辆数据
const bindVehicleArr = ref([]);
//定义全局变量用来保存围栏id
var geoId;
//定义加载指定围栏上绑定的所有车辆的方法
const loadVehicle= (geofenceId)=>{
  bindVehicleDialogVisible.value = true;
  /*给全局变量赋值*/
  geoId = geofenceId;
  axios.get(BASE_URL+'/v1/vehicle/select?geofenceId='+geofenceId).then((response)=>{
    if(response.data.code==2000){
      bindVehicleArr.value = response.data.data;
    }else{
      ElMessage.error(response.data.msg);
    }
  })
}
//定义移出围栏绑定的指定车辆的方法,此处的id是车辆id
const removeBindVehicle = (id)=>{
  axios.post(BASE_URL+'/v1/vehicle/unbind/'+id).then((response)=>{
    if(response.data.code==2000){
      ElMessage.success('移除成功!');
      /* 车辆解绑成功后,需要重新加载该围栏上绑定的车辆! */
      loadVehicle(geoId);
    }else{
      ElMessage.error(response.data.msg);
    }
  })
}
//定义数组用来保存未绑定围栏的车辆数据
const unBindVehicleArr = ref([]);
//定义加载未绑定围栏车辆数据的方法
const showUnbindVehicleList = ()=>{
  AddBindVehicleDialogVisible.value = true;
  //查围栏绑定状态为"0"的所有车
  axios.get(BASE_URL+'/v1/vehicle/select?geofenceBindStatus=0').then((response)=>{
    if(response.data.code==2000){
      unBindVehicleArr.value = response.data.data;
    }else{
      ElMessage.error(response.data.msg);
    }
  })
}
//定义给指定围栏绑定指定车辆的方法,此处的id是车辆id
const bindNewVehicle =(id)=>{
  axios.post(BASE_URL+'/v1/vehicle/bind/'+geoId+'/'+id).then((response)=>{
    if(response.data.code==2000){
      ElMessage.success('绑定成功!');
      //每成功绑定走一辆车,就需要重新加载所有的可绑定车辆
      showUnbindVehicleList();
    }else{
      ElMessage.error(response.data.msg);
    }
  })
}
//定义处理内层弹窗关闭的方法
const handleClose = ()=>{
  //在内层弹窗关闭之前,需要加在外层弹窗的数据:绑定在当前围栏上的所有车
  loadVehicle(geoId);
  //再关闭内层弹窗
  AddBindVehicleDialogVisible.value = false;
}
const changeStatus=(id,status)=>{
  //??????????????????????????????????????????????????????????????????????
  //axios.post(BASE_URL+'v1/vehicle/update?id='+id+'&status='+status).then((response))
  let data = qs.stringify({id:id,status:status});
  axios.post(BASE_URL+'/v1/geofence/save',data).then((response)=>{
    if(response.data.code==2000){
      ElMessage.success('围栏状态修改成功!');
    }else{
      ElMessage.error(response.data.msg);
    }
  })
}
const deleteGeo=(geofenceId)=>{
  axios.post(BASE_URL+'/v1/geofence/deleteGeofence?geofenceId='+geofenceId).then((response)=>{
    if(response.data.code==2000){
      ElMessage.success('围栏删除成功!');
    }else{
      ElMessage.error(response.data.msg);
    }
  })
}
</script>

<style scoped>
</style>