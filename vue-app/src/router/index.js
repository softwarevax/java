import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

const router = new Router({
  mode: 'history',
  routes: [
    { path: '/home', component: () => import('@/view/Home')},
    { path: '/about', component: () => import('@/view/About') }
  ]
})

export default router;
 