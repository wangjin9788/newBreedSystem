<template>
  <el-card class="form-container" shadow="never">
    <el-form :model="pay"
             ref="payFrom"
             label-width="150px">
      <el-form-item label="收入类型：">
        <el-select v-model="pay.prcid"
                   placeholder="请选择类型">
          <el-option
            v-for="item in selectPayLists"
            :key="item.prcid"
            :label="item.typeName"
            :value="item.prcid">
          </el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="金额：" prop="pay">
        <el-input v-model.trim="pay.pay" ></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onSubmit('payFrom')">提交</el-button>
        <el-button v-if="!isEdit" @click="resetForm('payFrom')">重置</el-button>
      </el-form-item>
    </el-form>
  </el-card>
</template>

<script>
  import {fetchList, createPay, getCategory,updatePay,getPay} from '@/api/pay';

  const defaultPay = {
    prcid: 0,
    money: 0.0
  };
  export default {
    name: "PayDetail",
    props: {
      isEdit: {
        type: Boolean,
        default: false
      }
    },
    data() {
      return {
        pay: Object.assign({}, defaultPay),
        selectPayLists:  getCategory().then(response => {
                                    this.selectPayLists = response.data;
                                    })
      }
    },
    created() {
      if (this.isEdit) {
        getPay(this.$route.query.id).then(response => {
          this.pay = response.data;
        });
      } else {
        this.pay = Object.assign({}, defaultPay);
      }
      this.getSelectPayList();
    },
    methods: {
      getSelectPayList() {
        fetchList(0, {pageSize: 100, pageNum: 1}).then(response => {
          this.selectPayList = response.data;
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
                updatePay( this.pay).then(response => {
                  this.$message({
                    message: '修改成功',
                    type: 'success',
                    duration: 1000
                  });
                  this.$router.back();
                });
              } else {
                createPay(this.pay).then(response => {
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
        this.revenue = Object.assign({}, defaultPay);
        this.getSelectPayList();
      },
    }
  }
</script>

<style scoped>

</style>
