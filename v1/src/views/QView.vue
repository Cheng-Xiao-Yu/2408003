<template>
  <h1>EL-组件</h1>
  <el-form ref="form" :model="form" label-width="80px" style="width: 500px; margin: 0 auto;">
    <el-form-item label="用户名"><el-input v-model="username" placeholder="请输入用户名" label="qwe"></el-input></el-form-item>
    <el-form-item label="密码"><el-input v-model="password" placeholder="请输入密码" type="password"></el-input></el-form-item>
    <el-form-item label="性别">
      <el-radio-group v-model="gender">
        <el-radio value="男" label="男"></el-radio>
        <el-radio value="女" label="女"></el-radio>
      </el-radio-group>
    </el-form-item>
    <el-form-item label="所在地"><el-select v-model="city" placeholder="请选择你喜欢的城市" style="width:200px;">
      <el-option
          v-for="item in optionsList"
          :label="item.label"
          :value="item.value">
      </el-option>
    </el-select></el-form-item>
    <el-form-item label="管理员"><el-switch v-model="value1"/></el-form-item>
    <input type="submit" value="提交表单">
  </el-form>
</template>

<script setup>
import {ref} from "vue";

const optionsList = ref(
    [{label: '北京', value: 'bj'},
      {label: '天津', value: 'tj'},
      {label: '上海', value: 'sh'},
      {label: '深圳', value: 'sz'}]
);
const city = ref('');
const value1 = ref(false);
const username=ref('');
const password=ref('');
const gender=ref('');

</script>

<style scoped>

</style>