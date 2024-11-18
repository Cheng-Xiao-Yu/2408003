<!--字典管理页-->
<template>
  <div style="background-color:#fff;padding:10px 20px;">
    <span style="line-height:60px;font-size:20px;">字典管理</span>
  </div>
  <!-- 字典数据搜索卡片 -->
  <el-card style="margin:20px;height: 70px;">
    <el-form :inline="true">
      <el-form-item label="字典名称">
        <el-input placeholder="请输入" style="width:220px;" v-model="searchForm.name"
                  @keydown.enter="selectDict"></el-input>
      </el-form-item>
      <el-form-item label="字典编码">
        <el-input placeholder="请输入" style="width:220px;" v-model="searchForm.code"
                  @keydown.enter="selectDict"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button @click="resetSearch">重置</el-button>
        <el-button type="primary" @click="selectDict">搜索</el-button>
      </el-form-item>
    </el-form>
  </el-card>
  <el-card style="margin:20px;">
    <div style="margin:10px 0px 40px 10px;">
      字典列表
      <el-button type="primary" style="float: right;margin-top:-3px;" @click="addDict">新增字典</el-button>
    </div>
    <el-table :data="dictArr">
      <el-table-column type="index" label="编号" width="80" align="center"/>
      <el-table-column prop="name" label="字典名称" align="center"/>
      <el-table-column prop="code" label="字典编码" align="center">
        <template #default="scope">
          <el-button link type="primary" size="small" @click="showDictOption(scope.row.id)">{{ scope.row.code }}
          </el-button>
        </template>
      </el-table-column>
      <el-table-column prop="remark" label="备注信息" align="center"/>
      <el-table-column prop="createTime" label="创建时间" align="center"/>
      <el-table-column label="操作" align="center">
        <template #default="scope">
          <el-button link type="primary" size="small" @click="editDict(scope.row.id)">编辑</el-button>
          <el-button link type="primary" size="small" @click="deleteDict(scope.row.id)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
  </el-card>

  <!-- 保存字典弹窗 -->
  <el-dialog :title="dialogTitle" v-model="dialogVisible" style="width:1000px;padding:40px;"
             :before-close="handleClose">
    <el-form label-width="80px" label-position="top">
      <el-form-item label="字典名称">
        <el-input placeholder="请输入" v-model="saveDictForm.name"></el-input>
      </el-form-item>
      <el-form-item label="字典编码">
        <el-input placeholder="请输入" v-model="saveDictForm.code"></el-input>
      </el-form-item>
      <el-form-item label="备注信息">
        <el-input placeholder="请输入" v-model="saveDictForm.remark"></el-input>
      </el-form-item>
    </el-form>
    <template #footer>
      <el-button @click="handleClose">取消</el-button>
      <el-button type="primary" @click="saveDict">保存</el-button>
    </template>
  </el-dialog>
</template>
<script setup>

</script>

<style scoped>

</style>