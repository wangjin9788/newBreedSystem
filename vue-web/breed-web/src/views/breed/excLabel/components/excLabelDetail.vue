<template>
  <el-card class="form-container" shadow="never">
    <el-form :model="label"
             ref="labelFrom"
             label-width="150px">
      <el-form-item v-show="false" label="id：" prop="label" isEdit>
        <el-input v-model.trim="label.lId"></el-input>
      </el-form-item>
      <el-form-item label="标签内容：" prop="label" isEdit>
        <el-input v-model.trim="label.labelName"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onSubmit('labelFrom')">提交</el-button>
        <el-button v-if="!isEdit" @click="resetForm('labelFrom')">重置</el-button>
      </el-form-item>
    </el-form>
  </el-card>
</template>

<script>
import {getExcLabelInfo, fetchList, updateExcLabel, createExcLabel} from '@/api/excLabel';
const defaultLabel = {
  pageSize: 100,
  pageNum: 1,
  selectDay: ''
};
export default {
  name: "labelDetail",
  props: {
    isEdit: {
      type: Boolean,
      default: false
    }
  },
  data() {
    return {
      label: Object.assign({}, defaultLabel),
      content: '',
    }
  },
  created() {
    if (this.isEdit) {
      getExcLabelInfo(this.$route.query.id).then(response => {
        this.label = response.data;
      });
    } else {
      this.label = Object.assign({}, defaultLabel);
    }
    this.getExcLabelList();
  },
  methods: {
    getExcLabelList() {
      fetchList(0, this.label).then(response => {
        this.selectlabelList = response.data;
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
              updateExcLabel(this.label).then(response => {
                this.$message({
                  message: '修改成功',
                  type: 'success',
                  duration: 1000
                });
                this.$router.back();
              });
            } else {
              createExcLabel(this.label).then(response => {
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
      this.label = Object.assign({}, defaultLabel);
      this.getExcLabelList();
    },
    callbackChangeEditor (value) {
      this.content = value
    }
  }
}
</script>

<style scoped>

</style>
