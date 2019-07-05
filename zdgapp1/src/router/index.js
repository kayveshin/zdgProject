import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/index',
      name: 'HelloWorld',
      component: (resolve)=>require('@/components/HelloWorld',resolve)
    },{
    	path:'/',
    	name:'login',
    	component: (resolve)=>require('@/components/Login',resolve)
    },{
    	path:'/register',
    	name:'register',
    	component: (resolve)=>require('@/components/register',resolve)
    },{
    	path:'/openOrder',
    	name:'openOrder',
    	component: (resolve)=>require('@/components/openOrder',resolve)
    },{
    	path:'/unaccept',
    	name:'unaccept',
    	component: (resolve)=>require('@/components/unaccept',resolve)
    }
  ]
})
