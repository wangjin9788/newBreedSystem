<template> 
  <div class="app-container">
    <el-card class="operate-container" shadow="never">
      <i class="el-icon-tickets"></i>
      <span>数据列表</span>
      <el-button
        type="primary"
        class="btn-add"
        @click="handleAddBreed()"
        size="mini">
        添加
      </el-button>
    </el-card>
    <div class="table-container">
      <el-table ref="revenueTable"
                :data="list"
                style="width: 100%;"
                v-loading="listLoading" border>
        <el-table-column label="编号" width="100" align="center" >
          <template slot-scope="scope">{{ scope.row.fdId }}</template>
        </el-table-column>
        <el-table-column label="发酵堆编号" align="center">
          <template slot-scope="scope">{{scope.row.ffId}}
          </template>
        </el-table-column>
        <el-table-column label="气温" align="center">
          <template slot-scope="scope">{{scope.row.head}}
          </template>
        </el-table-column>
        <el-table-column label="堆温" align="center">
          <template slot-scope="scope">{{ scope.row.heapHead }}</template>
        </el-table-column>
        <el-table-column label="记录时间" align="center">
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
        :page-sizes="[50,80,100,]"
        :total="total">
      </el-pagination>
    </div>
  </div>
</template>
<script>
import {fetchList, deleteFermentDetail} from '@/api/dayFermentDetail';

const defaultListQuery = {
  pageNum: 1,
  pageSize: 50,
  ffId:0,
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
    this.listQuery.ffId=this.$route.query.id;
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
    /**跳转添加 **/
    handleAddBreed() {
      this.$router.push({path: '/feed/addFermentDetail', query: {ffId: this.$route.query.id}});
    },
    /**跳转编辑 **/
    handleUpdate(index, row) {
      this.$router.push({path: '/feed/updateFermentDetail', query: {id: row.fdId,ffId:this.$route.query.id}});
    },
    /** 删除页面**/
    handleDelete(index, row) {
      this.$confirm('是否要删除该记录?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        deleteFermentDetail(row.fdId).then(response => {
          this.$message({
            type: 'success',
            message: '删除成功!'
          });
          this.getList();
        });
      });
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


