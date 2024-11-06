<template>
  <h1>EL-单选组件</h1>
  <el-radio-group v-model="edu">
    <el-radio value="初中">学历:初中</el-radio>
    <el-radio label="学历:高中" value="高中"></el-radio>
    <el-radio label="学历:本科" value="本科"></el-radio>
    <el-radio label="学历:硕士" value="硕士"></el-radio>
  </el-radio-group>
  <h4>您选择的学历是：{{edu}}</h4>
  <br>
  <el-radio-group v-model="pri">
    <el-radio-button v-for="p in arr" :label="p.title" :value="p.price"></el-radio-button>
  </el-radio-group>
  <h4>您选择的酒的价格是：{{pri}}</h4>

</template>

<script setup>
import {ref} from "vue";

const edu=ref('');
const arr=ref([
  {title:'五粮液',price:2500},
  {title:'茅台',price:1500},
  {title:'梦之蓝',price:800},
  {title:'汾酒',price:100}
])
const pri=ref(2500)
</script>

<style scoped>

</style>