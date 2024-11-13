<template>
  <div>
    <el-container>
      <!--侧边栏-->
      <el-aside width="200px">
        <el-menu>
          <el-menu-item index="1">员工管理</el-menu-item>
          <el-menu-item index="2">车辆管理</el-menu-item>
          <el-menu-item index="3">围栏管理</el-menu-item>
        </el-menu>
      </el-aside>
      <el-container>
        <!--右侧顶部条-->
        <el-header>
          <h1  style="background-color: #0aa1ed;color: #fff;">智慧车辆管理系统-IVOS</h1>
        </el-header>
        <!-右侧主体-->
        <el-main>
          <el-table :data="vehicleArr">
            <el-table-column align="center" type="index" label="序号"></el-table-column>
            <el-table-column align="center" prop="brand" label="序号"></el-table-column>
            <el-table-column align="center" prop="model" label="序号"></el-table-column>
            <el-table-column align="center" prop="license" label="序号"></el-table-column>
            <el-table-column align="center" prop="color" label="序号"></el-table-column>
            <el-table-column align="center" prop="km" label="序号"></el-table-column>
          </el-table>
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>

<script setup>
import {ref} from "vue";

const vehicleArr = ref([{brand:'奥迪',model:'A8',license:'粤A88888',color:'黑',km:100000000},
  {brand:'奥迪',model:'A8',license:'粤A88888',color:'黑',km:100000000},
  {brand:'奥迪',model:'A8',license:'粤A88888',color:'黑',km:100000000},
  {brand:'奥迪',model:'A8',license:'粤A88888',color:'黑',km:100000000},
  {brand:'奥迪',model:'A8',license:'粤A88888',color:'黑',km:100000000},
  {brand:'奥迪',model:'A8',license:'粤A88888',color:'黑',km:100000000},
  {brand:'奥迪',model:'A8',license:'粤A88888',color:'黑',km:100000000},
  {brand:'奥迪',model:'A8',license:'粤A88888',color:'黑',km:100000000},
  {brand:'奥迪',model:'A8',license:'粤A88888',color:'黑',km:100000000},
  {brand:'奥迪',model:'A8',license:'粤A88888',color:'黑',km:100000000},
  {brand:'奥迪',model:'A8',license:'粤A88888',color:'黑',km:100000000}])
</script>

<style scoped>

</style>