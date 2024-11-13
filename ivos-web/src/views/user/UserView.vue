<template>
<div style="height: 6vh;padding: 10px 20px;background-color: #FFF;">
  <span style="line-height: 60px;font-size: 20px;">用户管理</span>
  <el-button type="primary" style="float: right;margin-top: 10px;"
  @click="beforeAddUser">新建用户</el-button>
</div>
<!--  新建用户弹窗-->
<!--  :before-close="handleClose"在关闭弹窗前调用处理弹窗关闭的方法,防止误触将弹窗关闭-->
  <el-dialog
      :title=dialogTitle
      v-model="dialogVisible"
      style="width: 1000px;padding: 40px;"
      :before-close="handleClose"
  >
    <el-form label-width="80px" label-position="top">
      <el-row gutter="10">
       <el-col :span="12">
         <el-form-item label="用户名"><el-input v-model="saveUserForm.username" placeholder="请输入用户名"
         :disabled="saveUserForm.id!=null"></el-input></el-form-item>
       </el-col>
        <el-col :span="12">
          <el-form-item label="手机号"><el-input v-model="saveUserForm.phone" placeholder="请输入手机号"></el-input></el-form-item>
        </el-col>
      </el-row>
      <el-row gutter="10">
        <el-col :span="12">
          <el-form-item label="邮箱"><el-input v-model="saveUserForm.email" placeholder="请输入邮箱"></el-input></el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="年龄"><el-input v-model="saveUserForm.age" placeholder="请输入年龄"></el-input></el-form-item>
        </el-col>
      </el-row>
      <el-row gutter="10">
        <el-col :span="6">
          <el-form-item label="职级">
            <el-select placeholder="请选择" v-model="saveUserForm.level"  @change="loadLeader">
<!--              <el-option label="职员" value="10"></el-option>
              <el-option label="经理" value="20"></el-option>
              <el-option label="总监" value="30"></el-option>
              <el-option label="总裁" value="40"></el-option>-->
              <el-option v-for="item in levelOptions" :label="item.label" :value="item.value"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="6">
          <el-form-item label="直属领导">
            <el-select placeholder="请选择" v-model="saveUserForm.parentId">
<!--              <el-option label="AA" value="120"></el-option>
              <el-option label="BB" value="121"></el-option>-->
              <el-option v-for="item in leaderOptions" :label="item.username" :value="item.id"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="4">
          <el-form-item label="性别">
            <el-radio-group v-model="saveUserForm.gender">
              <el-radio border label="男" value="1" style="margin: 0"></el-radio>
              <el-radio border label="女" value="0"></el-radio>
            </el-radio-group>
          </el-form-item>
        </el-col>
        <el-col :span="6">
          <el-form-item label="用户状态">
            <el-radio-group v-model="saveUserForm.status">
              <el-radio border label="启用" value="1" style="margin: 0"></el-radio>
              <el-radio border label="禁用" value="0"></el-radio>
            </el-radio-group>
          </el-form-item>
        </el-col>
      </el-row>
    </el-form>
    <template #footer>
      <el-button @click="handleClose">取消</el-button>
      <el-button type="primary" @click="saveUser">保存</el-button>
    </template>
  </el-dialog>
  <el-card style="margin: 20px;height: 70px;">
    <el-form :inline="true">
      <el-form-item label="用户搜索" style="width: 220px;"><el-input  v-model="searchUserForm.username" @keydown.enter="loadUser" placeholder="请输入用户名"></el-input></el-form-item>
      <el-form-item label="用户状态" style="width: 290px;">
        <el-select v-model="searchUserForm.status" @change="loadUser" placeholder="请选择用户状态">
          <el-option :label="启用" :value="1"></el-option>
          <el-option :label="禁用" :value="0"></el-option>
        </el-select></el-form-item>
      <el-form-item>
        <el-button @click="resetSearch">重置</el-button>
        <el-button type="primary" @click="loadUser">搜索</el-button>
      </el-form-item>
    </el-form>
  </el-card>
<!--用户列表数据卡片-->
  <el-card style="margin: 20px;">
    <el-table :data="userArr">
      <el-table-column type="index" label="编号" width="80" align="center"></el-table-column>
      <el-table-column prop="username" label="用户名" align="center"></el-table-column>
      <el-table-column prop="phone" label="手机号" align="center"></el-table-column>
      <el-table-column prop="createTime" label="加入时间" align="center"></el-table-column>
      <el-table-column prop="status" label="用户状态" align="center">
        <template #default="scope">
          <el-switch active-value="1" inactive-value="0" v-model="scope.row.status"
          @click="changeStatus(scope.row.id,scope.row.status)"></el-switch>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center">
        <template #default="scope">
          <el-button link type="primary" @click="resetPassword(scope.row.id)">密码重置</el-button>
          <el-button link type="primary" @click="editUser(scope.row.id)">编辑</el-button>
          <el-button link type="primary" @click="deleteUser(scope.row.id)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
  </el-card>
</template>

<script setup>
import {onMounted, ref} from "vue";
import {ElMessage} from "element-plus";
import axios from "axios";
import qs from "qs";

const dialogVisible=ref(false);
const levelOptions=ref([
  {label:'职员',value:'10'},
  {label:'经理',value:'20'},
  {label:'总监',value:'30'},
  {label:'总裁',value:'40'},
])
const leaderOptions=ref([
  /*{username:'AA',id:'120'},
  {username:'BB',id:'121'}*/
])
const saveUserForm = ref({
  username:'',
  phone:'',
  email:'',
  age:'',
  level:'',
  parentId:'',
  gender:'',
  status:''
});
const saveUser=()=>{
  console.log(saveUserForm.value)
  axios.post(BASE_URL+'/v1/user/save',saveUserForm.value).then((response)=>{
    if(response.data.code==2000){
      ElMessage.success('保存成功!');
      dialogVisible.value=false;
      saveUserForm.value={};
      loadUser();
    }else{
      ElMessage.error(response.data.msg);
    }
  })
}
const handleClose = () => {
  if(confirm('您是否要关闭本弹窗?')){
    //关闭弹窗,且清空用户表单数据
    dialogVisible.value = false;
    saveUserForm.value = {};
  }
}
//定义对象用来保存用户搜索条件
const searchUserForm = ref({username:'', status:''});
//定义数组对象用来保存用户列表表格数据
const userArr = ref([]);
//定义加载用户列表的方法
const loadUser = () => {
  let data=qs.stringify(searchUserForm.value);
  axios.get(BASE_URL+'/v1/user/select?'+data).then((response)=>{
    if (response.data.code==2000){
      userArr.value=response.data.data;
    }else{
      ElMessage.error(response.data.msg);
    }
  })
}
const loadLeader=()=>{
  let level=parseInt(saveUserForm.value.level)+10;
  axios.get(BASE_URL+'/v1/user/select?level='+level).then((response)=>{
    if (response.data.code==2000){
      leaderOptions.value=response.data.data;
    }else {
      ElMessage.error(response.data.msg)
    }
  })
}
//定义重置搜索的方法
const resetSearch=()=>{
  searchUserForm.value={};
  loadUser();
}
onMounted(()=>{
  loadUser();
})
const resetPassword = (userId)=>{
  axios.post(BASE_URL+'/v1/user/update/password/'+userId).then((response)=>{
    if(response.data.code==2000){
      ElMessage.success('密码重置成功!');
    }else{
      ElMessage.error(response.data.msg);
    }
  })
}
const dialogTitle=ref('新建用户');
const editUser=(id)=>{
  dialogVisible.value=true;
  dialogTitle.value='编辑用户';
  //根据当前用户的id回显弹窗表单中此用户的数据
  axios.get(BASE_URL+'/v1/user/select?id='+id).then((response)=>{
    if(response.data.code==2000){
      //注意:后端返回的数据是一个集合,所以查一条数据的话需要取出第一个元素data[0]再赋值
      saveUserForm.value = response.data.data[0];
      let level=parseInt(saveUserForm.value.level)+10;
      axios.get(BASE_URL+'/v1/user/select?level='+level).then((response)=>{
        if (response.data.code==2000){
          leaderOptions.value=response.data.data;
        }else {
          ElMessage.error(response.data.msg)
        }
      })
    }else{
      ElMessage.error(response.data.msg);
    }
  })
}
const beforeAddUser=()=>{
  dialogTitle.value='新建用户';
  dialogVisible.value=true;
}
const changeStatus=(userId,status)=>{
  axios.post(BASE_URL+'/v1/user/update/status/'+userId+'/'+status).then((response)=>{
    if (response.data.code==2000)
      ElMessage.success('修改状态成功')
    else
      ElMessage.error(response.data.msg)
  })
}
const deleteUser=(userId)=>{
  if (confirm("您确认要删除这个员工的信息吗？")){
    axios.post(BASE_URL+'/v1/user/delete/'+userId).then((response)=>{

      if (response.data.code==2000){
        ElMessage.success('删除成功');
        loadUser();
      }
      else
        ElMessage.error(response.data.msg)
    })
  }
}
</script>

<style scoped>

</style>