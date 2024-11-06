<template>
<h1>员工列表练习</h1>
  <input type="text" placeholder="请输入员工" v-model="emp.name">
  <input type="text" placeholder="请输入员工" v-model="emp.salary">
  <input type="text" placeholder="请输入员工" v-model="emp.job">
  <button @click="add">添加员工</button>
  <hr>
  <table border="1px">
    <tr>
      <td>编号</td>
      <td>姓名</td>
      <td>工资</td>
      <td>职位</td>
    </tr>
    <tr v-for="(p,i) in arr">
      <td>{{i+1}}</td>
      <td>{{p.name}}</td>
      <td>{{p.salary}}</td>
      <td>{{p.job}}</td>
    </tr>
  </table>
</template>
<script setup>
import {ref} from "vue";

const emp=ref({
  name:'',
  salary:'',
  job:''
})
const add=()=>{
  if (emp.value.name.trim()==''||emp.value.salary.trim()==''||emp.value.job.trim()==''){
    alert('请输入数据');
    return;
  }
  arr.value.push(emp.value);
  emp.value={};
  console.log(arr.value);
}
const arr=ref([]);
</script>


<style scoped>

</style>