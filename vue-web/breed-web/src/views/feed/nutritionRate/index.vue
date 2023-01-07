<template>
  <el-card class="form-container" shadow="never">
    <el-form :model="rates"
             ref="ratesFrom"
             label-width="150px">
      <el-form-item v-show="false" label="id：" prop="rates" isEdit>
        <el-input v-model.trim="rates.nrid"></el-input>
      </el-form-item>
      <el-form-item label="营养名称：" prop="rates" isEdit>
        <el-input v-model.trim="rates.nutName"></el-input>
      </el-form-item>
      <el-form-item label="比例％：" prop="rates" isEdit>
        <el-input v-model.trim="rates.rate"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onSubmit('ratesFrom')">提交</el-button>
        <el-button v-if="!isEdit" @click="resetForm('ratesFrom')">重置</el-button>
      </el-form-item>
    </el-form>
  </el-card>
</template>

<script>
import { fetchList,createRate} from '@/api/rate';
const defaultrates = {
  pageSize: 100,
  pageNum: 1,
  selectDay: ''
};
export default {
  name: "ratesDetail",
  props: {
    isEdit: {
      type: Boolean,
      default: false
    }
  },
  data() {
    return {
      rates: Object.assign({}, defaultrates),
      content: '',
    }
  },
  methods: {
    getSelectratesList() {
      fetchList(0, this.rates).then(response => {
        this.selectratesList = response.data;
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
            createRate(this.rates).then(response => {
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
      this.rates = Object.assign({}, defaultrates);
      this.getSelectratesList();
    },
  }
}
</script>

<style scoped>

</style>
