<template>
  <el-card class="form-container" shadow="never" style="width: auto;height: auto">
    <el-form :model="breedData"
             ref="breedDataFrom"
             label-width="200px">
      <el-form-item v-show="false" label="id：" prop="breedData" isEdit>
        <el-input v-model.trim="breedData.biId"></el-input>
      </el-form-item>
      <el-form-item label="目录：" prop="breedData" >
        <el-cascader v-model="breedData.idList"
                     :options="selectLabelLists"
                     :show-all-levels="false"
                     placeholder="请选择目录" ></el-cascader>
      </el-form-item>
      <el-form-item label="内容：" prop="breedData" isEdit>
        <VueQuill  :cont="content" v-model="breedData.content" ></VueQuill>
      </el-form-item>


      <el-form-item>
        <el-button type="primary"   @click="onSubmit('breedDataFrom')">提交</el-button>
        <el-button v-if="!isEdit" @click="resetForm('breedDataFrom')">重置</el-button>
      </el-form-item>
    </el-form>
  </el-card>
</template>

<script>
import {getBreedInfo, cascaderLabel,fetchList,updateBreedInfo,createBreedData} from '@/api/breedData';

const defaultBreedData = {
  pageSize: 100,
  pageNum: 1,
  searchName: '',
  content:"",
  biId:0,
  idList:[]
};
export default {
  name: "BreedDataDetail",

  props: {
    isEdit: {
      type: Boolean,
      default: false
    }
  },

  data() {
    return {
      content:"",
      breedData:Object.assign({}, defaultBreedData),
      selectLabelLists:[],


    }
  },
  created() {
    cascaderLabel().then(response => {
      this.selectLabelLists = response.data;
    });
    if (this.isEdit) {
      getBreedInfo(this.$route.query.id).then(response => {
        this.breedData = response.data;
        this.content=response.data.content;
      });

    } else {
      this.breedData = Object.assign({}, defaultBreedData);
    }

  },

  methods: {
    getSelectBreedDataList() {
      fetchList(0, this.breedData).then(response => {
        this.selectBreedDataList = response.data;
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
            this.breedData.dlId=this.breedData.idList[1];
            if (this.isEdit) {
              updateBreedInfo(this.breedData).then(response => {
                this.$message({
                  message: '修改成功',
                  type: 'success',
                  duration: 1000
                });
                this.$router.back();
              });
            } else {
              createBreedData(this.breedData).then(response => {
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
      this.breedData = Object.assign({}, defaultBreedData);
      //this.getSelectBreedDataList();
    },
  }
}
</script>

<style scoped>

</style>
