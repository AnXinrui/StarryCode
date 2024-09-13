import HelloWorld from "@/components/HelloWorld.vue";
import {RouteRecordRaw} from "vue-router";
import Login from "@/components/Login.vue"


export const routes: Array<RouteRecordRaw> = [
    {
        path: '/',
        name: 'home',
        component: HelloWorld
    },
    {
        path: '/about',
        name: 'ab',
        component: Login
        // component: () => import('../components/Login.vue'),
    },
    {
        path: '/login',
        component: () => import('@/views/user/UserLoginView.vue'),
        name: 'login',
    },
    {
        path: '/404',
        component: () => import('../views/NotFoundView.vue'),
        name: '404',
    }
]