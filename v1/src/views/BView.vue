<template>
  <h1>属性绑定指令</h1>
  <input type="text" value="kk">
  <input type="text" value="info">
  <!-- 将input元素的value属性值与info变量进行绑定，由info来控制此输入框显示的默认值到底是什么 -->
  <input type="text" v-bind:value="info">
  <input type="text" :value="info">
  <hr>
  <a href="url">超链接</a>
  <a :href="url">超链接2</a>
</template>

<script setup>
import {ref} from "vue";

const info = ref('tom2');
const url = ref('https://www.baidu.com');
url.value = 'https://www.jd.com';
</script>

<style scoped>

</style>