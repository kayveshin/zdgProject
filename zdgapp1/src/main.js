// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import axios from 'axios'
import 'bootstrap/dist/css/bootstrap.min.css'
import commondata from './assets/commondata'
import VueCookies from 'vue-cookies'


Vue.use(VueCookies);
Vue.config.productionTip = false;
Vue.prototype.$axios = axios;
Vue.prototype.$commondata = commondata;
Vue.prototype.$cookies = VueCookies;

/* eslint-disable no-new */
new Vue({
  el: '#App',
  router,
  components: { App },
  template: '<App/>'
})
