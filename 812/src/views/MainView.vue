<template>
  <el-container class="container">
    <el-header class="header">
      <Top />
    </el-header>
    <el-container>
      <el-aside class="sidebar">
        <Sidebar />
      </el-aside>
      <el-container>
        <el-main>
          <Content />
        </el-main>
        <el-footer class="footer">
          <Footer />
        </el-footer>
      </el-container>
    </el-container>
  </el-container>
</template>

<script setup lang="ts">
  import { ElContainer, ElHeader, ElAside, ElMain, ElFooter } from 'element-plus'
  import Content from '@/components/Content.vue'
  import Footer from '@/components/Footer.vue'
  import Sidebar from '@/components/Sidebar.vue'
  import Top from '@/components/Top.vue'
</script>

<style scoped>
  .container {
    display: flex;
    flex-direction: column;
    height: 100vh;
  }

  .header {
    height: 100px;
    line-height: 100px;
    background-color: antiquewhite;
  }

  .footer {
    height: 60px;
    line-height: 60px;
    background-color: aqua;
  }

  .header,
  .footer {
    text-align: center;
    color: black;
    margin: 0;
    padding: 0;
  }

  .sidebar {
    width: 200px;
    background-color: blueviolet;
  }
</style>