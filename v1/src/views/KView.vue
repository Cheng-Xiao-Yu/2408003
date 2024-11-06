<template>
  <h1>EL-按钮组件</h1>
  <el-button>按钮</el-button>
  <el-button type="danger" plain>按钮</el-button> <!--镂空按钮-->
  <el-button type="success" round>按钮</el-button><!--胶囊型按钮-->
  <el-button type="info" circle>按钮</el-button><!--圆形按钮-->
  <el-button type="warning" disabled>按钮</el-button><!--禁用按钮-->
  <el-button type="primary" link>按钮</el-button><!--链接按钮-->
  <hr>
  <div>
    <el-button :icon="Search" circle />
    <el-button type="primary" :icon="Edit" circle />
    <el-button type="success" :icon="Check" circle />
    <el-button type="info" :icon="Message" circle />
    <el-button type="warning" :icon="Star" circle />
    <el-button type="danger" :icon="Delete" circle />
  </div>
</template>

<script setup>
import {
  Check,
  Delete,
  Edit,
  Message,
  Search,
  Star,
} from '@element-plus/icons-vue'
</script>

<style scoped>

</style>