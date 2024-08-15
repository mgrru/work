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
            <el-dropdown-item @click="upd_photo" :icon="User">修改头像</el-dropdown-item>
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
import { onMounted, ref, type Ref } from 'vue'
import http from '@/utils/http'

const userInfo = ref({
  userId: '1',
  username: 'default',
  mobile: '1',
  userphoto: DefaultPhoto
})

const get_user_info_from_session = () => {
  let user_str = sessionStorage.getItem("login_user")
  if (user_str != undefined && user_str.length > 0) {
    let user_obj = JSON.parse(user_str)
    Object.assign(userInfo.value, user_obj)
    console.log(userInfo.value)
  }
}

interface UpdInfo {
  userphone: string
  userid: number | string
}

const upd_data: Ref<UpdInfo> = ref({
  userphone: userInfo.value.userphoto,
  userid: userInfo.value.userId
})

const upd_photo = () => {
  console.log(userInfo.value)
  upd_data.value.userid = userInfo.value.userId
  upd_data.value.userphone = userInfo.value.userphoto
  console.log(upd_data.value)
  http.post('https://apifoxmock.com/m1/4895043-4550821-default/Rephone',
    upd_data.value
  ).then(res => {
    console.log(res.data.data)
    userInfo.value.userphoto = res.data.data.userphone
  })
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