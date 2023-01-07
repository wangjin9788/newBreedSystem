<template>
  <el-card class="form-container" shadow="never">
    <el-form :model="nature"
             ref="natureFrom"
             label-width="150px">
      <el-form-item v-show="false" label="id：" prop="nature" isEdit>
        <el-input v-model.trim="nature.nid"></el-input>
      </el-form-item>
      <el-form-item label="病理性质：" prop="nature" isEdit>
        <el-input v-model.trim="nature.nature"></el-input>
      </el-form-item>
      <el-form-item label="病理说明：" prop="nature" isEdit>
        <quill-editor v-model="nature.natureExplain" :options="quillOption"></quill-editor>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onSubmit('natureFrom')">提交</el-button>
        <el-button v-if="!isEdit" @click="resetForm('natureFrom')">重置</el-button>
      </el-form-item>
    </el-form>
  </el-card>
</template>

<script>
import {getNatureInfo, fetchList, updateNature, createNature} from '@/api/nature';
import {quillEditor} from "vue-quill-editor"; //调用编辑器
const defaultNature = {
  pageSize: 100,
  pageNum: 1,
  selectDay: '',

};
export default {
  name: "natureDetail",
  components: {quillEditor},
  props: {
    isEdit: {
      type: Boolean,
      default: false
    }
  },
  data() {
    return {
      nature: Object.assign({}, defaultNature),
    }
  },
  created() {
    if (this.isEdit) {
      getNatureInfo(this.$route.query.id).then(response => {
        this.nature = response.data;
      });
    } else {
      this.nature = Object.assign({}, defaultNature);
    }
    this.getSelectNatureList();
  },
  methods: {
    getSelectNatureList() {
      fetchList(0, this.nature).then(response => {
        this.selectNatureList = response.data;
      });

    },
    onSubmit(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          this.$confirm('是否提交数据', '提示', {
            confirmButtonText: '确定',
            cancelButtonText: '取消',
            type: 'warning'
          }).then(() => {

            if (this.isEdit) {
              updateNature(this.nature).then(response => {
                this.$message({
                  message: '修改成功',
                  type: 'success',
                  duration: 1000
                });
                this.$router.back();
              });
            } else {
              createNature(this.nature).then(response => {
                this.$refs[formName].resetFields();
                this.resetForm(formName);
                this.$message({
                  message: '提交成功',
                  type: 'success',
                  duration: 1000
                });

                this.$router.back();
              });
            }
          });

        } else {
          this.$message({
            message: '验证失败',
            type: 'error',
            duration: 1000
          });
          return false;
        }
      });
    },
    resetForm(formName) {
      this.$refs[formName].resetFields();
      this.nature = Object.assign({}, defaultNature);
      this.getSelectNatureList();
    },
    callbackChangeEditor (value) {

      this.content = value
    },
  }
}
</script>

<style scoped>

</style>
