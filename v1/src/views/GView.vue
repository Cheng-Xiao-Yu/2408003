<template>
<h1>计算器练习</h1>
  <input type="text" v-model="a">
  <input type="text" v-model="b">
  <button @click="f('+')">加</button>
  <button @click="f('-')">减</button>
  <button @click="f('*')">乘</button>
  <button @click="f('/')">除</button>
  <h4>结果是：{{result}}</h4>
</template>
<script setup>
import {ref} from "vue";

const a=ref('')
const b=ref('')
const result=ref('')
const f=(o)=>{
  result.value=eval(a.value+o+b.value)
}
</script>


<style scoped>

</style>