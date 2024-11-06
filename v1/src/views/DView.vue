<template>
  <h1>事件绑定指令</h1>
  <button @click="f">按钮1</button>
  <button v-on:click="f">按钮2</button>
  <h3>敲回车事件</h3>
  <input type="text" placeholder="请输入您想搜索的商品" v-model="search" @keydown.enter="f2">
</template>

<script setup>
import {ref} from "vue";
const f = ()=>{
  console.log('点击了按钮!');
}
const search = ref('');
const f2 = ()=>{
  alert('您要搜索的是'+search.value+'吗?');
}
</script>

<style scoped>

</style>