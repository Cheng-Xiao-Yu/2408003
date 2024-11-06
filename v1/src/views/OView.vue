<template>
  <h1>EL-下拉选框组件</h1>
  <el-select v-model="city" placeholder="请选择你喜欢的城市" style="width:200px;">
    <el-option
        v-for="item in optionsList"
        :label="item.label"
        :value="item.value">
    </el-option>
  </el-select>
  <h3>您选择的城市为：{{city}}</h3>
</template>

<script setup>
import {ref} from "vue";

const optionsList=ref(
    [{label:'北京',value:'bj'},
  {label:'天津',value:'tj'},
  {label:'上海',value:'sh'},
  {label:'深圳',value:'sz'}]

);
const city=ref('');
</script>

<style scoped>

</style>