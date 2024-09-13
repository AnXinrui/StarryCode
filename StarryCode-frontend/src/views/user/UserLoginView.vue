<script setup lang="ts">
import {reactive} from "vue";
import useUserStore from "@/store/modules/user.ts";
import { Notification } from '@arco-design/web-vue';

const loginForm = reactive({
  userName: '',
  userPassword: ''
});

const userStore = useUserStore();
const handleLogin = async () => {
  try {
    await userStore.userLogin(loginForm);
    Notification.success('登录成功!')
  } catch (error) {
    Notification.error('登录失败!')
  }
}
</script>

<template>
  <div class="login-container">
    <a-row class="grid-demo">
      <a-col :span="12"/>
      <a-col :span="12">
        <div class="login-form">
          <div style="text-align: center">
            <h2>欢迎来的 StarryCode⭐</h2>
          </div>
          <a-form :model="loginForm" :style="{ width: '400px' }"  @submit="handleLogin">
            <a-form-item field="userName" label="用户名">
              <a-input
                  v-model="loginForm.userName"
                  placeholder="please enter your username..."
              />
            </a-form-item>
            <a-form-item field="userPassword" label="密  码">
              <a-input-password v-model="loginForm.userPassword" placeholder="please enter your password..." />
            </a-form-item>
            <a-form-item>
              <a-button html-type="submit">登录</a-button>
            </a-form-item>
          </a-form>
        </div>
      </a-col>
    </a-row>
  </div>
</template>

<style scoped>
.login-container {
  height: 100vh;
  width: 100%;
  background: url("https://files.codelife.cc/wallhaven/full/ey/wallhaven-eyzx5k.jpg");
  background-size: cover;

  .login-form {
    width: 60%;
    position: relative;
    top: 30vh;
    left: 10%;
    background-color: pink;
    padding: 6px;
  }

  h2 {
    margin: 20px 0;
  }
}
</style>