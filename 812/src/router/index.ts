import { createRouter, createWebHistory } from 'vue-router'
import MainView from '@/views/MainView.vue'
import LoginView from '@/views/LoginView.vue'

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
      component: MainView
    },
  ]
})

export default router
