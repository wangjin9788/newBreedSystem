import Vue from 'vue'

import 'normalize.css/normalize.css'// A modern alternative to CSS resets

import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import locale from 'element-ui/lib/locale/lang/zh-CN' // lang i18n
import VCharts from 'v-charts'

import '@/styles/index.scss' // global css

import App from './App'
import router from './router'
import store from './store'

import '@/icons' // icon
import '@/permission' // permission control
import VueParticles from 'vue-particles'
import VueDirectiveImagePreviewer from 'vue-directive-image-previewer'
import 'vue-directive-image-previewer/dist/assets/style.css'
Vue.use(VueDirectiveImagePreviewer)

Vue.use(VueParticles)
Vue.use(ElementUI, { locale })
Vue.use(VCharts)

Vue.config.productionTip = false


import VueQuillEditor from 'vue-quill-editor'

// 引入样式
import 'quill/dist/quill.core.css'
import 'quill/dist/quill.snow.css'
import 'quill/dist/quill.bubble.css'
import Quill from 'quill'

import resizeImage from 'quill-image-resize-module' // 图片缩放组件引用
import { ImageDrop } from 'quill-image-drop-module'; // 图片拖动组件引用
Quill.register('modules/imageDrop', ImageDrop); // 注册
Quill.register('modules/resizeImage ', resizeImage ) // 注册
import VueQuill from '@/components/VueQuillEditor/index'
Vue.use(VueQuill)

Vue.use(VueQuillEditor)

import 'viewerjs/dist/viewer.css'
import Viewer from 'v-viewer'
Vue.use(Viewer)
Viewer.setDefaults({
  Options: {
    'inline': true,
    'button': true,
    'navbar': true,
    'title': true,
    'toolbar': true,
    'tooltip': true,
    'movable': true,
    'zoomable': true,
    'rotatable': true,
    'scalable': true,
    'transition': true,
    'fullscreen': true,
    'keyboard': true,
    'url': 'data-source'
  }
})
new Vue({
  el: '#app',
  router,
  store,
  template: '<App/>',
  components: { App }
})


