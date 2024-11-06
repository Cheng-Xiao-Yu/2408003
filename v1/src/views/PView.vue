<template>
  <h1>EL-开关组件</h1>
  <el-switch v-model="value1" />
  <el-switch
      v-model="value2"
      class="ml-2"
      style="--el-switch-on-color: #13ce66; --el-switch-off-color: #ff4949"
  />
  <br>
  <el-switch v-model="isShow" active-color="#13ce66" inactive-color="#ff4949"></el-switch>
  <el-switch v-model="num" :active-value inactive-color="#ff4949"></el-switch>
  <el-switch v-model="num" active-color="#13ce66" inactive-color="#ff4949"></el-switch>
  <hr>
  <img src="fcq.jpg" v-if="isShow">
</template>

<script setup>
import { ref } from 'vue'
const num=ref('1')
const value1 = ref(false)
const value2 = ref(true)
const isShow=ref(true);
</script>

<style scoped>

</style>