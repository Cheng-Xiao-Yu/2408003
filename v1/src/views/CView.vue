<template>
  <h1>双向绑定指令</h1>
  <!-- 双向绑定:将info变量的值与页面上的元素进行绑定,效果:
   1)info变量的值发生变化,页面html的显示内容会随之变化(Data Binding数据绑定)
   2)页面上的元素值发生变化,info变量的值也会随着监听而变化(DOM Listener事件监听)-->
  <input type="text" v-model="info">
  {{info}}
  <h3>用户注册</h3>
  {{user}}
  <input type="text" placeholder="请输入用户名" v-model="user.username">
  <input type="password" placeholder="请输入密码" v-model="user.password">
  <br>性别:
  <input type="radio" name="gender" value="1" v-model="user.gender">男
  <input type="radio" name="gender" value="0" v-model="user.gender">女
  <br>
  <button @click="reg">点我注册</button>
</template>

<script setup>
import {ref} from "vue";

const info = ref('我是初始值');

//定义一个对象用来保存注册表单中的用户数据
const user = ref({
  username: '',
  password: '',
  gender: ''
});
//定义一个注册用户的方法
const reg = ()=>{
  console.log(user.value);
  console.log(user.value.username);
  console.log(user.value.password);
  console.log(user.value.gender);
}
</script>

<style scoped>

</style>