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
    </el-card>
    <div class="table-container">
      <el-tabs v-model="activeName" @tab-click="getFermentList">
        <el-tab-pane label="发酵中"  name="ferment">
          <el-table ref="revenueTable"
                    :data="list"
                    style="width: 100%;"
                    v-loading="listLoading" border>
            <el-table-column label="编号" width="100" align="center" >
              <template slot-scope="scope">{{ scope.row.ffId }}</template>
            </el-table-column>
            <el-table-column label="发酵原料" align="center">
              <template slot-scope="scope">
                <span class="ql-editor" v-html="scope.row.fermentInfo"></span>
              </template>
            </el-table-column>
            <el-table-column label="发酵天数" align="center">
              <template slot-scope="scope">{{ scope.row.fermentDay }}</template>
            </el-table-column>
            <el-table-column label="状态" align="center">
              <template slot-scope="scope">
                <span v-if="scope.row.status==0">发酵中</span>
                <span v-else>发酵结束</span> </template>
            </el-table-column>

            <el-table-column label="图片" align="center">
              <template slot-scope="scope">
                <img style="height:80px" v-image-preview :src="scope.row.createImage">
              </template>
            </el-table-column>
            <el-table-column label="发酵时间" align="center">
              <template slot-scope="scope">{{ scope.row.fermentTime }}</template>
            </el-table-column>
            <el-table-column label="结束标识" width="100" align="center">
              <template slot-scope="scope">
                <el-switch
                  @change="handleStatusChange(scope.$index, scope.row)"
                  :active-value="1"
                  :inactive-value="0"
                  v-model="scope.row.status"
                  :disabled="scope.row.status==1 ? true:false">
                </el-switch>
              </template>
            </el-table-column>
            <el-table-column label="查看数据" width="160" align="center">
              <template slot-scope="scope">
                <el-row>
                  <el-button
                    size="mini"
                    type="text"
                    @click="handleEndTestingInfo(scope.$index, scope.row)">结束检测信息
                  </el-button>
                </el-row>
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
                <el-row>
                  <el-button size="mini"
                             type="text"
                             @click="handleDetail(scope.$index, scope.row)">发酵详情
                  </el-button>
                </el-row>
              </template>
            </el-table-column>
          </el-table>
        </el-tab-pane>
        <el-tab-pane label="已完成"  name="fermentSuccess">
          <el-table ref="revenueTable"
                    :data="list"
                    style="width: 100%;"
                    v-loading="listLoading" border>
            <el-table-column label="编号" width="100" align="center" >
              <template slot-scope="scope">{{ scope.row.ffId }}</template>
            </el-table-column>
            <el-table-column label="发酵原料" align="center">
              <template slot-scope="scope">
                <span class="ql-editor" v-html="scope.row.fermentInfo"></span>
              </template>
            </el-table-column>
            <el-table-column label="发酵天数" align="center">
              <template slot-scope="scope">{{ scope.row.fermentDay }}</template>
            </el-table-column>
            <el-table-column label="状态" align="center">
              <template slot-scope="scope">
                <span v-if="scope.row.status==0">发酵中</span>
                <span v-else>发酵结束</span> </template>
            </el-table-column>

            <el-table-column label="图片" align="center">
              <template slot-scope="scope">
                <img style="height:80px" v-image-preview :src="scope.row.createImage">
              </template>
            </el-table-column>
            <el-table-column label="发酵时间" align="center">
              <template slot-scope="scope">{{ scope.row.fermentTime }}</template>
            </el-table-column>
            <el-table-column label="结束标识" width="100" align="center">
              <template slot-scope="scope">
                <el-switch
                  @change="handleStatusChange(scope.$index, scope.row)"
                  :active-value="1"
                  :inactive-value="0"
                  v-model="scope.row.status"
                  :disabled="scope.row.status==1 ? true:false">
                </el-switch>
              </template>
            </el-table-column>
            <el-table-column label="查看数据" width="160" align="center">
              <template slot-scope="scope">
                <el-row>
                  <el-button
                    size="mini"
                    type="text"
                    @click="handleEndTestingInfo(scope.$index, scope.row)">结束检测信息
                  </el-button>
                </el-row>
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
                <el-row>
                  <el-button size="mini"
                             type="text"
                             @click="handleDetail(scope.$index, scope.row)">发酵详情
                  </el-button>
                </el-row>
              </template>
            </el-table-column>
          </el-table>
        </el-tab-pane>
      </el-tabs>

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
import {fetchList, deleteFerment} from '@/api/ferment';

const defaultListQuery = {
  pageNum: 1,
  pageSize: 5,
  fermentStatus:0,
};
export default {

  data() {
    return {
      listQuery: Object.assign({}, defaultListQuery),
      list: null,
      total: null,
      listLoading: false,
      activeName: 'ferment'
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
      this.$router.push('/feed/addFerment');
    },
    /**跳转添加结束 **/
    handleStatusChange(index, row) {
      this.$confirm('添加检测信息', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        this.$router.push({path:'/feed/addFermentTesting',query: {id: row.ffId}});
      })
    },
    /**跳转编辑 **/
    handleUpdate(index, row) {
      this.$router.push({path: '/feed/updateFerment', query: {id: row.ffId}});
    },
    /**跳转查看结束信息 **/
    handleEndTestingInfo(index, row) {
      this.$router.push({path: '/feed/fermentTesting', query: {id: row.ffId}});
    },
    /**跳转发酵详情信息 **/
    handleDetail(index, row) {
      this.$router.push({path: '/feed/fermentDetail', query: {id: row.ffId}});
    },
    /** 删除页面**/
    handleDelete(index, row) {
      this.$confirm('是否要删除该养殖记录?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        deleteFerment(row.ffId).then(response => {
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

    },
    getFermentList(tab, event){
     this.listQuery.fermentStatus =0;
      if(tab.name=='fermentSuccess'){
        this.listQuery.fermentStatus=1;
      }
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


