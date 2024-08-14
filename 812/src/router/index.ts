import { createRouter, createWebHistory } from 'vue-router'
import MainView from '@/views/MainView.vue'
import LoginView from '@/views/LoginView.vue'
import EChartsView from '@/views/EChartsView.vue'
import MemberView from '@/views/member/MemberView.vue'
import MemberStatView from '@/views/member/MemberStatView.vue'
import NewsView from '@/views/news/NewsView.vue'
import NewsAddView from '@/views/news/NewsAddView.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'login',
      component: LoginView
    },
    {
      path: '/main',
      name: 'main',
      component: MainView,
      redirect: '/main/echarts',
      children: [
        {
          path: 'echarts',
          component: EChartsView
        },
        {
          path: 'member/info',
          component: MemberView
        },
        {
          path: 'member/stat',
          component: MemberStatView
        },
        {
          path: 'news/info',
          component: NewsView
        },
        {
          path: 'news/add',
          component: NewsAddView
        },
      ]
    },
  ]
})

export default router
