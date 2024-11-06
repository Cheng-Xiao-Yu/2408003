<template>
  <h1>我是大标题：<span v-text="info"></span></h1>
  <p v-text="aaa"></p>
  <p v-html="aaa"></p>
  <h1>我是大标题:<span>{{info}}</span></h1>
  {{info}}
  <p>{{info+'中午好!'}}</p>
  <hr>
  <button @click="f">点我</button>
</template>

<script setup>
import {ref} from "vue";
const info=ref('我是info6666');
const aaa=ref('我是<mark>aaa</mark>,展示 <b>高亮</b>效果');
const f=()=>{
  console.log('点击了按钮');
  console.log(info.value);
  info.value='我是新值' +
      '' +
      '' +
      ''
}

</script>

<style scoped>

</style>