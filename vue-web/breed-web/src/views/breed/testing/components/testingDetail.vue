<template>
  <el-card class="form-container" shadow="never">
    <el-form :model="testing"
             ref="testingFrom"
             label-width="150px">
      <el-form-item v-show="false" testing="id：" prop="testing" isEdit>
        <el-input v-model.trim="testing.tid"></el-input>
      </el-form-item>
      <el-form-item style="width : 60%" label="养殖信息编号：" prop="testing" isEdit>
        <el-input v-model="testing.bid" readonly="readonly"></el-input>
      </el-form-item>
      <el-form-item style="width : 60%" label="天气：" prop="testing" isEdit>
        <el-input v-model="testing.weather"></el-input>
      </el-form-item>
      <el-form-item style="width : 60%" label="温度：" prop="testing" isEdit>
        <el-input v-model="testing.temperature"></el-input>
      </el-form-item>
      <el-form-item style="width : 60%" label="ph：" prop="testing" isEdit>
        <el-input v-model="testing.ph"></el-input>
      </el-form-item>
      <el-form-item style="width : 60%" label="养殖温度：" prop="testing" isEdit>
        <el-input v-model="testing.breedTemperature"></el-input>
      </el-form-item>
      <el-form-item style="width : 60%" label="养殖湿度：" prop="testing" isEdit>
        <el-input v-model="testing.breedHumidity"></el-input>
      </el-form-item>
      <el-form-item label="病症状态:">
        <el-radio-group v-model="testing.disease">
          <el-radio :label="0">无</el-radio>
          <el-radio :label="1">有</el-radio>
        </el-radio-group>
      </el-form-item>
      <el-form-item label="图片：" v-show="testing.disease==1">
        <template slot-scope="scope">
          <single-upload v-model="testing.imgUrl"></single-upload>
        </template>
      </el-form-item>

      <el-form-item>
        <el-button type="primary" @click="onSubmit('testingFrom')">提交</el-button>
        <el-button v-if="!isEdit" @click="resetForm('testingFrom')">重置</el-button>
      </el-form-item>
    </el-form>
  </el-card>
</template>

<script>
import {getTestingInfo, fetchList, updateTesting, createTesting} from '@/api/testing';
import SingleUpload from '@/components/Upload/singleUpload';
const defaultTesting = {
  pageSize: 100,
  pageNum: 1,
  bid:0
};
export default {
  name: "testingDetail",
  components: {SingleUpload},
  props: {
    isEdit: {
      type: Boolean,
      default: false
    }
  },
  data() {
    return {
      testing: Object.assign({}, defaultTesting),
    }
  },
  created() {
    if (this.isEdit) {
      getTestingInfo(this.$route.query.id).then(response => {
        this.testing = response.data;
      });
    } else {
      this.testing = Object.assign({}, defaultTesting);
      this.testing.bid = this.$route.query.bid;
    }

    this.getSelectTestingList(this.operation.bid);
  },
  methods: {
    getSelectTestingList(bid) {
      fetchList( {bid,pageSize: 100, pageNum: 1}).then(response => {
        this.selecttestingList = response.data;
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
              updateTesting(this.testing).then(response => {
                this.$message({
                  message: '修改成功',
                  type: 'success',
                  duration: 1000
                });
                this.$router.back();
              });
            } else {
              createTesting(this.testing).then(response => {
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
      this.testing = Object.assign({}, defaultTesting);
      this.getSelectTestingList(this.testing.bid);
    },
    callbackChangeEditor (value) {
      this.content = value
    }
  }
}
</script>

<style scoped>

</style>
