<template>
  <el-card class="form-container" shadow="never">
    <el-form :model="ferment"
             ref="fermentFrom"
             label-width="150px">

      <el-form-item  label="发酵堆编号：" prop="ferment" isEdit>
        <el-input readonly v-model.trim="ferment.ffId"></el-input>
      </el-form-item>
      <el-form-item  label="气温：" prop="ferment" isEdit>
        <el-input  v-model.trim="ferment.head"></el-input>
      </el-form-item>
      <el-form-item  label="堆温：" prop="ferment" isEdit>
        <el-input  v-model.trim="ferment.heapHead"></el-input>
      </el-form-item>

      <el-form-item>
        <el-button type="primary" @click="onSubmit('fermentFrom')">提交</el-button>
        <el-button v-if="!isEdit" @click="resetForm('fermentFrom')">重置</el-button>
      </el-form-item>
    </el-form>
  </el-card>
</template>

<script>
import {createFermentDetail, updateFermentDetail, getFermentDetailInfo, fetchList} from '@/api/dayFermentDetail';
const defaultFerment = {
  pageSize: 100,
  pageNum: 1,
  ffId:0,
};
export default {
  name: "fermentDetail",
  props: {
    isEdit: {
      type: Boolean,
      default: false
    }
  },
  data() {
    return {
      ferment: Object.assign({}, defaultFerment),
    }
  },
  created() {
    console.log(this.$route.query.ffId)
    if (this.isEdit) {
      getFermentDetailInfo(this.$route.query.id).then(response => {
        this.ferment = response.data;
      });
    } else {
      this.ferment = Object.assign({}, defaultFerment);
    }
    this.ferment.ffId=this.$route.query.ffId;
    console.log(this.ferment.ffId)
  },
  methods: {

    onSubmit(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          this.$confirm('是否提交数据', '提示', {
            confirmButtonText: '确定',
            cancelButtonText: '取消',
            type: 'warning'
          }).then(() => {
            if (this.isEdit) {
              updateFermentDetail(this.ferment).then(response => {
                this.$message({
                  message: '修改成功',
                  type: 'success',
                  duration: 1000
                });
                this.$router.back();
              });
            } else {
              createFermentDetail(this.ferment).then(response => {
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
    },
  }
}
</script>

<style scoped>

</style>
