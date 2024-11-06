<template>
  <h1>EL-表格组件</h1>
  <el-table :data="tableData" style="width: 100%">
    <el-table-column prop="date" label="Date" width="180" />
    <el-table-column prop="name" label="Name" width="180" />
    <el-table-column prop="address" label="Address" />
  </el-table>
  <br>
  <el-table :data="arr" style="width: 600px;margin: 0 auto">
    <el-table-column align="center" type="index" label="编号" width="180" />
    <el-table-column prop="name" label="姓名" width="180" />
    <el-table-column prop="salary" label="工资" width="180" />
    <el-table-column prop="job" label="岗位" />
    <el-table-column label="操作">
      <template #default="scope">
        <el-button type="danger" @click="del(scope.$index,scope.row)">删除</el-button>
      </template>
    </el-table-column>
  </el-table>
</template>

<script setup>
import {ref} from "vue";

const tableData = [
  {
    date: '2016-05-03',
    name: 'Tom',
    address: 'No. 189, Grove St, Los Angeles',
  },
  {
    date: '2016-05-02',
    name: 'Tom',
    address: 'No. 189, Grove St, Los Angeles',
  },
  {
    date: '2016-05-04',
    name: 'Tom',
    address: 'No. 189, Grove St, Los Angeles',
  },
  {
    date: '2016-05-01',
    name: 'Tom',
    address: 'No. 189, Grove St, Los Angeles',
  },
]
const arr=ref([
    {name:'张三',salary:3000,job:'维修员'},
    {name:'张三',salary:3000,job:'维修员'},
    {name:'张三',salary:3000,job:'维修员'},
    {name:'张三',salary:3000,job:'维修员'},
])
const del=(index,emp)=>{
  if (confirm('是否确认删除'+emp)){
    arr.value.splice(index,1)
  }
}
</script>

<style scoped>

</style>