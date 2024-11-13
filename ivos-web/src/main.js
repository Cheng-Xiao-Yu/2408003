import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
//1.引入element-plus组件库
import ElementPlus, {ElMessage} from 'element-plus'
import 'element-plus/dist/index.css'
//3.引入element-plus图标库
import * as ElementPlusIconsVue from '@element-plus/icons-vue'
//5.1修改elementPlus默认中文
import zhCn from 'element-plus/dist/locale/zh-cn.mjs'
//9.1配置根路径
const BASE_URL='http://localhost:8080';
//window是内置的全局对象，给它设置属性，此属性可以在任意的script标签中使用！
window.BASE_URL=BASE_URL;
const app = createApp(App)
//给app也就是vue实例也设置根路径，这样可以在任意template标签中使用！
app.config.globalProperties.BASE_URL=BASE_URL;
//4.遍历ElementPlusIconsVue对象中的所有图标组件并注册到app中
for (const [key, component] of Object.entries(ElementPlusIconsVue)) {
    app.component(key, component)
}

//2.app.use(ElementPlus) 使用Element-plus组件库
//5.2 app.use(ElementPlus,{ locale: zhCn })将El本地化为中文
app.use(ElementPlus,{ locale: zhCn }).use(store).use(router).mount('#app')

//6.解决ResizeObserver Error
const debounce = (fn, delay) => {
    let timer = null;
    return function () {
        let context = this;
        let args = arguments;
        clearTimeout(timer);
        timer = setTimeout(function () {
            fn.apply(context, args);
        }, delay);
    }
}
const _ResizeObserver = window.ResizeObserver;
window.ResizeObserver = class ResizeObserver extends _ResizeObserver {
    constructor(callback) {
        callback = debounce(callback, 16);
        super(callback);
    }
}
window.getUser=()=>{
    return localStorage.user ? JSON.parse(localStorage.user):null;
}

router.beforeEach((to, from, next)=>{
    let user =localStorage.user;
    if (to.path !== '/login' && !user && to.path !=='/')
        next({path:'/login',query:{redirect:to.fullPath}},ElMessage.error('请先登录'))
    else
        next()
})