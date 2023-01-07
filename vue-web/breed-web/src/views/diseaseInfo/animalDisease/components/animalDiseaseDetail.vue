<template>
  <el-card class="form-container" shadow="never">
    <el-form :model="animalDisease"
             ref="animalDiseaseFrom"
             label-width="150px">
      <el-form-item v-show="false" label="id：" prop="animalDisease" isEdit>
        <el-input v-model.trim="animalDisease.adId"></el-input>
      </el-form-item>
      <el-form-item label="病理性质：">
        <el-select v-model="animalDisease.nid" placeholder="请选择性质" style="display: block">
          <el-option
            v-for="item in selectAnimalDiseaseLists"
            :key="item.nid"
            :label="item.nature"
            :value="item.nid">
          </el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="病害名称：" prop="animalDisease" isEdit>
        <el-input v-model.trim="animalDisease.diseaseName"></el-input>
      </el-form-item>
      <el-form-item label="病因：" prop="animalDisease" isEdit>
        <quill-editor v-model="animalDisease.pathogeny" >
        </quill-editor>
      </el-form-item>
      <el-form-item label="症状" prop="animalDisease" isEdit>
        <quill-editor v-model="animalDisease.symptom" ></quill-editor>
      </el-form-item>
      <el-form-item label="治疗方法" prop="animalDisease" isEdit>
        <quill-editor v-model="animalDisease.treatment" ></quill-editor>
      </el-form-item>
      <el-form-item label="图片：">
        <template slot-scope="scope">
          <single-upload v-model="animalDisease.imgUrl"></single-upload>
        </template>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onSubmit('animalDiseaseFrom')">提交</el-button>
        <el-button v-if="!isEdit" @click="resetForm('animalDiseaseFrom')">重置</el-button>
      </el-form-item>
    </el-form>
  </el-card>
</template>

<script>
import {getAnimalDiseaseInfo, fetchList, updateAnimalDisease, createAnimalDisease} from '@/api/animalDisease';
import SingleUpload from '@/components/Upload/singleUpload';
import {selectNatureList}  from '@/api/nature';
import {quillEditor} from "vue-quill-editor"; //调用编辑器
import 'quill/dist/quill.core.css';
import 'quill/dist/quill.snow.css';
import 'quill/dist/quill.bubble.css';
const defaultAnimalDisease = {
  pageSize: 100,
  pageNum: 1,
  searchName: ''
};
export default {
  name: "animalDiseaseDetail",
  components: {SingleUpload,quillEditor},

  props: {
    isEdit: {
      type: Boolean,
      default: false
    }
  },
  data() {
    return {
      animalDisease: Object.assign({}, defaultAnimalDisease),
      selectAnimalDiseaseLists: selectNatureList().then(response => {
        this.selectAnimalDiseaseLists = response.data;
      }),
    }
  },
  created() {
    if (this.isEdit) {
      getAnimalDiseaseInfo(this.$route.query.id).then(response => {
        this.animalDisease = response.data;
      });
    } else {
      this.animalDisease = Object.assign({}, defaultAnimalDisease);
    }

  },
  methods: {
    getSelectAnimalDiseaseList() {
      fetchList(0, this.animalDisease).then(response => {
        this.selectAnimalDiseaseList = response.data;
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
              updateAnimalDisease(this.animalDisease).then(response => {
                this.$message({
                  message: '修改成功',
                  type: 'success',
                  duration: 1000
                });
                this.$router.back();
              });
            } else {
              createAnimalDisease(this.animalDisease).then(response => {
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
      this.animalDisease = Object.assign({}, defaultAnimalDisease);
      //this.getSelectAnimalDiseaseList();
    },
  }
}
</script>

<style scoped>

</style>
