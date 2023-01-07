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
        type="primary"
        class="btn-add"
        @click="handleAddBreed()"
        size="mini">
        添加
      </el-button>
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
          <template slot-scope="scope">{{ scope.row.tid }}</template>
        </el-table-column>
        <el-table-column label="天气信息" align="center">
          <template slot-scope="scope">{{ scope.row.weather }}</template>
        </el-table-column>
        <el-table-column label="气温信息" align="center">
          <template slot-scope="scope">{{ scope.row.temperature }}</template>
        </el-table-column>
        <el-table-column label="ph信息" align="center">
          <template slot-scope="scope">{{ scope.row.ph }}</template>
        </el-table-column>
        <el-table-column label="养殖箱温度" align="center">
          <template slot-scope="scope">{{ scope.row.breedTemperature }}</template>
        </el-table-column>
        <el-table-column label="养殖箱湿度" align="center">
          <template slot-scope="scope">{{ scope.row.breedHumidity }}</template>
        </el-table-column>
        <el-table-column label="病害标签" align="center">
          <template slot-scope="scope">
            <span v-if="scope.row.disease==0">无</span>
            <span v-else>有</span>
           </template>
        </el-table-column>
        <el-table-column label="症状信息" align="center">
          <template slot-scope="scope">{{ scope.row.symptomName }}</template>
        </el-table-column>
        <el-table-column label="图片" align="center">
          <template slot-scope="scope">
            <img style="height:80px" v-image-preview :src="scope.row.imgUrl">
          </template>
        </el-table-column>
        <el-table-column label="操作引起" align="center">
          <template slot-scope="scope">{{ scope.row.content }}</template>
        </el-table-column>
        <el-table-column label="检测时间" align="center">
          <template slot-scope="scope">{{ scope.row.testingTime }}</template>
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
        :page-sizes="[10,15,20]"
        :total="total">
      </el-pagination>
    </div>
  </div>
</template>
<script>
import {fetchList, deleteTesting} from '@/api/testing';

const defaultListQuery = {
  pageNum: 1,
  pageSize: 5,
  selectDay:'',
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
    /**跳转添加 **/
    handleAddBreed() {
      this.$router.push({path: '/breed/addTesting', query: {bid: this.$route.query.bid}});
    },
    /**跳转编辑 **/
    handleUpdate(index, row) {
      this.$router.push({path: '/breed/updateTesting', query: {id: row.tid}});
    },
    /**跳转添加标签 **/
    handleAddLabel() {
      this.$router.push({path: '/breed/addExcLabel'});
    },
    /** 删除页面**/
    handleDelete(index, row) {
      this.$confirm('是否要删除该养殖记录?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        deleteTesting(row.tid).then(response => {
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
      //获取当前时间
      var now = new Date();
      var monthn = now.getMonth() + 1;
      var yearn = now.getFullYear();
      this.selectDay = yearn + "-" + monthn;
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


