import HelloWorld from "../components/HelloWorld.vue";
import {RouteRecordRaw} from "vue-router";
import Login from "../components/Login.vue";

export const routes: Array<RouteRecordRaw> = [
    {
        path: '/',
        name: 'home',
        component: HelloWorld
    },
    {
        path: '/about',
        name: 'login',
        component: Login
        // component: () => import('../components/Login.vue'),
    },
]