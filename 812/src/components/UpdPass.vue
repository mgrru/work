<template>
  <el-dialog v-model="upd_pass_dialog_visible" title="修改密码" width="500" draggable>
    <el-form>
      <el-form-item label="旧密码">
        <el-input v-model="old_pass" style="width: 240px" type="password" placeholder="Please input old password"
          show-password clearable />
      </el-form-item>
      <el-form-item label="新密码">
        <el-input v-model="new_pass" style="width: 240px" type="password" placeholder="Please input new password"
          show-password clearable />
      </el-form-item>
      <el-form-item label="确认新密码">
        <el-input v-model="confirm_pass" style="width: 240px" type="password"
          placeholder="Please input new password again" show-password clearable />
      </el-form-item>
    </el-form>
    <template #footer>
      <div class="dialog-footer">
        <el-button @click="upd_pass_dialog_visible = false">取消</el-button>
        <el-button type="primary" @click="upd_pass_submit">
          确定
        </el-button>
      </div>
    </template>
  </el-dialog>
</template>

<script lang="ts" setup>
import { ref, type ModelRef } from 'vue'
import {
  ElDialog,
  ElInput,
  ElButton,
  ElForm,
  ElFormItem,
  ElMessage,
} from 'element-plus'

const upd_pass_dialog_visible = defineModel('visible', { default: false, required: true })
const user_pass = defineModel('user_pass', { default: '', required: true })

const old_pass = ref('')
const new_pass = ref('')
const confirm_pass = ref('')

const upd_pass_submit = () => {
  upd_pass_dialog_visible.value = false
  if (user_pass.value == old_pass.value && new_pass.value == confirm_pass.value && new_pass.value.length > 0) {
    user_pass.value = new_pass.value
    ElMessage.success('修改成功!')
  } else {
    ElMessage.error('修改失败')
  }
}
</script>