// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import axios from 'axios'
import 'bootstrap/dist/css/bootstrap.min.css'
import commondata from './assets/commondata'
import commonfun from './assets/commonfun'

Vue.prototype.$axios = axios;
Vue.prototype.$commondata = commondata;
Vue.prototype.$commonfun=commonfun;


Vue.config.productionTip = false

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})
