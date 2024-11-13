<!-- 父级页面:控制除了登录页以外的所有页的共有左侧菜单栏与头部 -->
<template>
  <!-- 给父元素使用弹性布局flex,可以让所有子元素横置且父元素不会失高 -->
  <div style="display: flex;">
    <!-- 左侧菜单栏折叠时宽度为64px,不折叠时宽度为208px,右侧永远撑满剩余全部宽度   -->
    <div :style="{width:(isCollapse?'64px':'208px')}">
      <!-- 左侧菜单栏 -->
      <!-- unique-opened同一时刻只能打开一个菜单项  router允许菜单项进行路由跳转-->
      <el-menu
        background-color="#3C82F5"
        style="width:100%;height:100vh;"
        text-color="#fff"
        active-text-color="#ff0"
        unique-opened
        router
        :collapse="isCollapse"
        :collapse-transition="false"
        @select="selectMenu"
      >
        <el-row>
         <el-col :span="2"></el-col>
         <el-col :span="7" style="padding-left: 7px;">
           <el-avatar src="/imgs/admin/logo.png" style="width: 35px;height: 35px;"></el-avatar>
         </el-col>
         <el-col :span="isCollapse?0:13">
           <span style="color: #fff;position: relative;top: 8px;left: 2px;font-weight: bold;">智慧车辆</span>
         </el-col>
        </el-row>
        <el-sub-menu index="1">
          <template #title>
            <el-icon style="font-size: 21px;"><User/></el-icon>
            <span>用户管理</span>
          </template>
          <el-menu-item index="/vehicle">用户列表</el-menu-item>
        </el-sub-menu>
        <el-sub-menu index="2">
          <template #title>
            <el-icon style="font-size: 21px;"><Van/></el-icon>
            <span>车辆管理</span>
          </template>
          <el-menu-item index="/vehicle">车辆列表</el-menu-item>
        </el-sub-menu>
        <el-sub-menu index="3">
          <template #title>
            <el-icon style="font-size: 21px;"><Location/></el-icon>
            <span>围栏管理</span>
          </template>
          <el-menu-item index="/geofence">电子围栏</el-menu-item>
        </el-sub-menu>
        <el-sub-menu index="4">
          <template #title>
            <el-icon style="font-size: 21px;"><Place/></el-icon>
            <span>调度管理</span>
          </template>
          <el-menu-item index="/application">申请列表</el-menu-item>
          <el-menu-item index="/audit">调度审核</el-menu-item>
          <el-menu-item index="/distribute">车辆分配</el-menu-item>
        </el-sub-menu>
        <el-sub-menu index="5">
          <template #title>
            <el-icon style="font-size: 21px;"><MessageBox/></el-icon>
            <span>数据字典</span>
          </template>
          <el-menu-item index="/dict">字典管理</el-menu-item>
        </el-sub-menu>
      </el-menu>
    </div>
    <div :style="{width:(isCollapse?'calc(100% - 64px)':'calc(100% - 208px)')}">
      <!-- 右侧:顶部条 -->
      <el-header style="padding-top:22px;height:10vh;background-color:#fff;">
        <!-- 折叠菜单图标与退出登录  -->
        <el-row :gutter="10">
          <el-col :span="18">
            <el-icon style="font-size:20px;" @click="changeCollapsed"><Expand/></el-icon>
          </el-col>
          <el-col :span="6" style="position: relative;">
            <el-dropdown trigger="click" style="position: absolute;right: 20px;">
              <span style="font-size:19px;font-weight: bold;">
                {{vehicle.username}}
                <el-icon><arrow-down/></el-icon>
              </span>
              <template #dropdown>
                <el-dropdown-menu>
                  <el-dropdown-item @click="logout">退出登录</el-dropdown-item>
                </el-dropdown-menu>
              </template>
            </el-dropdown>
          </el-col>
        </el-row>
<!--        面包屑导航-->
        <el-breadcrumb separator="/" style="position: relative;top: 20px;">
          <el-breadcrumb-item>首页</el-breadcrumb-item>
          <el-breadcrumb-item v-for="item in breadcrumb">{{ item }}</el-breadcrumb-item>
<!--          <el-breadcrumb-item>用户管理</el-breadcrumb-item>
          <el-breadcrumb-item>用户列表</el-breadcrumb-item>-->
        </el-breadcrumb>
      </el-header>
      <!-- 右侧:主体内容(可变区域) -->
      <el-main style="height: 90vh;padding: 0;overflow-y:auto;">
        <router-view/>
      </el-main>

    </div>
  </div>
</template>

<script setup>
import {ref} from "vue";
const changeCollapsed=()=>{
  isCollapse.value=!isCollapse.value;
}
//定义变量控制左侧菜单栏是否折叠
const isCollapse = ref(false);
//调用全局对象window中设置的方法,获取当前登录的用户名
const vehicle = ref(getUser());
const logout=()=>{
  if (confirm('您确定要退出登录吗')){
    localStorage.removeItem('vehicle');
    localStorage.removeItem('breadCrumb');
    window.location.href='/login';
    vehicle.value='';
  }
}
const breadcrumb=ref(JSON.parse(localStorage.getItem('breadCrumb'))||['用户管理','用户列表'])
let map = {
  '/vehicle':['用户管理','用户列表'],
  '/vehicle':['车辆管理','基本信息'],
  '/geofence':['电子围栏','围栏管理'],
  '/application':['调度管理','申请列表'],
  '/audit':['调度管理','调度审核'],
  '/distribute':['调度管理','车辆分配'],
  '/dict':['数据字典','字典管理']
}
const selectMenu=(index)=>{
  breadcrumb.value=map[index];
  localStorage.setItem('breadCrumb',JSON.stringify(breadcrumb.value));
}
</script>