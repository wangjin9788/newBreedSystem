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
    <el-tabs v-model="activeName" @tab-click="handleClick">
      <el-tab-pane label="普通操作" name="generalOperation">
          <div class="table-container">
            <el-table ref="revenueTable"
                      :data="list"
                      style="width: 100%;"
                      v-loading="listLoading" border>
              <el-table-column label="编号" width="100" align="center" >
                <template slot-scope="scope">{{ scope.row.oid }}</template>
              </el-table-column>
              <el-table-column label="操作原因" align="center">
                <template slot-scope="scope">
                <span class="ql-editor" v-viewer v-html=" scope.row.reason"></span>
                </template>
              </el-table-column>
              <el-table-column label="操作内容" align="center">
                <template slot-scope="scope">
                  <span class="ql-editor" v-html="scope.row.content"></span>
                </template>
              </el-table-column>

              <el-table-column label="操作时间" align="center">
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
        </el-tab-pane>
      <el-tab-pane label="药物操作" name="drugOperation">
        <div class="table-container">
          <el-table ref="revenueTable"
                    :data="list"
                    style="width: 100%;"
                    v-loading="listLoading" border>
            <el-table-column label="编号" width="100" align="center" >
              <template slot-scope="scope">{{ scope.row.oid }}</template>
            </el-table-column>
            <el-table-column label="操作原因" align="center">
              <template slot-scope="scope">
                <span class="ql-editor" v-viewer v-html=" scope.row.reason"></span>
              </template>
            </el-table-column>
            <el-table-column label="操作内容" align="center">
              <template slot-scope="scope">
                <span class="ql-editor" v-html="scope.row.content"></span>
              </template>
            </el-table-column>

            <el-table-column label="操作时间" align="center">
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
      </el-tab-pane>
      <el-tab-pane label="营养/菌液操作" name="nutritionOperation">
        <div class="table-container">
          <el-table ref="revenueTable"
                    :data="list"
                    style="width: 100%;"
                    v-loading="listLoading" border>
            <el-table-column label="编号" width="100" align="center" >
              <template slot-scope="scope">{{ scope.row.oid }}</template>
            </el-table-column>
            <el-table-column label="操作原因" align="center">
              <template slot-scope="scope">
                <span class="ql-editor" v-viewer v-html=" scope.row.reason"></span>
              </template>
            </el-table-column>
            <el-table-column label="操作内容" align="center">
              <template slot-scope="scope">
                <span class="ql-editor" v-html="scope.row.content"></span>
              </template>
            </el-table-column>

            <el-table-column label="操作时间" align="center">
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
      </el-tab-pane>
    </el-tabs>
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
import {fetchList, deleteOperation} from '@/api/operation';

const defaultListQuery = {
  pageNum: 1,
  pageSize: 5,
  selectDay:'',
  bid:0,
  type:0
};
export default {

  data() {
    return {
      listQuery: Object.assign({}, defaultListQuery),
      list: null,
      total: null,
      listLoading: false,
      activeName: 'generalOperation'
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
      this.$router.push({path: '/breed/addOperation', query: {bid: this.$route.query.bid}});
    },
    /**跳转编辑 **/
    handleUpdate(index, row) {
      this.$router.push({path: '/breed/updateOperation', query: {id: row.oid,type:row.type}});
    },

    /** 删除页面**/
    handleDelete(index, row) {
      this.$confirm('是否要删除该养殖记录?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        deleteOperation(row.oid).then(response => {
          this.$message({
            type: 'success',
            message: '删除成功!'
          });
          this.getList();
        });
      });
    },
    handleClick(tab, event) {
      this.listQuery.type=0;
      if(tab.name=='drugOperation'){
        this.listQuery.type=1;
      }else if (tab.name=='nutritionOperation'){
        this.listQuery.type=2;
      }
        this.getList();
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


