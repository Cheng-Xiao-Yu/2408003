<template>
  <h1>El-表格组件</h1>
  <el-table :data="tableData" style="width: 100%">
    <el-table-column prop="date" label="日期" width="180"/>
    <el-table-column prop="name" label="姓名" width="180"/>
    <el-table-column prop="address" label="住址"/>
  </el-table>

  <el-table :data="arr" style="width: 600px;margin: 0 auto;">
    <el-table-column label="编号" type="index" width="80" align="center"></el-table-column>
    <el-table-column label="姓名" prop="name"></el-table-column>
    <el-table-column label="工资" prop="salary"></el-table-column>
    <el-table-column label="岗位" prop="job"></el-table-column>
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

//定义数组用来保存表格数据
const arr = ref([
  {name: '张三', salary: 3000, job: '维修员'},
  {name: '李四', salary: 4000, job: '销售员'},
  {name: '王五', salary: 5000, job: '护林员'},
  {name: '赵六', salary: 6000, job: '程序员'}
]);
//定义删除员工的方法
const del = (index,emp)=>{
  if(confirm('是否要删除'+emp.name+'?')){
    arr.value.splice(index,1);
  }
}
</script>

<style scoped>

</style>