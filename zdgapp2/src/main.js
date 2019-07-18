// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import axios from 'axios'
import 'bootstrap/dist/css/bootstrap.min.css'
import commonapi from './assets/commonapi'
import { JSEncrypt } from 'jsencrypt'

axios.defaults.withCredentials=true;
Vue.prototype.$axios = axios;
Vue.prototype.$commonapi = commonapi;
Vue.prototype.$enCode=function(password,publicKey){
	let encrypt=new JSEncrypt();
	encrypt.setPublicKey(publicKey);
	let data=encrypt.encrypt(password);
	return data;
}


Vue.config.productionTip = false

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})
