import {createApp} from 'vue'
import '@arco-design/web-vue/dist/arco.css';
import ArcoVue from '@arco-design/web-vue';
import router from "./router";
import pinia from "./store";
import App from './App.vue'

const app = createApp(App)

app.use(ArcoVue)
app.use(router)
app.use(pinia)
app.mount('#app')