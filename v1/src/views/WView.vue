<template>
<h1>EL-卡片组件</h1>
  <el-row :gutter="10">
   <el-col :span="6" v-for="item in 4">
     <el-card>
       <img src="mwzz.png" style="width: 100%">
       <p>《宝可梦》：妙蛙种子</p>
       <div style="height: 20px;">
         <span style="float: left;">属性：草、毒</span>
         <span style="float: right;">好友：小火龙</span>
       </div>
     </el-card></el-col>
  </el-row>
</template>
<script setup>

</script>

<style scoped>

</style>