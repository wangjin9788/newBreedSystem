<template>
  <el-card class="form-container" shadow="never">
    <el-form :model="cla"
             ref="claFrom"
             label-width="150px">
      <el-form-item label="添加到发酵列表中">
        <div style="margin-top: 20px">
          <el-radio v-model="cla.radio" label="1"  size="medium">不添加</el-radio>
          <el-radio v-model="cla.radio" label="2"  size="medium">添加</el-radio>
        </div>
      </el-form-item>
      <el-row :gutter="20">
        <el-col :span="13">
          <el-form-item label="预计重量">
            <el-input v-model="cla.weight">
              <el-select v-model="cla.weightUnit" slot="prepend" placeholder="请选择" @change="changeWight()">
                <el-option label="斤" value="斤"></el-option>
                <el-option label="克" value="克"></el-option>
                <el-option label="千克" value="千克"></el-option>
              </el-select>
            </el-input>
          </el-form-item>
        </el-col>
        <el-col :span="10">
          <el-form-item label="重量单位：">
            <el-select v-model="cla.unit" placeholder="请选择单位" @change="conversionUnit()" >
              <el-option
                v-for="(item,index) in option"
                :key="index"
                :value="item.unit"
                >
              </el-option>
            </el-select>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row :gutter="20">
        <el-col :span="13">
          <el-form-item
            v-for="(item, index) in cla.formulaStr"
            :label="'材料' + index"
            :key="item"
            :prop="'formulaStr.' + index + '.value'">
            <el-input v-model="cla.formulaStr[index]" readonly></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="10">
          <el-form-item
            v-for="(reusl, index) in cla.results"
            :label="'结果' + index"
            :key="reusl.key"
            :prop="'results.' + index + '.value'">
            <el-input v-model="cla.results[index]" readonly></el-input>
          </el-form-item>
        </el-col>
      </el-row>
      <el-form-item>
        <el-button type="success" @click="getResult(cla.weight)">获得结果</el-button>
        <el-button type="primary" @click="onSubmit('claFrom')">邮件发送</el-button>
      </el-form-item>
    </el-form>
  </el-card>
</template>

<script>
import {getFormulaInfo,sendMail} from '@/api/feedFormula';


const defaultcla = {
  pageSize: 100,
  pageNum: 1,
  unit:1,
  radio: 1,
  weightUnit:"斤",
  formulaStr: [],
  results: [],

};
export default {
  name: "claDetail",
  props: {
    isEdit: {
      type: Boolean,
      default: false
    }
  },
  data() {
    return {
      cla: Object.assign({}, defaultcla),
      option: [{unit:'斤'},{unit: '克'}, {unit:'千克'}],
      rules: {
        unit: [
          {required: true, message: '请输入菜单名称', trigger: 'blur'},
        ]
      },
      mark:1
    }
  },
  created() {

    getFormulaInfo(this.$route.query.id).then(response => {
      this.cla = response.data;
      let arr = [{}];
      for (let i in response.data.formulaStr) {
        arr[i] = 0
      }
      this.cla.results = arr;
    });
  },
  methods: {
    /**跳转添加标签 **/
    handleAddRate() {
      this.$router.push({path: '/feed/rate'});
    },
    onSubmit(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          this.$confirm('是否发送邮件', '提示', {
            confirmButtonText: '确定',
            cancelButtonText: '取消',
            type: 'warning'
          }).then(() => {
            sendMail(this.cla).then(response => {
              this.$refs[formName].resetFields();
              this.resetForm(formName);
              this.$message({
                message: '提交成功',
                type: 'success',
                duration: 1000
              });
              cla: Object.assign({}, defaultcla)
            });

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
      this.cla = Object.assign({}, defaultcla);
      this.getSelectclaList();
    },
    changeWight(){
      if(this.mark==1) {
        this.mark=this.mark+1;
        this.cla.unit = this.cla.weightUnit;
      }
      this.conversionUnit()
    },
    conversionUnit(){
      let weight=this.cla.weight;
      if(weight>0){
      let dataVal=weight;
      if(this.cla.weightUnit=='克' &this.cla.unit=='斤'){
        dataVal=weight/500;
      }else if(this.cla.weightUnit=='千克' &this.cla.unit=='斤'){
        dataVal=weight*2;
      }else if(this.cla.weightUnit=='斤' &this.cla.unit=='克'){
        dataVal=weight*500;
      }else if(this.cla.weightUnit=='千克' &this.cla.unit=='克'){
        dataVal=weight*1000;
      }else if(this.cla.weightUnit=='克' &this.cla.unit=='千克'){
        dataVal=weight/1000;
      }else if(this.cla.weightUnit=='斤' &this.cla.unit=='千克'){
        dataVal=weight/2;
      }
      this.getResult(dataVal);
      }
    },
    getResult(val){
      let res = 0;
      for (let i = 0; i < this.cla.formula.length; i++) {
        res = val * (this.cla.formula[i].rate / 100);
        this.cla.results[i] = {value: res, key: Date.now() - i},
          this.$set(this.cla.results, i, res.toFixed(2))
      }
      this.$forceUpdate() //强制渲染
    }
  }
}

</script>
<style>
.el-select .el-input {
  width: 90px;
}
.input-with-select .el-input-group__prepend {
  background-color: #fff;
}
</style>
