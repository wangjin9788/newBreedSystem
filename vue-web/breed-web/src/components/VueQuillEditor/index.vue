<template>
  <div class="hello">
    <single-upload
      class="avatar-uploader"
      :action="pload"
      v-model="pload"
      :show-file-list="false"
      style="display:none"
      @input="handleChange"
      ref='upload'
      accept=".jpg,.jpeg,.png,.bmp,.JPG,.JPEG,.PBG,.BMP"
    >
      <i class="el-icon-plus avatar-uploader-icon"></i>
    </single-upload>
    <quill-editor v-model="content" ref="QuillEditor"
                  :options="editorOption"
                  @change="onEditorChange($event)"></quill-editor>

  </div>
</template>

<script>
import 'quill/dist/quill.core.css'
import 'quill/dist/quill.snow.css'
import 'quill/dist/quill.bubble.css'
import Quill from 'quill'
import {ImageDrop} from 'quill-image-drop-module'
import ImageResize from 'quill-image-resize-module'
import SingleUpload from '@/components/Upload/singleUpload';

Quill.register('modules/imageDrop', ImageDrop)
Quill.register('modules/imageResize', ImageResize)

//自定义字体类型
var fonts = [
  "SimSun",
  "SimHei",
  "Microsoft-YaHei",
  "KaiTi",
  "FangSong",
  "Arial",
  "Times-New-Roman",
  "sans-serif"
];
var Font = Quill.import("formats/font");
Font.whitelist = fonts; //将字体加入到白名单
Quill.register(Font, true);
const toolbarOptions = [
  [{color: []}, {background: []}],
  ["bold", "italic", "underline", "strike"],
  [{size: ["small", false, "large"]}],
  [{list: "ordered"}, {list: "bullet"}],
  [{script: "sub"}, {script: "super"}],
  [{indent: "-1"}, {indent: "+1"}],
  [{direction: "rtl"}],
  [{header: 1}, {header: 2}],
  ["link", "image"],
  ["link"],
  ["blockquote", "code-block"],
  [{font: []}],
  [{align: []}],
];
export default {
  name: 'HelloWorld',
  components: {
    SingleUpload
  },
  props: {
    value: {
      type: String,
      default: ""
    }
  },
  watch: {
    value(val) {
      this.content = val;
    },
  },
  data() {
    return {
      contentCode: '',
      content: '',
      pload: '123',
      editorOption: {
        modules: {
          toolbar: {
            container: toolbarOptions,  // 工具栏
            handlers: {
              'image': function (value) {
                if (value) {
                  document.querySelector('.el-upload').click()
                  //触发element upload 单机事件
                } else {
                  this.quill.format('image', false);
                }
              }
            }
          },
          history: {
            delay: 1000,
            maxStack: 50,
            userOnly: false
          },
          imageDrop: true,
          imageResize: {
            displayStyles: {
              backgroundColor: 'black',
              border: 'none',
              color: 'white'
            },
            modules: ['Resize', 'DisplaySize', 'Toolbar']
          }
        },
        placeholder: '输入内容........'
      }
    }
  },

  methods: {
    onEditorChange(e) {
      this.$emit("input", e.html);
    },
    handleChange(data) {
      // res.url 是上传成功后的图片网络地址
      let quill = this.$refs.QuillEditor.quill
      let length = quill.getSelection().index;
      //向富文本内容中插入图片
      quill.insertEmbed(length, 'image', data)
      // 移动焦点光标位置
      quill.setSelection(length + 1)
    }
  },

}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped lang='scss'>
</style>
