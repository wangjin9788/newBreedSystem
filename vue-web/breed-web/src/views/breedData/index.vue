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
        <el-button
          style="float:right;margin-top: 20px"
          type="primary"
          class="btn-add"
          @click="handleAddBreed()"
          size="mini">
          添加
        </el-button>
        <el-button
          style="float:right;margin-right: 15px;margin-top: 20px"
          type="primary"
          class="btn-add"
          @click="updateBreedData()"
          size="mini">
          编辑
        </el-button>
        <el-form :inline="true" :model="listQuery" size="small" label-width="140px">
          <el-form-item label="目录：">
            <el-form :inline="true" :model="listQuery" size="small" label-width="20px">
              <el-select v-model="listQuery.dlId" placeholder="请选择目录" style="display: block">
                <el-option
                  v-for="item in selectLabelLists"
                  :key="item.dlId"
                  :label="item.labelName"
                  :value="item.dlId">
                </el-option>
              </el-select>
            </el-form>
          </el-form-item>
          <el-form-item label="输入搜索：">
            <el-input v-model="listQuery.searchName" placeholder="请输入查询关键字"></el-input>
          </el-form-item>

        </el-form>

      </div>
    </el-card>

    <div class="table-container">
        <el-collapse v-for="(item,index) in list"  :key="index" accordion>
          <el-collapse-item  :title="'' + item.labelName + ''" :name="''+index+''">
            <span v-html="showDate(item.content)"></span>
          </el-collapse-item>
        </el-collapse>
    </div>
  </div>
</template>
<script>
import {fetchList, selectLabel} from '@/api/breedData';

const defaultListQuery = {
  searchName: '',
  menuNumber: 0,
  dlId: 0,
};
export default {
  data() {
    return {
      listQuery: Object.assign({}, defaultListQuery),
      content: null,
      adId: '',
      listLoading: false,
      selectLabelLists: null,
      list:[]

    }
  },
  created() {
    this.listQuery.menuNumber = this.$route.meta.number;
    this.selectLabelLists = this.getSelectLabel();
    this.getList();
  },
  watch: {
    $route(newVal, oldVal) {
      this.listQuery.menuNumber = this.$route.meta.number;
      this.getList();
      this.getSelectLabel();
    }
  },
  methods: {
    getSelectLabel() {
      selectLabel(this.listQuery).then(response => {
        this.selectLabelLists = response.data;
      })
    },
    /**搜索结果 **/
    handleSearchList() {
      this.listQuery.pageNum = 1;
      this.getList();

    },
    /**跳转添加 **/
    handleAddBreed() {
      this.$router.push('/breedData/addBreedData');
    },
    /**跳转添加 **/
    updateBreedData() {
      if (this.adId == '') {
        this.$confirm('暂时没有数据修改', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        })
      } else {
        this.$router.push({path: '/breedData/updateBreedData', query: {id: this.adId}});
      }
    },
    /**
     * 加载页面数据
     */
    getList() {
      fetchList(this.listQuery).then(response => {
        this.list = response.data;
        this.$forceUpdate() //强制渲染
      }).catch(err => {
        this.content = '';
      });

    },
    // 筛选变色
    showDate(val) {
      val = val + '';
      if (this.listQuery.searchName != '') {
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


