<template>
  <h1>EL-分栏布局组件</h1>
  <el-row :gutter="30">
   <el-col :span="6" style="background-color: #0aa1ed">10</el-col>
   <el-col :span="6" style="background-color: #00FF00">10</el-col>
   <el-col :span="6" style="background-color: #0aa1ed">10</el-col>
    <el-col :span="6" style="background-color: #00FF00">10</el-col>
  </el-row>
  <h3>两张图</h3>
  <el-row :gutter="10">
   <el-col :span="12"><img src="2024.png" style="width: 100%"></el-col>
   <el-col :span="12"><img src="2024.png" style="width: 100%"></el-col>
  </el-row>
  <h3>六张图</h3>
  <el-row :gutter="10">
   <el-col :span="4"><img src="2024.png" style="width: 100%"></el-col>
   <el-col :span="4"><img src="2024.png" style="width: 100%"></el-col>
   <el-col :span="4"><img src="2024.png" style="width: 100%"></el-col>
   <el-col :span="4"><img src="2024.png" style="width: 100%"></el-col>
   <el-col :span="4"><img src="2024.png" style="width: 100%"></el-col>
   <el-col :span="4"><img src="2024.png" style="width: 100%"></el-col>
  </el-row>
  <h3>两张图</h3>
  <el-row :gutter="10">
    <el-col :span="4"><img src="2024.png" style="width: 100%"></el-col>
    <el-col :span="8"><img src="2024.png" style="width: 100%"></el-col>
    <el-col :span="12"><img src="2024.png" style="width: 100%"></el-col>
  </el-row>
  <el-row>
   <el-col :span="12" style="border: 5px solid #f00">10</el-col>
   <el-col :span="12" style="border: 5px solid #f00">10</el-col>
  </el-row>
</template>

<script setup>

</script>

<style scoped>

</style>