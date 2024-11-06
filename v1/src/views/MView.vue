<template>
<h1>EL-消息提示组件</h1>
  <el-button @click="f(1)" type="">成功消息</el-button>
  <el-button @click="f(2)" type="">失败消息</el-button>
  <el-button @click="f(3)" type="">警告消息</el-button>
  <el-button @click="f(4)" type="">普通消息</el-button>
  <el-button @click="f(5)" type="">可关闭消息</el-button>
</template>

<script setup>
import {ElMessage} from "element-plus";

const f=(type)=>{
  switch (type) {
    case 1:
      ElMessage.success('这是一条成功消息');
      break;
    case 2:
      ElMessage.error('这是一条失败消息');
      break;
    case 3:
      ElMessage.warning('这是一条警告消息');
      break;
    case 4:
      ElMessage('这是一条普通消息');
      break;
    case 5:
      ElMessage({message:'这是一条可关闭消息',showClose:true});
      break;
  }
}
</script>

<style scoped>

</style>