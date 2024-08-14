<template>

  <el-row>
    <el-col :span="4">新闻系统后台管理</el-col>
    <el-col :span="1" :offset="17">
      <el-avatar :size="50" :src="userInfo.userphoto" style="margin-top: 25px;" />
    </el-col>
    <el-col :span="2">
      <el-dropdown>
        <span class="el-dropdown-link">{{ userInfo.username }}</span>
        <template #dropdown>
          <el-dropdown-menu>
            <el-dropdown-item :icon="User">修改头像</el-dropdown-item>
            <el-dropdown-item :icon="Setting">修改密码</el-dropdown-item>
            <el-dropdown-item divided :icon="CircleClose">退出</el-dropdown-item>
          </el-dropdown-menu>
        </template>
      </el-dropdown>
    </el-col>
  </el-row>

</template>

<script setup lang="ts">
  import { CircleClose, Setting, User } from '@element-plus/icons-vue'
  import { ElCol, ElRow, ElDropdown, ElDropdownItem, ElDropdownMenu, ElAvatar } from 'element-plus'
  import DefaultPhoto from '@/assets/img/bg.png'
  import { onMounted, ref } from 'vue'

  const userInfo = ref({
    userId: '',
    username: 'default',
    mobile: '',
    userphoto: DefaultPhoto
  })

  const get_user_info_from_session = () => {
    let user_str = sessionStorage.getItem("login_user")
    if (user_str != undefined && user_str.length > 0) {
      let user_obj = JSON.parse(user_str)
      Object.assign(userInfo.value, user_obj)
    }
  }

  onMounted(() => {
    get_user_info_from_session()
  })

</script>

<style scoped>

  .el-dropdown-link {
    cursor: pointer;
    color: var(--el-color-primary);
    display: flex;
    align-items: center;
    line-height: 40px;
    margin-top: 30px;
  }
</style>