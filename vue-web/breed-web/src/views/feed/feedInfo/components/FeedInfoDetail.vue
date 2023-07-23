<template>

  <el-card class="form-container" shadow="never">
    <el-form :model="feedInfo"
             ref="feedInfoFrom"
             label-width="150px">
      <el-form-item v-show="false" label="id：" prop="feedInfo" isEdit>
        <el-input v-model.trim="feedInfo.fId"></el-input>
      </el-form-item>
      <el-form-item label="饲料类型：">
        <el-select v-model="feedInfo.mark" placeholder="请选择饲料" style="display: block">
          <el-option
            v-for="item in option"
            :key="item.mark"
            :label="item.value"
            :value="item.mark">
          </el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="发酵饲料信息：" v-if="!isEdit">
        <quill-editor v-model="feedInfo.content" >
        </quill-editor>
      </el-form-item>

      <el-form-item label="额外内容：" prop="ferment" isEdit>
        <quill-editor v-model="feedInfo.extContent" >
        </quill-editor>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onSubmit('feedInfoFrom')">提交</el-button>
        <el-button v-if="!isEdit" @click="resetForm('feedInfoFrom')">重置</el-button>
      </el-form-item>
    </el-form>
  </el-card>
</template>

<script>
import {
  fetchList,
  createFeedInfo,
  updateFeedInfo,
  getFeedInfo
} from '@/api/feedInfo';


const defaultFeedInfo = {
  status: 0
};
export default {
  name: "FeedInfoDetail",
  props: {
    isEdit: {
      type: Boolean,
      default: false
    }
  },
  data() {
    return {
      feedInfo: Object.assign({}, defaultFeedInfo),
      option: [{mark: 0, value: '基料'}, {mark: 1, value: '添加饲料'}]
    }
  },
  created() {
    if (this.isEdit) {
      getFeedInfo(this.$route.query.id).then(response => {
        this.feedInfo = response.data;
      });
    } else {
      this.feedInfo = Object.assign({}, defaultFeedInfo);
    }
    this.getSelectFeedInfoList();
  },
  methods: {
    getSelectFeedInfoList() {
      fetchList(0, {pageSize: 100, pageNum: 1}).then(response => {
        this.selectFeedInfoList = response.data;
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
              updateFeedInfo(this.feedInfo).then(response => {
                this.$message({
                  message: '修改成功',
                  type: 'success',
                  duration: 1000
                });
                this.$router.back();
              });
            } else {
              createFeedInfo(this.feedInfo).then(response => {
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
      this.feedInfo = Object.assign({}, defaultFeedInfo);
      this.getSelectFeedInfoList();
    },
  }
}
</script>

<style scoped>

</style>
