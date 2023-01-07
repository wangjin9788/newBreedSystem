<template>
  <el-card class="form-container" shadow="never">
    <el-form :model="breedOut"
             ref="BreedOutFrom"
             label-width="150px">
      <el-form-item v-show="false" label="id：" prop="BreedOut" isEdit>
        <el-input v-model.trim="breedOut.bid"></el-input>
      </el-form-item>

      <el-form-item label="产出重量：" prop="ferment" isEdit>
        <el-input v-model.trim="breedOut.outPut"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onSubmit('BreedOutFrom')">提交</el-button>
        <el-button v-if="!isEdit" @click="resetForm('BreedOutFrom')">重置</el-button>
      </el-form-item>
    </el-form>
  </el-card>
</template>

<script>
import {
  fetchList,
  createBreedOut
} from '@/api/breedOut';




const defaultBreedOut = {
  bid: 0
};
export default {
  name: "BreedOutDetail",
  props: {
    isEdit: {
      type: Boolean,
      default: false
    }
  },
  created() {
    this.breedOut.bid = this.$route.query.bid;
  },
  data() {
    return {
      breedOut: Object.assign({}, defaultBreedOut),

    }
  },

  methods: {
    getSelectBreedOutList() {
      fetchList(0, {pageSize: 100, pageNum: 1}).then(response => {
        this.selectBreedOutList = response.data;
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
            createBreedOut(this.breedOut).then(response => {
                this.$refs[formName].resetFields();
                this.resetForm(formName);
                this.$message({
                  message: '提交成功',
                  type: 'success',
                  duration: 1000
                });

                this.$router.back();
              });
            })
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
      this.breedOut = Object.assign({}, defaultBreedOut);
      this.getSelectBreedOutList();
    },
  }
}
</script>

<style scoped>

</style>
