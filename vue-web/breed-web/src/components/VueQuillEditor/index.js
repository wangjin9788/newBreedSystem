import QuillEditor from './index.vue'
const newQuillEditor= {
  install: function(Vue) {
    Vue.component('VueQuill', QuillEditor)
  }
}
export default newQuillEditor
