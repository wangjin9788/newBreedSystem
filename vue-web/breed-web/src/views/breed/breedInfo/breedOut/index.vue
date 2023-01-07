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
            <el-date-picker v-model="listQuery.selectDay" type="date" placeholder="选择日期" @change="handleResetSearch"
                            value-format="yyyy-MM-dd"></el-date-picker>
          </el-form-item>
        </el-form>
      </div>
    </el-card>
    <el-card class="operate-container" shadow="never">
      <i class="el-icon-tickets"></i>
      <span>数据列表</span>
    </el-card>
    <div class="table-container">
      <el-table ref="revenueTable"
                :data="list"
                style="width: 100%;"
                v-loading="listLoading" border>
        <el-table-column label="编号" width="100" align="center">
          <template slot-scope="scope">{{ scope.row.boId }}</template>
        </el-table-column>
        <el-table-column label="养殖编号" width="100" align="center">
          <template slot-scope="scope">{{ scope.row.bid }}</template>
        </el-table-column>
        <el-table-column label="产出重量" align="center">
          <template slot-scope="scope">{{ scope.row.outPut }}</template>
        </el-table-column>
        <el-table-column label="产出时间" align="center">
          <template slot-scope="scope">{{ scope.row.outTime }}</template>
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
        :page-sizes="[5,10,15]"
        :total="total">
      </el-pagination>
    </div>
  </div>
</template>
<script>
import {fetchList} from '@/api/breedOut';

const defaultListQuery = {
  pageNum: 1,
  pageSize: 5,
  selectDay: '',
  bid:0
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

    getList() {
      this.listLoading = true;
      this.handleResetSearch();
      this.listQuery.bid=this.$route.query.bid;
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


