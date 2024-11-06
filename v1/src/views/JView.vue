<template>
<h1>个人简历练习</h1>
<table border="1px">
  <tr>
    <td>照片</td>
    <td ><img :src="person.imgUrl" width="200px"></td>
  </tr>
  <tr>
    <td>姓名</td>
    <td>{{person.name}}</td>
  </tr>
  <td>年龄</td>
  <td>{{person.age}}</td>
  <tr>
    <td>好友</td>
    <td>
      <ul>
        <li v-for="i in person.friends">{{i}}</li>
      </ul>
    </td>
  </tr>
</table>
  <button @click="add">点击加载数据</button>
</template>
<script setup>
import {ref} from "vue";
const person=ref({name:'',age:'',imgUrl:'',friends:[]});
const add=()=>{
  person.value.name='范传奇';
  person.value.age='18';
  person.value.imgUrl='fcq.jpg';
  person.value.friends= ['张三','张三'];
}
</script>


<style scoped>

</style>