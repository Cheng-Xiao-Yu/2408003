<!-- 登录页 -->
<template>
  <div style="height:100vh;overflow:hidden;
  background-image:linear-gradient(135deg,#1352F2,#3C82F5);">
    <el-container style="padding:30px;">
      <el-header>
        <el-row>
          <el-col :span="3">
            <img src="/imgs/login/logo.png" style="height: 50px;">
          </el-col>
          <el-col :span="1">
            <img src="/imgs/login/auto.png" style="height: 50px;">
          </el-col>
          <el-col :span="1">
            <img src="/imgs/login/verticalLine.png" style="height: 50px;">
          </el-col>
          <el-col :span="19">
            <span style="color:#fff;font-weight:bold;font-size:30px;">智慧车辆运营管理系统</span>
          </el-col>
        </el-row>
      </el-header>
      <el-main>
        <el-row>
          <el-col :span="16">
            <img src="/imgs/login/bg.png" style="width:100%;margin-top: 60px;">
          </el-col>
          <el-col :span="8">
            <el-card style="margin-top:80px;">
              <h3 style="text-align: center;">用户登录</h3>
              <el-form label-position="top">
                <el-form-item label="用户名">
                  <el-input placeholder="请输入用户名" v-model="user.username"></el-input>
                </el-form-item>
                <el-form-item label="密码">
                  <el-input placeholder="请输入密码" v-model="user.password"></el-input>
                </el-form-item>
                <el-form-item>
                  <el-button type="primary" style="width:100%;" @click="login">登录</el-button>
                </el-form-item>
              </el-form>
              <div style="text-align: center;color:#666;font-size: 14px;padding: 10px 0;">
                (体验账号:tom 密码:123456)
              </div>
            </el-card>
          </el-col>
        </el-row>
      </el-main>
    </el-container>
  </div>
</template>

<script setup>
import {ref} from "vue";
import axios from "axios";
import {ElMessage} from "element-plus";
import router from "@/router";

//定义对象用来保存登录用户的表单数据
const user = ref({username:'',password:''});
//定义登录方法
const login = ()=>{
  console.log(user.value);
  //1.向后端发送登录请求request->后端处理->响应response
  //注意：前端向后端发送请求需要借助axios!且必须导入!!!
  axios.post(BASE_URL+'/v1/user/login',user.value)
  .then((response)=>{
    //2.在回调函数中处理接收到的服务器响应，先发请求，服务器返回响应后才执行此处
    //3.response是响应对象，我们可以从response.data中得到后端的响应数据
    /* response.data是后端响应的JsonResult */
    /* response.data.data 是JsonResult中的响应数据UserVO */
    console.log(response);
    console.log(response.data);
    console.log(response.data.data);
    //根据状态码判断登录是否成功
    if(response.data.code == 2000){
      ElMessage.success('登录成功!');
      //console.log(response.data.data);
      //console.log(JSON.stringify(response.data.data));
      router.push('/');//提示成功消息+跳转至首页
      /* localStorage:维护字符串类型的键值对 */
      //登录成功后,将后端返回的userVO存入localStorage中,取的时候也用user这个名字取出来
      localStorage.setItem('user',JSON.stringify(response.data.data));
    }else{
      ElMessage.error(response.data.msg);
      user.value = {username:'',password:''};//提示错误消息+清空表单数据
    }
  });
}
</script>

<style scoped>

</style>