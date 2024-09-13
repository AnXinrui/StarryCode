<script setup lang="ts">
import { routes } from "../router/routes.ts";
import { useRoute, useRouter } from "vue-router";
import { onMounted, ref } from "vue";

const router = useRouter();
const route = useRoute();

// 计算当前选中的菜单项
let defaultSelectKey = ref([route.path]); // 初始化为当前路由

// 路由切换后更新选中的菜单项
router.afterEach((to) => {
  defaultSelectKey.value = [to.path]; // 更新选中的菜单项
  // console.log(defaultSelectKey.value);
});

const doMenuClick = async (key: string) => {
  await router.push({ path: key }); // 路由跳转
};
</script>

<template>
  <a-row class="grid-demo" style="margin-bottom: 16px; " align="center" :wrap="false">
    <a-col flex="100px">
      <div>100px</div>
    </a-col>
    <a-col flex="auto">
      <div class="menu-demo">
        <a-menu mode="horizontal" :selected-keys="defaultSelectKey" @menu-item-click="doMenuClick">
          <a-menu-item :style="{ padding: 0, marginRight: '38px' }" disabled>
            <div class="title-bar">
              <img class="logo" src="../assets/star.png" alt=""/>
              <div class="title">StarryCode</div>
            </div>
          </a-menu-item>
          <a-menu-item
              v-for="item in routes"
              :key="item.path"
              :path="item.path"
          >
            {{ item.name }}
          </a-menu-item>
        </a-menu>
      </div>
    </a-col>
    <a-col flex="100px">
      <div>anxr</div>
    </a-col>
  </a-row>

  <div>{{ defaultSelectKey }}</div>
</template>

<style scoped>
.menu-demo {
  box-sizing: border-box;
  width: 100%;
  padding: 20px;
}

.title-bar {
  display: flex;
  flex-direction: column;
  justify-content: space-evenly;
  align-items: center;
}

.logo {
  height: 40px;
}

.title {
  color: #444;
}
</style>
