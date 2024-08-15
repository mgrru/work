<template>
  <div class="login">

    <el-row>
      <el-col :span="16" :offset="16">
        <h3>管理员登录</h3>
        <el-form ref="ruleFormRef" :model="ruleForm" status-icon :rules="rules" label-width="auto"
          class="demo-ruleForm">
          <el-form-item label="账号" prop="username">
            <el-input v-model="ruleForm.username" />
          </el-form-item>
          <el-form-item label="密码" prop="userpass">
            <el-input v-model="ruleForm.userpass" />
          </el-form-item>
          <el-form-item>
            <el-button type="primary" @click="submitForm(ruleFormRef)">
              登录
            </el-button>
            <el-button @click="resetForm(ruleFormRef)">取消</el-button>
          </el-form-item>
        </el-form>
      </el-col>
    </el-row>

  </div>
</template>

<script lang="ts" setup>
import { ref } from 'vue'
import { ElRow, ElCol, ElForm, ElFormItem, ElInput, ElButton, ElMessage, type FormInstance, type FormRules, ElTable } from 'element-plus'
import http from '@/utils/http'
import router from '@/router'

interface RuleForm {
  username: string
  userpass: string
}

const ruleFormRef = ref<FormInstance>()
const ruleForm = ref<RuleForm>({
  username: 'admin',
  userpass: 'Abc123'
})
const rules = ref<FormRules<RuleForm>>({
  username: [
    { required: true, message: '请填写账号', trigger: 'blur' },
    {
      min: 3, message: '至少3个字符', trigger: 'blur'
    }
  ],
  userpass: [
    { required: true, message: '请填写密码', trigger: 'blur' },
    {
      pattern: /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}$/, message: '密码至少6位，且包含大小写字母和数字', trigger: 'blur'
    }
  ]
})


const submitForm = (formEl: FormInstance | undefined) => {
  if (!formEl) return
  formEl.validate((valid) => {
    if (valid) {
      http.post('https://apifoxmock.com/m1/4895043-4550821-default/LoginAction',
        ruleForm.value
      ).then(
        res => {
          const data = res.data
          if (data.code == 200) {
            ElMessage.success("登录成功")
            // 数据存储
            // token
            localStorage.setItem("token", data.data.token)
            // 登录者信息
            sessionStorage.setItem("login_user", JSON.stringify(data.data.user))
            console.log(data.data.user)
            // 页面跳转
            router.push('/main')
          } else {
            ElMessage.error('登录失败')
          }

        }
      )
    } else {
      console.log("校验失败")
    }
  })
}

const resetForm = (formEl: FormInstance | undefined) => {
  if (!formEl) return
  formEl.resetFields()
}
</script>

<style scoped>
.login {
  width: 100%;
  height: 100%;
  background: url(../assets/img/bg.png) no-repeat top right;
  background-size: cover;
  display: flex;
  align-items: center;
  color: black;

}
</style>
