<template>
  <el-card class="form-container" shadow="never">
    <el-form :model="revenue"
             ref="revenueFrom"
             label-width="150px">
      <el-form-item label="收入类型：">
        <el-select v-model="revenue.prcid"
                   placeholder="请选择类型">
          <el-option
            v-for="item in selectRevenueLists"
            :key="item.prcid"
            :label="item.typeName"
            :value="item.prcid">
          </el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="金额：" prop="money">
        <el-input v-model.trim="revenue.money" ></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onSubmit('revenueFrom')">提交</el-button>
        <el-button v-if="!isEdit" @click="resetForm('revenueFrom')">重置</el-button>
      </el-form-item>
    </el-form>
  </el-card>
</template>

<script>
  import {fetchList, createRevenue, getCategory,updateRevenue,getRevenue} from '@/api/exp';

  const defaultRevenue = {
    prcid: 0,
    money: 0.0
  };
  export default {
    name: "RevenueDetail",
    props: {
      isEdit: {
        type: Boolean,
        default: false
      }
    },
    data() {
      return {
        revenue: Object.assign({}, defaultRevenue),
        selectRevenueLists:  getCategory().then(response => {
                                    this.selectRevenueLists = response.data;
                                    })
      }
    },
    created() {
      if (this.isEdit) {
        getRevenue(this.$route.query.id).then(response => {
          this.revenue = response.data;
        });
      } else {
        this.revenue = Object.assign({}, defaultRevenue);
      }
      this.getSelectRevenueList();
    },
    methods: {
      getSelectRevenueList() {
        fetchList(0, {pageSize: 100, pageNum: 1}).then(response => {
          this.selectRevenueList = response.data;
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
                updateRevenue( this.revenue).then(response => {
                  this.$message({
                    message: '修改成功',
                    type: 'success',
                    duration: 1000
                  });
                  this.$router.back();
                });
              } else {
                createRevenue(this.revenue).then(response => {
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
        this.revenue = Object.assign({}, defaultRevenue);
        this.getSelectRevenueList();
      },
    }
  }
</script>

<style scoped>

</style>
