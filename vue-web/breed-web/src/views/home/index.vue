<template>
  <div class="app-container">
    <div class="address-layout">
      <el-row >
        <el-col :span="10" style="padding-right: 40px">
          <div class="out-border">
            <div class="layout-title">收入支出统计</div>
            <div style="padding: 10px;border-left:1px solid #DCDFE6">
               <el-select v-model="yearPayTime"  style="float: right;z-index: 1"
                      placeholder="请选择类型"   @change="selectData">
               <el-option
                  v-for="item in selectPayLists"
                  :key="item"
                  :label="item"
                  :value="item"
                  >
                </el-option>
              </el-select>
             </div>
             <div>
              <ve-pie
                :data="payChartData"
                :legend-visible="true"
                :loading="loading"
                :data-empty="dataEmpty"

                :yearPayTime="yearPayTime"
               ></ve-pie>
            </div>
          </div>
        </el-col >
          <el-col :span="10" style="padding-right: 40px">
              <div class="out-border">
                <div class="layout-title">支出品类统计</div>
                 <div style="padding: 10px;border-left:1px solid #DCDFE6">
                     <el-select v-model="yearPic"  style="float: right;z-index: 1"
                            placeholder="请选择类型"   @change="selectCategoryData">
                     <el-option
                        v-for="item in selectCategoryLists"
                        :key="item"
                        :label="item"
                        :value="item"
                        >
                      </el-option>
                    </el-select>
                   </div>
                 <div>
                  <ve-pie
                    :data="payCategoryChartData"
                    :legend-visible="true"
                    :loading="loading"
                    :data-empty="dataEmpty"
                    :yearPic="yearPic"
                    ></ve-pie>
                </div>
              </div>
            </el-col>
      </el-row>

    </div>

    <div class="statistics-layout">
      <div class="layout-title">金额统计</div>
      <el-row>
        <el-col :span="20">
          <div style="padding: 10px;border-left:1px solid #DCDFE6">
            <div>
              <ve-histogram
                :data="chartData"
                :legend-visible="true"
                :loading="loading"
                :data-empty="dataEmpty"
                :settings="chartSettings"></ve-histogram>
            </div>
          </div>
        </el-col>
      </el-row>
    </div>
  </div>
</template>

<script>
  import {getPayAndRevenue,getYearPicRate,getPayCategoryRate,getYearData,getMonthData} from '@/api/home';
  const colors = [
    'rgb(1,231,225)',
    'rgb(229,88,234)',
    'rgb(160,81,235)',
    'rgb(42,178,116)',
    'rgb(233,156,187)',
    'rgb(241,213,100)',
    'rgb(116,216,243)',
    'rgb(55,182,255)',
    'rgb(1,231,225)',
    'rgb(229,88,234)',
    'rgb(160,81,235)',
    'rgb(42,178,116)',
    'rgb(233,156,187)',
    'rgb(241,213,100)',
    'rgb(116,216,243)',
    'rgb(55,182,255)',
    'rgb(1,231,225)',
    'rgb(229,88,234)',
    'rgb(160,81,235)',
    'rgb(42,178,116)',
    'rgb(233,156,187)',
    'rgb(241,213,100)',
    'rgb(116,216,243)',
    'rgb(55,182,255)',
    'rgb(1,231,225)',
    'rgb(229,88,234)',
    'rgb(160,81,235)',
    'rgb(42,178,116)',
    'rgb(233,156,187)',
    'rgb(241,213,100)',
    'rgb(116,216,243)',
    'rgb(55,182,255)',
    'rgb(1,231,225)',
    'rgb(229,88,234)',
    'rgb(160,81,235)',
    'rgb(42,178,116)',
    'rgb(233,156,187)',
    'rgb(241,213,100)',
    'rgb(116,216,243)',
    'rgb(55,182,255)',
  ];
  export default {
    name: 'home',
    data() {

      return {
        chartSettings: {
          xAxisType: 'time',
          area:true,
          labelMap: {'pay': '支付', 'revenue': '营收'}},
          chartData: {
          columns: [],
          rows: [],
          tooltipShow: true,
            showDetail:0,//默认第一项展开
            transferList:[]
        },
        payChartData:{
         columns: [],
          rows: [],
          tooltipShow: true,
          color:[],
        },
        payCategoryChartData:{
         columns: [],
          rows: [],
          tooltipShow: true,
          color:[],
        },
        loading: false,
        dataEmpty: false,

        selectPayLists: getYearData().then(response => {
              this.selectPayLists = response.data;}),
        selectCategoryLists: getYearData().then(response => {
               this.selectCategoryLists = response.data;})
      }

    },
    created(){
      this.initOrderCountDate();
      this.getData();
      this.selectData();
      this.selectCategoryData();
    },
    methods: {

      handleDateChange() {
        this.getData();
        this.selectData();
        this.selectCategoryData();
      },
      initOrderCountDate() {
        var date=new Date();
        var year=date.getFullYear();
        this.yearPayTime = year;
        this.yearPic = year;

      },
      getData() {
        setTimeout(() => {
          this.chartData = {
            columns: ['date', 'pay', 'revenue'],
            rows: []
          };
          getPayAndRevenue().then(response => {
            for (let i = 0; i < response.data.length; i++) {
              let item = response.data[i];
              this.chartData.rows.push(item);
            }
          });

          this.dataEmpty = false;
          this.loading = false
        }, 1000);


      },
      selectData() {
        setTimeout(() => {
          /** 第一个饼状图 **/
          this.payChartData = {
            columns: ['type', 'money'],
            rows: [],
            color: []

          };
          /** 第一个饼状图 **/
          getYearPicRate(this.yearPayTime).then(response => {
            for (let i = 0; i < response.data.length; i++) {
              let item = response.data[i];
              this.payChartData.rows.push(item);
            }
          });
        }, 1000);
      },
      selectCategoryData() {
        setTimeout(() => {
          /** 第二个饼状图 **/
          this.payCategoryChartData = {
            columns: ['typeName', 'money'],
            rows: [],
            color: []
          };
          /** 第二个饼状图 **/
          getPayCategoryRate(this.yearPic).then(response => {
            for (let i = 0; i < response.data.length; i++) {
              let item = response.data[i];
              this.payCategoryChartData.rows.push(item);
              this.payCategoryChartData.color.push(colors[i]);
            }
          });
        }, 1000);
      }
    }
  }




</script>

<style scoped>
  .app-container {
    margin-top: 40px;
    margin-left: 120px;
    margin-right: 120px;
  }

  .address-layout {
    width: 120%;
  }

  .layout-title {
    color: #606266;
    padding: 25px 50px;
    background: #F2F6FC;
    font-weight: bold;
  }

  .out-border {
    border: 1px solid #DCDFE6;
  }
  .statistics-layout {
   width: 100%;
    margin-top: 40px;
    border: 1px solid #DCDFE6;
  }

</style>
