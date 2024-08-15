<template>
  <!-- 面包屑导航 -->
  <el-breadcrumb separator="/">
    <el-breadcrumb-item :to="{ path: '/main' }">首页</el-breadcrumb-item>
    <el-breadcrumb-item>新闻管理</el-breadcrumb-item>
    <el-breadcrumb-item>新闻信息</el-breadcrumb-item>
  </el-breadcrumb>
  <!-- 搜索表单 -->
  <el-form :inline="true" :model="form_search" class="demo-form-inline">
    <el-form-item label="新闻标题">
      <el-input v-model="form_search.title" placeholder="标题关键字" clearable />
    </el-form-item>
    <el-form-item label="新闻类别">
      <el-select v-model="form_search.typeid" placeholder="新闻类别" clearable>
        <el-option label="全部" value="" />
        <el-option v-for="item in news_type" :key="item.id" :label="item.typename" :value="item.id" />
      </el-select>
    </el-form-item>
    <el-form-item label="发布日期">
      <el-date-picker v-model="form_search.publishDate" type="date" placeholder="发布日期" value-format="YYYY-MM-DD"
        clearable />
    </el-form-item>
    <el-form-item>
      <el-button type="primary" @click="on_search_submit">搜索</el-button>
      <el-button @click="on_search_reset">取消</el-button>
    </el-form-item>
  </el-form>
  <!-- 数据表格的工具栏 -->
  <el-button-group>
    <el-button type="primary" :icon="Plus" @click="handler_add" />
    <el-button type="danger" :icon="Delete" @click="handler_del_more" />
  </el-button-group>
  <!-- 数据表格 -->
  <el-table :data="news" stripe style="width: 100%;">
    <el-table-column type="selection" width="55" />
    <el-table-column prop="title" label="标题" width="250" />
    <el-table-column prop="describe" label="摘要" width="400" />
    <el-table-column prop="publishDate" label="发布日期" width="200" />
    <el-table-column label="操作">
      <template #default="scoped">
        <el-button size="small" @click="handle_edit(scoped.$index, scoped.row)" :icon="Edit">编辑</el-button>
        <el-button size="small" type="danger" @click="handle_delete(scoped.$index, scoped.row)"
          :icon="Delete">删除</el-button>
      </template>
    </el-table-column>
  </el-table>
  <!-- 分页导航 -->
  <el-pagination background style="margin-top: 20px;" layout="prev, pager, next, jumper" :total="page_info.total"
    @current-change="handle_current_change" />
  <!-- 更新新闻模态框 -->
  <el-dialog v-model="dialog_edit" title="更新新闻" width="800">
    <el-form :model="edit_form">
      <el-form-item label="新闻ID" label-width="dialog_form_label_width">
        <el-input v-model="edit_form.id" readonly />
      </el-form-item>
      <el-form-item label="标题" label-width="dialog_form_label_width">
        <el-input v-model="edit_form.title" autocomplete="off" />
      </el-form-item>
      <el-form-item label="新闻类别" label-width="dialog_form_label_width">
        <el-select v-model="edit_form.typeid" placeholder="新闻类别" clearable>
          <el-option v-for="item in news_type" :key="item.id" :label="item.typename" :value="item.id"
            :selected="edit_form.typeid == item.id" />
        </el-select>
      </el-form-item>
      <el-form-item label="摘要" label-width="dialog_form_label_width">
        <el-input v-model="edit_form.describe" autocomplete="off" />
      </el-form-item>
      <el-form-item label="内容" label-width="dialog_form_label_width">
        <el-input v-model="edit_form.content" :rows="10" type="textarea" autocomplete="off" />
      </el-form-item>
      <el-form-item label="发布日期" label-width="dialog_form_label_width">
        <el-date-picker v-model="edit_form.publishDate" type="datetime" placeholder="发布日期"
          value-format="YYYY-MM-DD HH:mm:ss" clearable />
      </el-form-item>
    </el-form>
    <template #footer>
      <div class="dialog-footer">
        <el-button @click="on_edit_reset">取消</el-button>
        <el-button type="primary" @click="on_edit_submit">更新</el-button>
      </div>
    </template>
  </el-dialog>
  <!-- 插入新闻模态框 -->
  <el-dialog v-model="dialog_add" title="添加新闻" width="800">
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
    <template #footer>
      <div class="dialog-footer">
        <el-button @click="on_add_reset">取消</el-button>
        <el-button type="primary" @click="on_add_submit">添加</el-button>
      </div>
    </template>
  </el-dialog>
</template>

<script setup lang="ts">
import http from '@/utils/http'
import { Delete, Edit, Plus } from '@element-plus/icons-vue'
import {
  ElBreadcrumb,
  ElBreadcrumbItem,
  ElForm,
  ElFormItem,
  ElInput,
  ElSelect,
  ElOption,
  ElDatePicker,
  ElButton,
  ElButtonGroup,
  ElTable,
  ElTableColumn,
  ElMessageBox,
  ElMessage,
  ElPagination,
  ElDialog
} from 'element-plus'
import { onMounted, ref, type Ref } from 'vue'

const form_search = ref({
  title: '',
  typeid: '',
  publishDate: ''
})

const on_search_submit = () => {
  console.log(form_search.value)
}

const on_search_reset = () => {
  form_search.value.title = ''
  form_search.value.typeid = ''
  form_search.value.publishDate = ''
}

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

// #region <!-- 数据表格的工具栏 -->
const handler_add = () => {
  dialog_add.value = true
}

const handler_del_more = () => {

}

// #endregion

// #region <!-- 数据表格 -->
interface New {
  id: number | string
  title: string
  describe: string
  content: string
  typeid: number | string
  publishDate: Date | string
}

const news: Ref<New[]> = ref([])
const get_news = () => {
  http.get('https://apifoxmock.com/m1/4895043-4550821-default/News',
    { params: Object.assign({}, form_search.value, page_info.value) }
  )
    .then(res => {
      if (res.data.code == 200) {
        news.value = res.data.data.rows
        page_info.value.total = res.data.data.total
      }
    })
}

const handle_edit = (index: number, row: New) => {
  console.log(index, row)
  Object.assign(edit_form.value, row)
  dialog_edit.value = true
}
const handle_delete = (index: number, row: New) => {
  console.log(index, row)
  ElMessageBox.confirm(
    "确认删除新闻: " + row.title + "?",
    "删除",
    {
      confirmButtonText: "删除",
      cancelButtonText: "取消",
      type: "warning"
    }
  ).then(() => {
    http.delete('https://apifoxmock.com/m1/4895043-4550821-default/Delete/' + row.id)
      .then(res => {
        if (res.data.code == 200) {
          get_news()
          ElMessage.success('删除成功！')
        }
      })
  })

}

// #endregion

// #region <!-- 分页导航 -->
const page_info = ref({
  currentpage: 1,
  pageSize: 10,
  total: 0
})
const handle_current_change = (val: number) => {
  page_info.value.currentpage = val
  get_news()
}

// #endregion

// #region <!-- 插入新闻模态框 -->
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

// #endregion

// #region <!-- 更新新闻模态框 -->
// 编辑对话框
const dialog_edit = ref(false)
const edit_form: Ref<New> = ref({
  id: '',
  title: '',
  describe: '',
  content: '',
  typeid: '',
  publishDate: ''
})

const on_edit_submit = () => {
  console.log(edit_form)
  ElMessage.success('更新成功!')
  get_news()
  on_edit_reset()
}
const on_edit_reset = () => {
  dialog_edit.value = false
}

// #endregion

onMounted(() => {
  get_news_type()
  get_news()
})
</script>

<style scoped>
.demo-form-inline {
  margin-top: 20px;
}

.demo-form-inline .el-input {
  --el-input-width: 220px;
}

.demo-form-inline .el-select {
  --el-select-width: 220px;
}
</style>