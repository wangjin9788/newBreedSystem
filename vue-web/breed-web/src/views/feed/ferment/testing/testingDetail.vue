<template>
  <el-card class="form-container" shadow="never">
    <el-form :model="ferment"
             ref="fermentFrom"
             label-width="150px">
      <el-form-item v-show="false" label="发酵信息id：" prop="ferment" isEdit>
        <el-input v-model.trim="ferment.ffId"></el-input>
      </el-form-item>
      <el-form-item label="温度：" prop="ferment" isEdit>
        <el-input v-model.trim="ferment.temp"></el-input>
      </el-form-item>
      <el-form-item label="ph：" prop="ferment" isEdit>
        <el-input v-model.trim="ferment.ph"></el-input>
      </el-form-item>
      <el-form-item label="气味:">
        <el-radio-group v-model="ferment.pungentOdor">
          <el-radio :label="0">无</el-radio>
          <el-radio :label="1">有</el-radio>
        </el-radio-group>
      </el-form-item>
      <el-form-item label="图片：">
        <template slot-scope="scope">
          <single-upload v-model="ferment.imgUrl"></single-upload>
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
import { fetchList, updateFermentStatus} from '@/api/ferment';
import SingleUpload from '@/components/Upload/singleUpload';
const defaultFerment = {
  pageSize: 100,
  pageNum: 1,
  selectDay: '',
  ffId:0
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
    this.ferment.ffId=this.$route.query.id
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
            if(this.ferment.pungentOdor=='0'){
              updateFermentStatus(this.ferment).then(response => {
                this.$refs[formName].resetFields();
                this.resetForm(formName);
                this.$message({
                  message: '提交成功',
                  type: 'success',
                  duration: 1000
                });

                this.$router.back();
              });
            }else{
              this.$confirm('还有刺激性气味建议继续发酵', '提示', {
                confirmButtonText: '确定',
                cancelButtonText: '取消',
                type: 'warning'
              }).then(() => {
                this.$router.back();
              })
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
  }
}
</script>

<style scoped>

</style>
