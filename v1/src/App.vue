<template>
  <nav>
<!--https://yscp0bp3g6.feishu.cn/docx/TNfOdX57VoflquxHO4Qc8oyWnJg?from=from_copylink-->
    <router-link to="/">Home</router-link> |
    <router-link to="/about">About</router-link> |
    <router-link to="/a1">文本指令</router-link> |
    <router-link to="/b">属性绑定指令</router-link> |
    <router-link to="/c">双向绑定指令</router-link> |
    <router-link to="/d">事件绑定指令</router-link> |
    <router-link to="/e">循环指令</router-link> |
    <router-link to="/f">隐藏显示</router-link> |
    <router-link to="/g">计算器练习</router-link> |
    <router-link to="/h">猜数字练习</router-link> |
    <router-link to="/i">员工列表练习</router-link> |
    <router-link to="/j">个人简历练习</router-link> | <br>
    <router-link to="/k">El-按钮组件</router-link> |
    <router-link to="/l">El-图标组件</router-link> |
    <router-link to="/m">El-消息提示组件</router-link> |
    <router-link to="/n">El-单选组件</router-link> |
    <router-link to="/o">El-下拉选框组件</router-link> |
    <router-link to="/p">El-开关组件</router-link> |
    <router-link to="/q">El-表单组件</router-link> |
    <router-link to="/r">El-表格组件</router-link> |
    <router-link to="/s">El-菜单组件</router-link> |
    <router-link to="/t">El-分栏布局组件</router-link> |
    <router-link to="/u">El-组件</router-link> |
    <router-link to="/v">El-组件</router-link> |
    <router-link to="/w">El-组件</router-link> |
    <router-link to="/x">El-组件</router-link> |
    <router-link to="/y">El-组件</router-link> |
    <router-link to="/z">El-组件</router-link> |
  </nav>
  <router-view/>
</template>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

nav {
  padding: 30px;
}

nav a {
  font-weight: bold;
  color: #2c3e50;
}

nav a.router-link-exact-active {
  color: #42b983;
}
</style>
<script setup>
</script>