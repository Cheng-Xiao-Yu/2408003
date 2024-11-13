import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'

const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView
  },
  {
    path: '/about',
    name: 'about',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/AboutView.vue')
  },{
  path: '/a1',
      name: 'a',
      // route level code-splitting
      // this generates a separate chunk (about.[hash].js) for this route
      // which is lazy-loaded when the route is visited.
      component: () => import(/* webpackChunkName: "about" */ '../views/Aview.vue')
},{path: '/b', component: () => import('../views/BView')},
  {path: '/c', component: () => import('../views/CView')},
  {path: '/d', component: () => import('../views/DView')},
  {path: '/e', component: () => import('../views/EView')},
  {path: '/f', component: () => import('../views/FView')},
  {path: '/g', component: () => import('../views/GView')},
  {path: '/h', component: () => import('../views/HView')},
  {path: '/i', component: () => import('../views/IView')},
  {path: '/j', component: () => import('../views/JView')},
  {path: '/k', component: () => import('../views/KView.vue')},
  {path: '/l', component: () => import('../views/LView.vue')},
  {path: '/m', component: () => import('../views/MView.vue')},
  {path: '/n', component: () => import('../views/NView.vue')},
  {path: '/o', component: () => import('../views/OView.vue')},
  {path: '/p', component: () => import('../views/PView.vue')},
  {path: '/q', component: () => import('../views/QView.vue')},
  {path: '/r', component: () => import('../views/RView.vue')},
  {path: '/r1', component: () => import('../views/R1View.vue')},
  {path: '/s', component: () => import('../views/SView.vue')},
  {path: '/t', component: () => import('../views/TView.vue')},
  {path: '/u', component: () => import('../views/UView.vue')},
  {path: '/v', component: () => import('../views/VView.vue')},
  {path: '/w', component: () => import('../views/WView.vue')},
  {path: '/x', component: () => import('../views/XView.vue')},
  {path: '/y', component: () => import('../views/YView.vue')},
  {path: '/z', component: () => import('../views/ZView.vue')},
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
