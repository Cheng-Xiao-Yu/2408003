<template>
  <h1>循环指令</h1>
  <ul>
    <li v-for="item in 5">{{item}}</li>
  </ul>
  <ul>
    <li v-for="p in productArr">{{p}}</li>
  </ul>
  <table border="1px">
    <tr>
      <th>序号</th>
      <th>标题</th>
      <th>价格</th>
      <th>库存</th>
      <th>操作</th>
    </tr>
    <tr v-for="(item,ind) in productArr">
      <td>{{ind+1}}</td>
      <td>{{item.title}}</td>
      <td>{{item.price}}</td>
      <td>{{item.num}}</td>
    </tr>
  </table>
</template>

<script setup>
import {ref} from "vue";

const productArr = ref([
  {title:'苹果',price:50,num:10},
  {title:'山竹',price:500,num:100},
  {title:'西瓜',price:30,num:20},
  {title:'香蕉',price:200,num:50}
]);
</script>

<style scoped>

</style>