<template>
  <el-card class="form-container" shadow="never">
    <el-form :model="operation"
             ref="operationFrom"
             label-width="150px">
      <el-form-item v-show="isEdit" style="width : 60%" label="养殖操作编号：" prop="operation" isEdit>
        <el-input v-model="operation.eoId" readonly="readonly"></el-input>
      </el-form-item>
      <el-form-item style="width : 60%" label="病害编号：" prop="operation" isEdit>
        <el-input v-model="operation.eid" readonly="readonly"></el-input>
      </el-form-item>
      <el-form-item style="width : 100%" label="基本操作：" prop="operation" isEdit>
        <quill-editor v-model="operation.operation" :options="quillOption">
        </quill-editor>
      </el-form-item>
      <el-form-item label="评价：">
        <el-select v-model="operation.effect" placeholder="请选择环境" style="display: block">
          <el-option
            v-for="item in evnOptions"
            :key="item.effect"
            :label="item.value"
            :value="item.effect">
          </el-option>
        </el-select>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onSubmit('operationFrom')">提交</el-button>
        <el-button v-if="!isEdit" @click="resetForm('operationFrom')">重置</el-button>
      </el-form-item>
    </el-form>
  </el-card>
</template>

<script>
import {fetchList, createExcOperation, updateExcOperation, getExcOperationInfo} from '@/api/excOperation';
import {quillEditor} from "vue-quill-editor"; //调用编辑器
import 'quill/dist/quill.core.css';
import 'quill/dist/quill.snow.css';
import 'quill/dist/quill.bubble.css';

const defaultExcOperation = {
  eid: 0
};
export default {
  components: {
    quillEditor
  },
  name: "operation",
  props: {
    isEdit: {
      type: Boolean,
      default: false
    }

  },
  data() {
    return {
      operation: Object.assign({}, defaultExcOperation),
      evnOptions: [{effect: 0, value: '较差'}, {effect: 1, value: '一般'}, {effect: 2, value: '良好'}],
    }
  },
  created() {

    if (this.isEdit) {
      getExcOperationInfo(this.$route.query.id).then(response => {
        this.operation = response.data;
      });
    } else {
      this.operation = Object.assign({}, defaultExcOperation);
      this.eid = this.$route.query.eid;
    }
    this.getExcOperationList(this.operation.eid);
  },
  methods: {
    getExcOperationList(eid) {
      fetchList({eid, pageSize: 100, pageNum: 1}).then(response => {
        this.selectExcOperationList = response.data;
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
              updateExcOperation(this.operation).then(response => {
                this.$message({
                  message: '修改成功',
                  type: 'success',
                  duration: 1000
                });
                this.$router.back();
              });
            } else {
              createExcOperation(this.operation).then(response => {
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
      this.operation = Object.assign({}, defaultExcOperation);
      this.eid = this.$route.query.eid;
      this.getExcOperationList(this.operation.eid);
    },
  }
}
</script>

<style scoped>

</style>
