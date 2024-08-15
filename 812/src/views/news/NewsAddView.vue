<template>
  <el-form :model="add_form">
    <el-form-item label="标题" :label-width="dialog_form_label_width">
      <el-input v-model="add_form.title" autocomplete="off" />
    </el-form-item>
    <el-form-item label="新闻类别" :label-width="dialog_form_label_width">
      <el-select v-model="add_form.typeid" placeholder="新闻类别" clearable>
        <el-option label="全部" value="" />
        <el-option v-for="item in news_type" :key="item.id" :label="item.typename" :value="item.id" />
      </el-select>
    </el-form-item>
    <el-form-item label="摘要" :label-width="dialog_form_label_width">
      <el-input v-model="add_form.describe" autocomplete="off" />
    </el-form-item>
    <el-form-item label="内容" :label-width="dialog_form_label_width">
      <el-input v-model="add_form.content" :rows="10" type="textarea" autocomplete="off" />
    </el-form-item>
    <el-form-item label="发布日期" :label-width="dialog_form_label_width">
      <el-date-picker v-model="add_form.publishDate" type="datetime" placeholder="发布日期"
        value-format="YYYY-MM-DD HH:mm:ss" clearable />
    </el-form-item>
  </el-form>
  <div class="dialog-footer">
    <el-button @click="on_add_reset">取消</el-button>
    <el-button type="primary" @click="on_add_submit">添加</el-button>
  </div>
</template>

<script setup lang="ts">
import http from '@/utils/http'
import {
  ElMessage,
  ElForm,
  ElFormItem,
  ElInput,
  ElSelect,
  ElOption,
  ElDatePicker,
  ElButton
} from 'element-plus'
import { onMounted, ref, type Ref } from 'vue'

interface NewsType {
  id: number | string
  typename: string
}
const news_type: Ref<NewsType[]> = ref([])
const get_news_type = () => {
  http
    .get('https://apifoxmock.com/m1/4895043-4550821-default/NewsType')
    .then(res => {
      const data = res.data
      if (data.code = 200) {
        news_type.value = data.data
      }
    })
}

const dialog_add = ref(false)
const dialog_form_label_width = '100px'
const add_form_origin = {
  title: '',
  describe: '',
  content: '',
  typeid: '',
  publishDate: ''
}

const add_form = ref({ ...add_form_origin })
const on_add_submit = () => {
  console.log(add_form)
  ElMessage.success('添加成功!')
  on_add_reset()
}

const on_add_reset = () => {
  dialog_add.value = false
  Object.assign(add_form.value, add_form_origin)
}

onMounted(()=>{
  get_news_type()
})
</script>