<template>
  <el-menu active-text-color="#ffd04b" default-active="/main/echarts" :router="true" background-color="#545c64"
    text-color="#fff">
    <el-menu-item index="/main/echarts">
      <el-icon>
        <Histogram />
      </el-icon>
      <span>数据统计</span>
    </el-menu-item>
    <el-sub-menu index="1">
      <template #title>
        <el-icon>
          <Avatar />
        </el-icon>
        <span>会员管理</span>
      </template>
      <el-menu-item index="/main/member/info">
        <el-icon>
          <Memo />
        </el-icon>
        <span>会员信息</span>
      </el-menu-item>
      <el-menu-item index="/main/member/stat">
        <el-icon>
          <Histogram />
        </el-icon>
        <span>会员统计</span>
      </el-menu-item>
    </el-sub-menu>
    <el-sub-menu index="2">
      <template #title>
        <el-icon>
          <Monitor />
        </el-icon>
        <span>新闻管理</span>
      </template>
      <el-menu-item index="/main/news/info">
        <el-icon>
          <ChromeFilled />
        </el-icon>
        <span>新闻信息</span>
      </el-menu-item>
      <el-menu-item index="/main/news/add">
        <el-icon>
          <Plus />
        </el-icon>
        <span>添加新闻</span>
      </el-menu-item>
    </el-sub-menu>
  </el-menu>
</template>

<script setup lang="ts">
  import { Avatar, ChromeFilled, Histogram, Memo, Monitor, Plus } from '@element-plus/icons-vue'
  import { ElMenu, ElMenuItem, ElSubMenu, ElIcon } from 'element-plus'
</script>