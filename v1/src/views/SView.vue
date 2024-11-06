<template>
  <h1>EL-菜单组件</h1>
  <el-menu mode="horizontal" @select="handleSelect" background-color="#4f8dfe" text-color="#fff" active-text-color="#ffd04b">
    <el-menu-item index="1">首页</el-menu-item>
    <el-menu-item index="2">直播课</el-menu-item>
    <el-menu-item index="3">免费课</el-menu-item>
    <el-menu-item index="4">精品课</el-menu-item>
    <el-menu-item index="5">线上班</el-menu-item>
    <el-sub-menu index="6">
      <template #title>线下班</template>
      <el-menu-item index="6-1">jsd2407</el-menu-item>
      <el-menu-item index="6-2">jsd2408</el-menu-item>
      <el-menu-item index="6-3">jsd2409</el-menu-item>
    </el-sub-menu>
  </el-menu>
</template>

<script setup>


const handleSelect=(index,indexPath)=>{
  console.log(index,indexPath)
}
</script>

<style scoped>

</style>