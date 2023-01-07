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
            <el-date-picker v-model="listQuery.selectDay" type="date" placeholder="选择日" @change="handleSearch"
                            value-format="yyyy-MM-dd"></el-date-picker>
          </el-form-item>
        </el-form>
      </div>
    </el-card>
    <el-card class="operate-container" shadow="never">
      <i class="el-icon-tickets"></i>
      <span>数据列表</span>
      <el-button
        type="primary"
        class="btn-add"
        @click="handleAddMenu()"
        size="mini">
        添加
      </el-button>
    </el-card>
    <div class="table-container">
      <el-table ref="revenueTable"
                :data="list"
                style="width: 100%;"
                v-loading="listLoading" border>
        <el-table-column label="编号" width="100" align="center">
          <template slot-scope="scope">{{ scope.row.epid }}</template>
        </el-table-column>
        <el-table-column label="开销类型" align="center">
          <template slot-scope="scope">{{ scope.row.typeName }}</template>
        </el-table-column>
        <el-table-column label="金额" align="center">
          <template slot-scope="scope">{{ scope.row.pay }}</template>
        </el-table-column>
        <el-table-column label="时间" width="100" align="center">
          <template slot-scope="scope">{{ scope.row.createTime }}</template>
        </el-table-column>
        <el-table-column label="操作" width="160" align="center">
          <template slot-scope="scope">
            <el-row>
              <el-button
                size="mini"
                type="text"
                @click="handleUpdate(scope.$index, scope.row)">编辑
              </el-button>
              <el-button size="mini"
                         type="text"
                         @click="handleDelete(scope.$index, scope.row)">删除
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
        :page-sizes="[5,10,15]"
        :total="total">
      </el-pagination>
    </div>
  </div>
</template>
<script>
import {fetchList, createPay, deletePay} from '@/api/pay';
import {formatDate} from '@/utils/date';

const defaultListQuery = {
  pageNum: 1,
  pageSize: 5,
  selectDay: ''
};
const defaultRole = {
  id: null,
  name: null,
  description: null,
  adminCount: 0,
  status: 1
};
export default {

  name: 'roleList',
  data() {
    return {
      listQuery: Object.assign({}, defaultListQuery),
      list: null,
      total: null,
      listLoading: false,
      dialogVisible: false,
      role: Object.assign({}, defaultRole),
      isEdit: false,

    }
  },
  created() {
    this.id = this.$route.query.bid;
    this.getList(this.id);
  },

  filters: {
    formatDateTime(time) {
      if (time == null || time === '') {
        return 'N/A';
      }
      let date = new Date(time);
      return formatDate(date, 'yyyy-MM-dd')
    }
  },
  methods: {

    handleResetSearch() {
      this.listQuery = Object.assign({}, defaultListQuery);
    },
    handleSearch(){

    },
    handleSearchList() {
      this.listQuery.pageNum = 1;
      this.getList(this.id);
    },
    handleSizeChange(val) {
      this.listQuery.pageNum = 1;
      this.listQuery.pageSize = val;
      this.getList(this.id);
    },
    handleCurrentChange(val) {
      this.listQuery.pageNum = val;
      this.getList(this.id);
    },
    handleAddMenu() {
      this.$router.push('/exp/addPay');
    },

    handleDelete(index, row) {
      this.$confirm('是否要删除该营收?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        deletePay(row.epid).then(response => {
          this.$message({
            type: 'success',
            message: '删除成功!'
          });
          this.getList(this.id);
        });
      });
    },
    handleUpdate(index, row) {
      this.$router.push({path: '/exp/updatePay', query: {id: row.epid}});
    },
    getList(id) {
      this.listLoading = true;
      //获取当前时间
      var now = new Date();
      var monthn = now.getMonth() + 1;
      var yearn = now.getFullYear();
      var dayn = now.getDate();
      this.selectDay = yearn + "-" + monthn + "-" + dayn;
      this.handleResetSearch();
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


