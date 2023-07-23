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

      </div>
      <div style="margin-top: 15px">
        <el-form :inline="true" :model="listQuery" size="small" label-width="140px">
          <el-form-item label="类型：">
            <el-select v-model="listQuery.type" clearable placeholder="请选择">
              <el-option
                v-for="item in selectTypeLists"
                :key="item.type"
                :label="item.labelName"
                :value="item.type">
              </el-option>
            </el-select>
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
          <template slot-scope="scope">{{ scope.row.bfId }}</template>
        </el-table-column>
        <el-table-column label="类型" align="center">
          <template slot-scope="scope">
            <span v-if="scope.row.type==0">基料</span>
            <span v-else>添加饲料</span>
          </template>
        </el-table-column>
        <el-table-column label="适用范围" align="center">
          <template slot-scope="scope">
            <span v-if="scope.row.specs==0">所有</span>
            <span v-if="scope.row.specs==1">小蚯蚓</span>
            <span v-if="scope.row.specs==2">中蚯蚓</span>
            <span v-if="scope.row.specs==3">大蚯蚓</span>
          </template>
        </el-table-column>
        <el-table-column label="饲料内容" align="center">
          <template slot-scope="scope">
            <span v-for="item in scope.row.formula">
               <span>{{ item.name }}:</span>
               <span>{{ item.rate }}%</span><br>
            </span>

          </template>
        </el-table-column>
        <el-table-column>
          <template slot-scope="scope">
            <span class="ql-editor" v-html="scope.row.markMethod"></span>
          </template>
        </el-table-column>
        <el-table-column label="操作" width="160" align="center">
          <template slot-scope="scope">
            <el-row>
              <el-button
                size="mini"
                type="text"
                @click="handleUpdate(scope.$index, scope.row)">计算
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
import {fetchList, selectType} from '@/api/feedFormula';

const defaultListQuery = {
  pageNum: 1,
  pageSize: 10,
  type: ''
};
export default {

  data() {
    return {
      listQuery: Object.assign({}, defaultListQuery),
      list: null,
      total: null,
      listLoading: false,
      selectTypeLists: selectType().then(response => {
        this.selectTypeLists = response.data;
      }),
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
    handleUpdate(index, row) {
      this.$router.push({path: '/formulaCla/formulaInfoCla', query: {id: row.bfId,mark: row.type}});
    },

    /**
     * 加载页面数据
     */
    getList() {
      this.listLoading = true;
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


