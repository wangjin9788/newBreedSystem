<template>

  <el-card class="form-container" shadow="never">
    <el-form :model="breedModel"
             ref="breedModelFrom"
             label-width="150px">
      <el-form-item v-show="false" label="id：" prop="breedModel" isEdit>
        <el-input v-model.trim="breedModel.bmId"></el-input>
      </el-form-item>
      <el-form-item label="模型：" prop="breedModel" isEdit>
        <el-input v-model.trim="breedModel.breedModel"></el-input>
      </el-form-item>
      <el-form-item label="发酵饲料信息：">
        <el-select v-model="breedModel.fId" placeholder="请选择饲料" style="display: block">
          <el-option
            v-for="item in selectFeedFermentLists"
            :key="item.fId"
            :label="item.fermentInfo"
            :value="item.fId">
          </el-option>
        </el-select>
      </el-form-item>


      <el-form-item>
        <el-button type="primary" @click="onSubmit('breedModelFrom')">提交</el-button>
        <el-button v-if="!isEdit" @click="resetForm('breedModelFrom')">重置</el-button>
      </el-form-item>
    </el-form>
  </el-card>
</template>

<script>
import {fetchList, createBreedModel,updateBreedModel,getBreedModelInfo} from '@/api/breedModel';
import { selectFeedList } from '@/api/feedInfo';

const defaultBreedModel = {
  status: 0,
  fId:0
};
export default {
  name: "breedModelDetail",
  props: {
    isEdit: {
      type: Boolean,
      default: false
    }
  },
  data() {
    return {
      breedModel: Object.assign({}, defaultBreedModel),
      selectFeedFermentLists: selectFeedList().then(response => {
        this.selectFeedFermentLists = response.data;
      })
    }
  },
  created() {
    if (this.isEdit) {
      getBreedModelInfo(this.$route.query.id).then(response => {
        this.breedModel = response.data;
      });
    } else {
      this.breedModel = Object.assign({}, defaultBreedModel);
    }
    this.getSelectBreedModelList();
  },
  methods: {
    getSelectBreedModelList() {
      fetchList(0, {pageSize: 100, pageNum: 1}).then(response => {
        this.selectBreedModelList = response.data;
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
              updateBreedModel(this.breedModel).then(response => {
                this.$message({
                  message: '修改成功',
                  type: 'success',
                  duration: 1000
                });
                this.$router.back();
              });
            } else {
              createBreedModel(this.breedModel).then(response => {
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
      this.breedModel = Object.assign({}, defaultBreedModel);
      this.getSelectBreedModelList();
    },
  }
}
</script>

<style scoped>

</style>
