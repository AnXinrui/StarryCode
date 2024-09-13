import {defineStore} from "pinia";
import {Result} from "@/utils/ResultType.ts";
import {reqLogin} from "@/api/user";
import type {loginForm} from './type.ts'

let useUserStore = defineStore('User', {
    state: () => {
        return {}
    },
    actions: {
        async userLogin(data: loginForm) {
            // console.log(data, 'data')
            const result: Result = await reqLogin(data);
            console.log(result, 'result');
            if (result.code == 0) {
                return result.data;
            } else {
                return Promise.reject(new Error(result.message));
            }
        }
    },
    getters: {}
})

export default useUserStore;