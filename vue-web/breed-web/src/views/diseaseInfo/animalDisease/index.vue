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
          <el-input v-model="listQuery.searchName" placeholder="请输入查询关键字" ></el-input>
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
      <el-table ref="revenueTable"
                :data="list"
                style="width: 100%;"
                v-loading="listLoading" border>
        <el-table-column label="编号" width="100" align="center" >
          <template slot-scope="scope">{{ scope.row.adId }}</template>
        </el-table-column>
        <el-table-column label="病害性质" align="center">
          <template slot-scope="scope">{{ scope.row.nature }}</template>
        </el-table-column>
        <el-table-column label="病害名称" align="center">
          <template slot-scope="scope">{{ scope.row.diseaseName }}</template>
        </el-table-column>

        <el-table-column label="病因" align="center">
          <template slot-scope="scope" >
            <span v-html="showDate(scope.row.pathogeny)"></span>
          </template>
        </el-table-column>
        <el-table-column label="症状" align="center">
          <template slot-scope="scope">
          <span v-html="showDate(scope.row.symptom)"></span>
          </template>
        </el-table-column>
        <el-table-column label="治疗方法" align="center">
          <template slot-scope="scope">
            <span v-html="scope.row.treatment"></span>
          </template>
        </el-table-column>
        <el-table-column label="图片" align="center">
          <template slot-scope="scope">
            <img style="height:80px" v-image-preview :src="scope.row.imgUrl">
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
import {fetchList, deleteAnimalDisease} from '@/api/animalDisease';
const defaultListQuery = {
  pageNum: 1,
  pageSize: 5,
  searchName:'',
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
      this.$router.push('/diseaseInfo/addAnimalDisease');
    },
    /**跳转编辑 **/
    handleUpdate(index, row) {
      this.$router.push({path: '/diseaseInfo/updateAnimalDisease', query: {id: row.adId}});
    },

    /** 删除页面**/
    handleDelete(index, row) {
      this.$confirm('是否要删除该养殖记录?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        deleteAnimalDisease(row.adId).then(response => {
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

    // 筛选变色
    showDate(val) {
      val = val + '';
      if ( this.listQuery.searchName != '') {
        return val.replace(this.listQuery.searchName, '<font color="#409EFF">' + this.listQuery.searchName + '</font>')
      } else {
        return val
      }
    }
  }
}
</script>
<style>

.el-table .warning-row {
  background: rgba(253, 230, 231, 0.08);
}

.el-table .success-row {
  background: #ecf9eb;
}
</style>


