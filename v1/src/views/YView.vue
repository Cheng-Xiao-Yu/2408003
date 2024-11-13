<template>
  <h1>员工列表综合练习</h1>
  <el-form style="width: 600px;margin: 0 auto;">
    <el-form-item label="姓名">
      <el-input placeholder="请输入员工姓名" v-model="emp.name"></el-input>
    </el-form-item>
    <el-form-item label="工资">
      <el-input placeholder="请输入员工工资" v-model="emp.salary"></el-input>
    </el-form-item>
    <el-form-item label="岗位">
      <el-input placeholder="请输入员工岗位" v-model="emp.job"></el-input>
    </el-form-item>
    <el-form-item>
      <el-button type="success" @click="add">提交</el-button>
    </el-form-item>
  </el-form>

  <el-table :data="arr" style="width: 600px;margin: 0 auto;">
    <el-table-column label="编号" type="index" width="80" align="center"></el-table-column>
    <el-table-column label="姓名" prop="name" align="center"></el-table-column>
    <el-table-column label="薪资" prop="salary" align="center"></el-table-column>
    <el-table-column label="岗位" prop="job" align="center"></el-table-column>
    <el-table-column label="操作">
      <template #default="scope">
        <el-button type="danger" @click="del(scope.$index,scope.row)">删除</el-button>
      </template>
    </el-table-column>
  </el-table>
</template>

<script setup>
import {ref} from "vue";
import {ElMessage} from "element-plus";

//定义员工对象来保存双向绑定收集的数据
const emp = ref({name:'',salary:'',job:''});
//定义数组用来保存多个员工对象
const arr = ref([]);
//定义添加员工的方法
const add = ()=>{
  //将员工对象添加到表格前需要进行非空校验
  if(emp.value.name.trim()=='' || emp.value.salary.trim()=='' || emp.value.job.trim==''){
    //ElMessage使用时需要导入!
    ElMessage.error('员工数据不能为空!');
    return;
  }
  arr.value.push(emp.value);
  emp.value = {name:'',salary:'',job:''};
  console.log(arr.value);
}
//定义删除员工的方法
const del = (index,emp)=>{
  if(confirm('是否要删除'+emp.name+'?')){
    arr.value.splice(index,1);
    ElMessage.success(emp.name+'已成功删除!')
  }
}
</script>

<style scoped>

</style>