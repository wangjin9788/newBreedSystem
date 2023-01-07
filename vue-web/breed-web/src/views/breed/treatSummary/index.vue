<template> 
  <div class="app-container">
    <el-card class="filter-container" shadow="never">
      <div>
        <i class="el-icon-search"></i>
        <span>筛选搜索</span>
        <el-button
          style="float:right"
          type="primary"
          @click="handleSearchList()"
          size="small">
          查询搜索
        </el-button>
        <el-button
          style="float:right;margin-right: 15px"
          @click="handleResetSearch()"
          size="small">
          重置
        </el-button>
      </div>
      <div style="margin-top: 15px">
        <el-form :inline="true" :model="listQuery" size="small" label-width="140px">
          <el-form-item label="输入搜索：">
            <el-date-picker v-model="listQuery.selectDay" type="date" placeholder="选择日期"  value-format="yyyy-MM-dd"></el-date-picker>
          </el-form-item>
        </el-form>
      </div>
    </el-card>
    <el-card class="operate-container" shadow="never">
      <i class="el-icon-tickets"></i>
      <span>数据列表</span>


      <el-button
        style="float:right;margin-right: 15px"
        type="primary"
        class="btn-add"
        @click="handleAddLabel()"
        size="mini">
        添加标签
      </el-button>
    </el-card>
    <div class="table-container">
      <el-table ref="revenueTable"
                :data="list"
                style="width: 100%;"
                v-loading="listLoading" border>
        <el-table-column label="编号" width="100" align="center" >
          <template slot-scope="scope">{{ scope.row.esId }}</template>
        </el-table-column>
        <el-table-column label="异常信息编号" width="100" align="center" v-if="false" >
          <template slot-scope="scope">{{ scope.row.eid }}</template>
        </el-table-column>
        <el-table-column label="病害名称" align="center">
          <template slot-scope="scope">{{ scope.row.diseaseName }}</template>
        </el-table-column>
        <el-table-column label="病因" align="center">
          <template slot-scope="scope">{{ scope.row.pathogeny }}</template>
        </el-table-column>
        <el-table-column label="症状" align="center">
          <template slot-scope="scope">{{ scope.row.symptom }}</template>
        </el-table-column>
        <el-table-column label="治疗方法" align="center">
          <template slot-scope="scope">{{ scope.row.treatment }}</template>
        </el-table-column>
        <el-table-column label="创建时间" align="center">
          <template slot-scope="scope">{{ scope.row.createTime }}</template>
        </el-table-column>
        <el-table-column label="操作" width="160" align="center">
          <template slot-scope="scope">
            <el-row>
              <el-button
                size="mini"
                type="text"
                @click="handleSummaryOperation(scope.$index, scope.row)">查看治疗过程
              </el-button>
            </el-row>
          </template>
        </el-table-column>
      </el-table>
    </div>
    <div class="pagination-container">
      <el-pagination
        background
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange"
        layout="total, sizes,prev, pager, next,jumper"
        :current-page.sync="listQuery.pageNum"
        :page-size="listQuery.pageSize"
        :page-sizes="[10,15,20]"
        :total="total">
      </el-pagination>
    </div>
  </div>
</template>
<script>
import {fetchList} from '@/api/treatSummary';


const defaultListQuery = {
  pageNum: 1,
  pageSize: 5,
  selectDay:'',
};
export default {

  data() {
    return {
      listQuery: Object.assign({}, defaultListQuery),
      list: null,
      total: null,
      listLoading: false,
    }
  },
  created() {
    this.getList();
  },

  methods: {
    /**搜索结果 **/
    handleSearchList() {
      this.listQuery.pageNum = 1;
      this.getList();

    },
    /** 重置搜索**/
    handleResetSearch() {
      this.listQuery = Object.assign({}, defaultListQuery);
    },
    /**跳转第几页 **/
    handleSizeChange(val) {
      this.listQuery.pageNum = 1;
      this.listQuery.pageSize = val;
      this.getList();
    },
    /**一页多少条数据 **/
    handleCurrentChange(val) {
      this.listQuery.pageNum = val;
      this.getList();
    },
    /**跳转编辑 **/
    handleSummaryOperation(index, row) {
      this.$router.push({path: '/breed/summaryOperationInfo', query: {id: row.eid}});
    },
    /**
     * 加载页面数据
     */
    getList() {
      this.listLoading = true;
      //获取当前时间
      var now = new Date();
      var monthn = now.getMonth() + 1;
      var yearn = now.getFullYear();
      this.selectDay = yearn + "-" + monthn;

      fetchList(this.listQuery).then(response => {
        this.listLoading = false;
        this.list = response.data;
        this.total = response.data.total;
      });

    }
  }
}
</script>
<style></style>


