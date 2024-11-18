<!--字典项页-->
<template>
  <div style="background-color:#fff;padding:10px 20px;">
    <span style="line-height:60px;font-size:20px;">字典项管理</span>
    <el-button @click="goBack" type="primary" style="float:right;margin-top:13px;">返回</el-button>
  </div>
  <!-- 字典项搜索卡片 -->
  <el-card style="margin:20px;height: 70px;">
    <el-form :inline="true">
      <el-form-item label="字典项名称">
        <el-input placeholder="请输入" style="width:220px;" v-model="searchForm.label"
                  @keydown.enter.prevent="selectDictOption"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button @click="resetSearch">重置</el-button>
        <el-button type="primary" @click="selectDictOption">搜索</el-button>
      </el-form-item>
    </el-form>
  </el-card>
  <el-card style="margin:20px;">
    <div style="margin:10px 0px 40px 10px;">
      字典项列表
      <el-button type="primary" style="float: right;margin-top:-3px;" @click="dialogVisible=true">新增字典项</el-button>
    </div>
    <el-table :data="dictOptionArr">
      <el-table-column type="index" label="编号" width="80" align="center"/>
      <el-table-column prop="label" label="字典项名称" align="center"/>
      <el-table-column prop="value" label="字典项值" align="center"/>
      <el-table-column prop="sort" label="字典项排序" align="center"/>
      <el-table-column prop="remark" label="备注信息" align="center" width="320"/>
      <el-table-column prop="createTime" label="创建时间" align="center"/>
      <el-table-column label="操作" align="center">
        <template #default="scope">
          <el-button type="primary" link @click="editDictOption(scope.row.id)">编辑</el-button>
          <el-button type="primary" link @click="deleteDictOption(scope.row.id)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
  </el-card>
  <!-- 保存字典项弹窗 -->
  <el-dialog :title="dialogTitle" v-model="dialogVisible" style="width:1000px;padding:40px;"
             :before-close="handleClose">
    <el-form label-width="80px" label-position="top">
      <el-form-item label="字典项名称">
        <el-input placeholder="请输入" v-model="saveDictOptionForm.label"></el-input>
      </el-form-item>
      <el-form-item label="字典项值">
        <el-input placeholder="请输入" v-model="saveDictOptionForm.value"></el-input>
      </el-form-item>
      <el-form-item label="字典项排序">
        <el-input placeholder="请输入" v-model="saveDictOptionForm.sort"></el-input>
      </el-form-item>
      <el-form-item label="备注信息">
        <el-input placeholder="请输入" v-model="saveDictOptionForm.remark"></el-input>
      </el-form-item>
    </el-form>
    <template #footer>
      <el-button @click="handleClose">取消</el-button>
      <el-button type="primary" @click="saveDictOption">保存</el-button>
    </template>
  </el-dialog>
</template>
<script setup>

</script>

<style scoped>

</style>