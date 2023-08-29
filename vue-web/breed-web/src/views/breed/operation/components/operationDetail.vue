<template>
  <el-card class="form-container" shadow="never">
    <el-form :model="operation"
             ref="operationFrom"
             label-width="150px">
      <el-form-item v-show="isEdit" style="width : 60%" label="养殖操作编号：" prop="operation" isEdit>
        <el-input v-model="operation.oid" readonly="readonly"></el-input>
      </el-form-item>
      <el-form-item style="width : 60%" label="养殖信息编号：" prop="operation" isEdit>
        <el-input v-model="operation.bid" readonly="readonly"></el-input>
      </el-form-item>
      <el-form-item style="width : 60%" label="操作类型：">
        <el-select v-model="operation.type" placeholder="请选择类型" style="display: block">
          <el-option
            v-for="item in evnOptions"
            :key="item.type"
            :label="item.value"
            :value="item.type">
          </el-option>
        </el-select>
      </el-form-item>
      <el-form-item  label="操作原因：" prop="operation" isEdit>
        <VueQuill  :cont="content" v-model="operation.reason" ></VueQuill>
      </el-form-item>
      <el-form-item  label="操作内容：" prop="operation" isEdit>
        <VueQuill  :cont="content" v-model="operation.content" ></VueQuill>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onSubmit('operationFrom')">提交</el-button>
        <el-button v-if="!isEdit" @click="resetForm('operationFrom')">重置</el-button>
      </el-form-item>
    </el-form>
  </el-card>
</template>

<script>
import {fetchList, createOperation, updateOperation, getOperationInfo} from '@/api/operation';

const defaultOperation = {
  bid: 0,
  type:0
};
export default {
  name: "operation",
  props: {
    isEdit: {
      type: Boolean,
      default: false
    }

  },
  data() {
    return {
      operation: Object.assign({}, defaultOperation),
      evnOptions: [{type: 0, value: '普通操作'}, {type: 1, value: '药物操作'}, {type: 2, value: '营养/菌液操作'}],

    }
  },
  created() {

    if (this.isEdit) {
      getOperationInfo(this.$route.query.id).then(response => {
        this.operation = response.data;

      });
    } else {
      this.operation = Object.assign({}, defaultOperation);
      this.operation.bid = this.$route.query.bid;
    }
    this.operation.type = this.$route.query.type
  },
  methods: {
    getSelectOperationList(bid,type) {
      fetchList( {bid,type,pageSize: 100, pageNum: 1}).then(response => {
        this.selectOperationList = response.data;
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
              updateOperation(this.operation).then(response => {
                this.$message({
                  message: '修改成功',
                  type: 'success',
                  duration: 1000
                });
                this.$router.back();
              });
            } else {
              createOperation(this.operation).then(response => {
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
      this.operation = Object.assign({}, defaultOperation);
      this.getSelectOperationList(this.operation.bid,this.operation.type);
    },
  }
}
</script>

<style scoped>

</style>
