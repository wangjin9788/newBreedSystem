import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

/* Layout */
import Layout from '../views/layout/Layout'

/**
 * hidden: true                   if `hidden:true` will not show in the sidebar(default is false)
 * alwaysShow: true               if set true, will always show the root menu, whatever its child routes length
 *                                if not set alwaysShow, only more than one route under the children
 *                                it will becomes nested mode, otherwise not show the root menu
 * redirect: noredirect           if `redirect:noredirect` will no redirct in the breadcrumb
 * name:'router-name'             the name is used by <keep-alive> (must set!!!)
 * meta : {
    title: 'title'               the name show in submenu and breadcrumb (recommend set)
    icon: 'svg-name'             the icon show in the sidebar,
  }
 **/
export const constantRouterMap = [
  {path: '/login', component: () => import('@/views/login/index'), hidden: true},
  {path: '/404', component: () => import('@/views/404'), hidden: true},
  {
    path: '',
    component: Layout,
    redirect: '/home',
    children: [{
      path: 'home',
      name: 'home',
      component: () => import('@/views/home/index'),
      meta: {title: '首页', icon: 'home'}
    }]
  }
]

export const asyncRouterMap = [
  {
    path: '/breedData',
    component: Layout,
    redirect: 'breedData',
    name: 'breedData',
    meta: {title: '养殖资料', icon: 'breedData'},
    children: [

      {
        path: 'biology',
        name: 'biology',
        component: () => import('@/views/breedData/index'),
        meta: {title: '生物学特性',icon: 'breed-info',number:1},
      },
      {
        path: 'growBreed',
        name: 'growBreed',
        component: () => import('@/views/breedData/index'),
        meta: {title: '生长繁殖育种特点',icon: 'breed-info',number:2}
      },
      {
        path: 'breedPattern',
        name: 'breedPattern',
        component: () => import('@/views/breedData/index'),
        meta: {title: '养殖方式',icon: 'breed-info',number:3}
      },
      {
        path: 'feedPreparation',
        name: 'feedPreparation',
        component: () => import('@/views/breedData/index'),
        meta: {title: '饲料配置',icon: 'breed-info',number:4}
      },
      {
        path: 'feedingManagement',
        name: 'feedingManagement',
        component: () => import('@/views/breedData/index'),
        meta: {title: '饲养管理',icon: 'breed-info',number:5}
      },
      {
        path: 'diseaseControl',
        name: 'diseaseControl',
        component: () => import('@/views/breedData/index'),
        meta: {title: '病害防治',icon: 'breed-info',number:6}
      },
      {
        path: 'addBreedData',
        name: 'addBreedData',
        component: () => import('@/views/breedData/add'),
        meta: {title: '添加养殖资料'},
        hidden: true
      },
      {
        path: 'updateBreedData',
        name: 'updateBreedData',
        component: () => import('@/views/breedData/update'),
        meta: {title: '修改养殖资料'},
        hidden: true
      },

    ]},
  {
    path: '/formulaCla',
    component: Layout,
    redirect: 'formulaCla',
    name: 'formulaCla',
    meta: {title: '配方计算', icon: 'cla'},
    children: [
      {
        path: 'formulaInfo',
        name: 'formulaInfo',
        component: () => import('@/views/formulaCla/feedFormula/index'),
        meta: {title: '配方信息', icon: 'feedFormula'},
      },
      {
        path: 'formulaInfoCla',
        name: 'formulaInfoCla',
        component: () => import('@/views/formulaCla/feedFormula/cla/formulaClaDetail'),
        meta: {title: '配方计算'},
        hidden: true
      },
      {
        path: 'cla',
        name: 'cla',
        component: () => import('@/views/formulaCla/nutritionCla/index'),
        meta: {title: '营养计算', icon: 'cla'},
      },
      {
        path: 'rate',
        name: 'rate',
        component: () => import('@/views/formulaCla/nutritionRate/index'),
        meta: {title: '查看比例'},
        hidden: true
      },
    ]},

  {
    path: '/breed',
    component: Layout,
    redirect: 'breed/breedInfo',
    name: 'breed',
    meta: {title: '养殖管理', icon: 'breed'},
    children: [
      {
        path: 'breedInfo',
        name: 'breedInfo',
        component: () => import('@/views/breed/breedInfo/index'),
        meta: {title: '养殖信息',icon: 'breed-info'}
      },
      {
        path: 'addBreed',
        name: 'addBreed',
        component: () => import('@/views/breed/breedInfo/add'),
        meta: {title: '添加养殖信息'},
        hidden: true
      },
      {
        path: 'updateBreed',
        name: 'updateBreed',
        component: () => import('@/views/breed/breedInfo/update'),
        meta: {title: '修改养殖信息'},
        hidden: true
      },

      {
        path: 'breedModel',
        name: 'breedModel',
        component: () => import('@/views/breed/breedModel/index'),
        meta: {title: '养殖模型',icon: 'breed-model'},
      },
      {
        path: 'addBreedModel',
        name: 'addBreedModel',
        component: () => import('@/views/breed/breedModel/add'),
        meta: {title: '添加养殖信息'},
        hidden: true
      },
      {
        path: 'updateBreedModel',
        name: 'updateBreedModel',
        component: () => import('@/views/breed/breedModel/update'),
        meta: {title: '修改养殖信息'},
        hidden: true
      },
      {
        path: 'breedOut',
        name: 'breedOut',
        component: () => import('@/views/breed/breedInfo/breedOut/index'),
        meta: {title: '养殖结束列表'},
        hidden: true
      },
      {
        path: 'addBreedOut',
        name: 'addBreedOut',
        component: () => import('@/views/breed/breedInfo/breedOut/addOutInfo'),
        meta: {title: '添加养殖结束'},
        hidden: true
      },
      {
        path: 'operation',
        name: 'operation',
        component: () => import('@/views/breed/operation/index'),
        meta: {title: '养殖操作信息'},
        hidden: true
      },
      {
        path: 'addOperation',
        name: 'addOperation',
        component: () => import('@/views/breed/operation/add'),
        meta: {title: '添加操作信息'},
        hidden: true
      },
      {
        path: 'updateOperation',
        name: 'updateOperation',
        component: () => import('@/views/breed/operation/update'),
        meta: {title: '修改操作信息'},
        hidden: true
      },
      {
        path: 'addOperationLabel',
        name: 'addOperationLabel',
        component: () => import('@/views/breed/operationLabel/add'),
        meta: {title: '添加操作标签信息'},
        hidden: true
      },
      {
        path: 'updateOperationLabel',
        name: 'updateOperationLabel',
        component: () => import('@/views/breed/operationLabel/update'),
        meta: {title: '修改操作标签信息'},
        hidden: true
      },
      {
        path: 'testing',
        name: 'testing',
        component: () => import('@/views/breed/testing/index'),
        meta: {title: '检测信息'},
        hidden: true
      },
      {
        path: 'addTesting',
        name: 'addTesting',
        component: () => import('@/views/breed/testing/add'),
        meta: {title: '添加检测信息'},
        hidden: true
      },
      {
        path: 'updateTesting',
        name: 'updateTesting',
        component: () => import('@/views/breed/testing/update'),
        meta: {title: '修改检测信息'},
        hidden: true
      },
      {
        path: 'addExcLabel',
        name: 'addExcLabel',
        component: () => import('@/views/breed/excLabel/add'),
        meta: {title: '添加异常标签信息'},
        hidden: true
      },
      {
        path: 'updateExcLabel',
        name: 'updateExcLabel',
        component: () => import('@/views/breed/excLabel/update'),
        meta: {title: '修改异常标签信息'},
        hidden: true
      },
      {
        path: 'summary',
        name: 'summary',
        component: () => import('@/views/breed/treatSummary/index'),
        meta: {title: '治疗总结',icon: 'breed-summary'}
      },
      {
        path: 'summaryOperationInfo',
        name: 'summaryOperationInfo',
        component: () => import('@/views/breed/treatSummary/operation/index'),
        meta: {title: '总结操作信息'},
        hidden: true
      },
      {
        path: 'excInfo',
        name: 'excInfo',
        component: () => import('@/views/breed/excInfo/index'),
        meta: {title: '治疗信息'},
        hidden: true
      },
      {
        path: 'excOperation',
        name: 'excOperation',
        component: () => import('@/views/breed/excOperation/index'),
        meta: {title: '治疗操作信息'},
        hidden: true
      },
      {
        path: 'addExcOperation',
        name: 'addExcOperation',
        component: () => import('@/views/breed/excOperation/add'),
        meta: {title: '添加治疗操作信息'},
        hidden: true
      },
      {
        path: 'updateExcOperation',
        name: 'updateExcOperation',
        component: () => import('@/views/breed/excOperation/update'),
        meta: {title: '修改治疗操作信息'},
        hidden: true
      },

    ]
  },
  {
    path: '/feed',
    component: Layout,
    redirect: 'feed',
    name: 'feed',
    meta: {title: '饲料管理', icon: 'feed'},
    children: [
      {
        path: 'feedInfo',
        name: 'feedInfo',
        component: () => import('@/views/feed/feedInfo/index'),
        meta: {title: '饲料信息', icon: 'feed-info'},
      },
      {
        path: 'ferment',
        name: 'ferment',
        component: () => import('@/views/feed/ferment/index'),
        meta: {title: '发酵管理', icon: 'feed-ferment'},
      },


      {
        path: 'addFeedInfo',
        name: 'addFeedInfo',
        component: () => import('@/views/feed/feedInfo/add'),
        meta: {title: '添加饲料信息'},
        hidden: true
      },
      {
        path: 'updateFeedInfo',
        name: 'updateFeedInfo',
        component: () => import('@/views/feed/feedInfo/update'),
        meta: {title: '编辑饲料信息'},
        hidden: true
      },
      {
        path: 'addFerment',
        name: 'addFerment',
        component: () => import('@/views/feed/ferment/add'),
        meta: {title: '添加发酵'},
        hidden: true
      },
      {
        path: 'updateFerment',
        name: 'updateFerment',
        component: () => import('@/views/feed/ferment/update'),
        meta: {title: '修改发酵'},
        hidden: true
      },
      {
        path: 'addFermentTesting',
        name: 'addFermentTesting',
        component: () => import('@/views/feed/ferment/testing/testingDetail'),
        meta: {title: '添加发酵结束检测'},
        hidden: true
      },
      {
        path: 'fermentTesting',
        name: 'fermentTesting',
        component: () => import('@/views/feed/ferment/testing/index'),
        meta: {title: '查看发酵结束检测信息'},
        hidden: true
      },

    ]
  },
  {
    path: '/diseaseInfo',
    component: Layout,
    redirect: 'diseaseInfo',
    name: 'diseaseInfo',
    meta: {title: '病理管理', icon: 'diseaseInfo'},
    children: [
      {
        path: 'animalDisease',
        name: 'animalDisease',
        component: () => import('@/views/diseaseInfo/animalDisease/index'),
        meta: {title: '病理信息',icon: 'animalDisease'}
      },
      {
        path: 'addAnimalDisease',
        name: 'addAnimalDisease',
        component: () => import('@/views/diseaseInfo/animalDisease/add'),
        meta: {title: '添加养殖信息'},
        hidden: true
      },
      {
        path: 'updateAnimalDisease',
        name: 'updateAnimalDisease',
        component: () => import('@/views/diseaseInfo/animalDisease/update'),
        meta: {title: '修改养殖信息'},
        hidden: true
      },
      {
        path: 'nature',
        name: 'nature',
        component: () => import('@/views/diseaseInfo/nature/index'),
        meta: {title: '病理性质',icon: 'nature'},
      },
      {
        path: 'addNature',
        name: 'addNature',
        component: () => import('@/views/diseaseInfo/nature/add'),
        meta: {title: '添加病理性质'},
        hidden: true
      },
      {
        path: 'updateNature',
        name: 'updateNature',
        component: () => import('@/views/diseaseInfo/nature/update'),
        meta: {title: '修改病理性质'},
        hidden: true
      },
    ]
  },
  {
    path: '/exp',
    component: Layout,
    redirect: '/exp/pay',
    name: 'exp',
    meta: {title: '支出/营收', icon: 'exp'},
    children: [
      {
        path: 'pay',
        name: 'pay',
        component: () => import('@/views/exp/pay/index'),
        meta: {title: '支出', icon: 'pay'}
      },
      {
        path: 'revenue',
        name: 'revenue',
        component: () => import('@/views/exp/revenue/index'),
        meta: {title: '营收', icon: 'revenue'}
      },
      {
        path: 'addRevenue',
        name: 'addRevenue',
        component: () => import('@/views/exp/revenue/add'),
        meta: {title: '添加营收'},
        hidden: true
      },
      {
        path: 'updateRevenue',
        name: 'updateRevenue',
        component: () => import('@/views/exp/revenue/update'),
        meta: {title: '修改营收'},
        hidden: true
      },
      {
        path: 'addPay',
        name: 'addPay',
        component: () => import('@/views/exp/pay/add'),
        meta: {title: '添加支出'},
        hidden: true
      },
      {
        path: 'updatePay',
        name: 'updatePay',
        component: () => import('@/views/exp/pay/update'),
        meta: {title: '修改支出'},
        hidden: true
      },
    ]
  },
  {
    path: '/ums',
    component: Layout,
    redirect: '/ums/admin',
    name: 'ums',
    meta: {title: '系统权限', icon: 'ums'},
    children: [
      {
        path: 'admin',
        name: 'admin',
        component: () => import('@/views/ums/admin/index'),
        meta: {title: '用户列表', icon: 'ums-admin'}
      },
      {
        path: 'role',
        name: 'role',
        component: () => import('@/views/ums/role/index'),
        meta: {title: '角色列表', icon: 'ums-role'}
      },
      {
        path: 'allocMenu',
        name: 'allocMenu',
        component: () => import('@/views/ums/role/allocMenu'),
        meta: {title: '分配菜单'},
        hidden: true
      },
      {
        path: 'allocResource',
        name: 'allocResource',
        component: () => import('@/views/ums/role/allocResource'),
        meta: {title: '分配资源'},
        hidden: true
      },
      {
        path: 'menu',
        name: 'menu',
        component: () => import('@/views/ums/menu/index'),
        meta: {title: '菜单列表', icon: 'ums-menu'}
      },
      {
        path: 'addMenu',
        name: 'addMenu',
        component: () => import('@/views/ums/menu/add'),
        meta: {title: '添加菜单'},
        hidden: true
      },
      {
        path: 'updateMenu',
        name: 'updateMenu',
        component: () => import('@/views/ums/menu/update'),
        meta: {title: '修改菜单'},
        hidden: true
      },
      {
        path: 'resource',
        name: 'resource',
        component: () => import('@/views/ums/resource/index'),
        meta: {title: '资源列表', icon: 'ums-resource'}
      },
      {
        path: 'resourceCategory',
        name: 'resourceCategory',
        component: () => import('@/views/ums/resource/categoryList'),
        meta: {title: '资源分类'},
        hidden: true
      }
    ]
  },

  {path: '*', redirect: '/404', hidden: true}
]

export default new Router({
  // mode: 'history', //后端支持可开
  scrollBehavior: () => ({y: 0}),
  routes: constantRouterMap
})

