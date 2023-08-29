<template>

  <el-card class="form-container" shadow="never">
    <el-form :model="breed"
             ref="breedFrom"
             label-width="150px">
      <el-form-item v-show="false"   label="id：" prop="breed" isEdit>
        <el-input v-model.trim="breed.bid"></el-input>
      </el-form-item>
      <el-form-item label="养殖模型：">
        <el-select v-model="breed.bmId" placeholder="请选择模型" style="display: block">
          <el-option
            v-for="item in selectBreedLists"
            :key="item.bmId"
            :label="item.breedModel"
            :value="item.bmId">
          </el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="养殖环境：">
        <el-select v-model="breed.type" placeholder="请选择环境" style="display: block">
          <el-option
            v-for="item in evnOptions"
            :key="item.type"
            :label="item.value"
            :value="item.type">
          </el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="健康状态：">
        <el-select v-model="breed.breedMark" placeholder="请选择状态" style="display: block">
          <el-option
            v-for="item in healthyOption"
            :key="item.breedMark"
            :label="item.value"
            :value="item.breedMark">
          </el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="规格：">
        <el-select v-model="breed.specifications" placeholder="请选择规格" style="display: block">
          <el-option
            v-for="item in specificationsOption"
            :key="item.specifications"
            :label="item.value"
            :value="item. specifications">
          </el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="投入时间：" prop="breed" >
        <el-date-picker  style="width: 100%"
          v-model="breed.inputTime"
          type="date"
          format="yyyy-MM-dd hh:mm"
          value-format="yyyy-MM-dd hh:mm"
          placeholder="选择日期时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item  label="投入重量(斤)：" prop="breed" isEdit>
        <el-input v-model.trim="breed.inputWeight"></el-input>
      </el-form-item>
      <el-form-item  label="养殖面积㎡：" prop="breed" isEdit>
        <el-input v-model.trim="breed.extent"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onSubmit('breedFrom')">提交</el-button>
        <el-button v-if="!isEdit" @click="resetForm('breedFrom')">重置</el-button>
      </el-form-item>
    </el-form>
  </el-card>
</template>

<script>
import {
  fetchList,
  createBreed,
  updateBreed,
  getBreedInfo,
  getModelList
} from '@/api/breedInfo';


import {selectModelList} from '@/api/breedModel'
const defaultBreed = {
  status: 0
};
export default {
  name: "BreedDetail",
  props: {
    isEdit: {
      type: Boolean,
      default: false
    }
  },
  data() {
    return {
      breed: Object.assign({}, defaultBreed),
      selectBreedLists: selectModelList().then(response => {
        this.selectBreedLists = response.data;
      }),
      evnOptions: [{type: 0, value: '室内'}, {type: 1, value: '室外'}],
      healthyOption: [{breedMark: 0, value: '健康'}, {breedMark: 1, value: '一般'}, {breedMark: 2, value: '差'}],
      specificationsOption: [{specifications: 1, value: '小蚯蚓'}, {specifications: 2, value: '中蚯蚓'}, {specifications: 3, value: '大蚯蚓'}]
    }
  },
  created() {
    if (this.isEdit) {
      getBreedInfo(this.$route.query.id).then(response => {
        this.breed = response.data;
      });
    } else {
      this.breed = Object.assign({}, defaultBreed);
    }
    this.getSelectBreedList();
  },
  methods: {
    getSelectBreedList() {
      fetchList(0, {pageSize: 100, pageNum: 1}).then(response => {
        this.selectBreedList = response.data;
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
              updateBreed(this.breed).then(response => {
                this.$message({
                  message: '修改成功',
                  type: 'success',
                  duration: 1000
                });
                this.$router.back();
              });
            } else {
              createBreed(this.breed).then(response => {
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
      this.breed = Object.assign({}, defaultBreed);
      this.getSelectBreedList();
    },
  }
}
</script>

<style scoped>

</style>
