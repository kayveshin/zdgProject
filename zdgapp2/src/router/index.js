import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'login',
      component: (resolve)=>require(['../components/login'],resolve)
    },
    {
      path: '/register',
      name: 'register',
      component: (resolve)=>require(['../components/register'],resolve)
    },
    {
      path: '/acceptedOrder',
      name: 'acceptedOrder',
      component: (resolve)=>require(['../components/acceptedOrder'],resolve)
    },
    {
      path: '/applyCtrl/:id',
      name: 'applyCtrl',
      component: (resolve)=>require(['../components/applyCtrl'],resolve)
    },
    {
      path: '/dgCheck',
      name: 'dgCheck',
      component: (resolve)=>require(['../components/dgCheck'],resolve)
    },
    {
      path: '/openOrder',
      name: 'openOrder',
      component: (resolve)=>require(['../components/openOrder'],resolve)
    },
    {
      path: '/orderCtrl',
      name: 'orderCtrl',
      component: (resolve)=>require(['../components/orderCtrl'],resolve)
    },
    {
      path: '/unacceptedOrder',
      name: 'unacceptedOrder',
      component: (resolve)=>require(['../components/unacceptedOrder'],resolve)
    }
  ]
})
