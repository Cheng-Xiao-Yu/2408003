<template>
  <h1>El-日期时间选择器组件</h1>
  <el-date-picker
      type="date"
      v-model="rq"
      format="YYYY-MM-DD"
      value-format="YYYY-MM-DD"
      @change="console.log(rq)"
  ></el-date-picker>
  <br>
  <el-date-picker
      type="datetime"
      v-model="time"
      format="YYYY-MM-DD HH:mm:ss"
      value-format="YYYY-MM-DD HH:mm:ss"
      @change="console.log(time)"
  ></el-date-picker>
  <br>
  <el-date-picker
      type="datetimerange"
      v-model="times"
      format="YYYY-MM-DD HH:mm:ss"
      value-format="YYYY-MM-DD HH:mm:ss"
      @change="f"
      start-placeholder="开始啦"
      end-placeholder="结束喽"
      range-separator="到"
  ></el-date-picker>
</template>

<script setup>
import {ref} from "vue";

//定义变量用来保存用户选择的日期
const rq = ref('');
const time = ref('');
const times = ref([]);
const f = ()=>{
  console.log(times.value);
  console.log(times.value[0]);
  console.log(times.value[1]);
}
</script>

<style scoped>

</style>