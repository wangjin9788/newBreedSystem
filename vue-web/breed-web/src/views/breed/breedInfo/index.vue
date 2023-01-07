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
        <el-select v-model="listQuery.status" placeholder="请选择模型">
          <el-option
            v-for="item in queryStatusData"
            :key="item.status"
            :label="item.value"
            :value="item.status">
          </el-option>
        </el-select>
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
    </el-card>
    <div class="table-container">
      <el-table ref="revenueTable"
                :data="list"
                style="width: 100%;"
                :cell-class-name="back"
                v-loading="listLoading" border
                :row-class-name="tableRowClassName">
        <el-table-column label="编号" width="100" align="center" v-if='false'>
          <template slot-scope="scope">{{ scope.row.bid }}</template>
        </el-table-column>
        <el-table-column label="栏位编号" width="100" align="center">
          <template slot-scope="scope">{{ scope.row.number }}</template>
        </el-table-column>
        <el-table-column label="养殖环境" align="center">
          <template slot-scope="scope">
            <span v-if="scope.row.pattern==0">室内</span>
            <span v-else>室外</span>
          </template>
        </el-table-column>
        <el-table-column label="养殖方式" align="center">
          <template slot-scope="scope">{{ scope.row.breedModel }}</template>
        </el-table-column>
        <el-table-column label="养殖规格" align="center">
          <template slot-scope="scope">
            <span v-if="scope.row.specifications==1">小蚯蚓</span>
            <span v-else-if="scope.row.specifications==2">中蚯蚓</span>
            <span v-else="scope.row.specifications==1">大蚯蚓</span>
          </template>
        </el-table-column>
        <el-table-column label="养殖面积㎡" align="center">
          <template slot-scope="scope">{{ scope.row.extent }}</template>
        </el-table-column>
        <el-table-column label="投入重量(斤)" align="center">
          <template slot-scope="scope">{{ scope.row.inputWeight }}</template>
        </el-table-column>
        <el-table-column label="健康状态" align="center">
          <template slot-scope="scope">{{ scope.row.breedMark }}</template>
        </el-table-column>
        <el-table-column label="养殖状态" width="100" align="center">
          <template slot-scope="scope">
            <el-switch
              @change="handleUpdateStatus(scope.$index, scope.row)"
              :active-value="1"
              :inactive-value="0"
              v-model="scope.row.status"
              :disabled="scope.row.status==1?true:false">
            </el-switch>
          </template>
        </el-table-column>
        <el-table-column label="投入时间" align="center">
          <template slot-scope="scope">{{ scope.row.inputTime }}</template>
        </el-table-column>
        <el-table-column label="操作信息" width="160" align="center">
          <template slot-scope="scope">
            <el-row>
              <el-button
                size="mini"
                type="text"
                @click="handleTesting(scope.$index, scope.row)">检测信息
              </el-button>
              <el-button size="mini"
                         type="text"
                         @click="handleOperation(scope.$index, scope.row)">日常操作
              </el-button>

            </el-row>
            <el-row>
              <el-button
                size="mini"
                type="text"
                @click="handleTreatment(scope.$index, scope.row)">治疗信息
              </el-button>
              <el-button size="mini"
                         type="text"
                         @click="handleOutInfo(scope.$index, scope.row)">产出信息
              </el-button>
            </el-row>
            <>
          </template>
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
import {fetchList, deleteBreed} from '@/api/breedInfo';
import {Message} from "element-ui";

const defaultListQuery = {
  pageNum: 1,
  pageSize: 5,
  selectDay: '',
  status: 0
};
export default {

  data() {
    return {
      listQuery: Object.assign({}, defaultListQuery),
      list: null,
      total: null,
      listLoading: false,
      queryStatusData: [{status: 0, value: '养殖中'}, {status: 1, value: '养殖结束'}],
    }
  },
  created() {

    this.getList();
  },

  methods: {
    back(row) {
      if (row.breedMark == 0) {
        return 'selectClass';
      }
    },
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
      this.$router.push('/breed/addBreed');
    },
    /**跳转编辑 **/
    handleUpdate(index, row) {
      this.$router.push({path: '/breed/updateBreed', query: {id: row.bid}});
    },
    /**日常操作 **/
    handleOperation(index, row) {
      this.$router.push({path: '/breed/operation', query: {bid: row.bid}});
    },
    /**检测信息跳转 **/
    handleTesting(index, row) {
      this.$router.push({path: '/breed/testing', query: {bid: row.bid}});
    },
    /**检测信息跳转 **/
    handleTreatment(index, row) {
      this.$router.push({path: '/breed/excInfo', query: {bid: row.bid}});
    },

    /**检测信息跳转 **/
    handleUpdateStatus(index, row) {
      this.$router.push({path: '/breed/addBreedOut', query: {bid: row.bid}});
    },
    /**检测信息跳转 **/
    handleOutInfo(index, row) {
      this.$router.push({path: '/breed/breedOut', query: {bid: row.bid}});
    },
    /** 删除页面**/
    handleDelete(index, row) {
      this.$confirm('是否要删除该养殖记录?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        deleteBreed(row.bid).then(response => {
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
      }).catch(e=>{
        this.listLoading = false;
      })
    },
    /** 改变颜色**/
    tableRowClassName({row, rowIndex}) {
      if (row.excStatus === 0) {
        return 'warning-row';
      } else if (row.excStatus === 1) {
        return 'success-row';
      }
      return '';
    },
  }
}
</script>
<style>

.selectClass {
  background-color: #67C23A;
}
</style>


