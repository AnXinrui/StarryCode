import request from '@/utils/request'
import type {loginForm} from './type.ts'
import {Result} from "@/utils/ResultType.ts";

enum API {
    LOGIN_URL = '/user/login',
    CURRENT_USER = '/user/current',
    LOGOUT_URL = '/user/logout',
}

/**
 * 用户登录
 * @param data
 */
export const reqLogin = (data: loginForm) =>
    request.post<any, Result>(API.LOGIN_URL, data);

/**
 * 获取当前登录登录用户
 */
export const reqCurrentUser = () =>
    request.get<any, Result>(API.CURRENT_USER);

/**
 * 用户登出
 */
export const reqLogout = () =>
    request.post<any, Result>(API.LOGOUT_URL);