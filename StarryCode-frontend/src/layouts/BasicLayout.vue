<script setup lang="ts">

import GlobalHeader from "../components/GlobalHeader.vue";
</script>

<template>
  <a-layout style="min-height: 100vh;">
    <a-layout-header class="header" >
      <GlobalHeader />
    </a-layout-header>
    <a-layout-content class="content">Content</a-layout-content>
    <a-layout-footer class="footer">Footer</a-layout-footer>
  </a-layout>
</template>

<style scoped>
.header {
  margin-top: 8px;
}
 .content {
   background: linear-gradient(to right, #aaa, #fff);
   margin-bottom: 16px;
 }
 .footer {
   background-color: #efefef;
   padding: 16px;
   position: sticky;
   bottom: 0;
   left: 0;
   right: 0;
   text-align: center;
 }
</style>