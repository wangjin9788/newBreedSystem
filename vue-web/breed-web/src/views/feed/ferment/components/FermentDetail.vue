<template>
  <el-card class="form-container" shadow="never">
    <el-form :model="ferment"
             ref="fermentFrom"
             label-width="150px">
      <el-form-item v-show="false" label="id：" prop="ferment" isEdit>
        <el-input v-model.trim="ferment.ffId"></el-input>
      </el-form-item>
      <el-form-item label="内容：" prop="ferment" isEdit>
        <quill-editor v-model="ferment.fermentInfo" >
        </quill-editor>
      </el-form-item>
      <el-form-item label="发酵时间：" prop="ferment">
        <el-date-picker style="width: 100%"
                        v-model="ferment.fermentTime"
                        type="datetime"
                        format="yyyy-MM-dd hh:mm"
                        value-format="yyyy-MM-dd hh:mm"
                        placeholder="选择日期时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="图片：">
        <template slot-scope="scope">
          <single-upload v-model="ferment.createImage"></single-upload>
        </template>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onSubmit('fermentFrom')">提交</el-button>
        <el-button v-if="!isEdit" @click="resetForm('fermentFrom')">重置</el-button>
      </el-form-item>
    </el-form>
  </el-card>
</template>

<script>
import {getFermentInfo, fetchList, updateFerment, createFerment} from '@/api/ferment';
import SingleUpload from '@/components/Upload/singleUpload';
const defaultFerment = {
  pageSize: 100,
  pageNum: 1,
  selectDay: ''
};
export default {
  name: "fermentDetail",
  components: {SingleUpload},
  props: {
    isEdit: {
      type: Boolean,
      default: false
    }
  },
  data() {
    return {
      ferment: Object.assign({}, defaultFerment),
      content: '',
    }
  },
  created() {
    if (this.isEdit) {
      getFermentInfo(this.$route.query.id).then(response => {
        this.ferment = response.data;
      });
    } else {
      this.ferment = Object.assign({}, defaultFerment);
    }
    this.getSelectFermentList();
  },
  methods: {
    getSelectFermentList() {
      fetchList(0, this.ferment).then(response => {
        this.selectFermentList = response.data;
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
              updateFerment(this.ferment).then(response => {
                this.$message({
                  message: '修改成功',
                  type: 'success',
                  duration: 1000
                });
                this.$router.back();
              });
            } else {
              createFerment(this.ferment).then(response => {
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
      this.ferment = Object.assign({}, defaultFerment);
      this.getSelectFermentList();
    },
    callbackChangeEditor (value) {
      this.content = value
    }
  }
}
</script>

<style scoped>

</style>
