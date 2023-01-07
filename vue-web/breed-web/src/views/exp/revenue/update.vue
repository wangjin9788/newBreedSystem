<template> 
  <revenue-detail :is-edit='true'></revenue-detail>
</template>
<script>
  import RevenueDetail from './components/RevenueDetail'
  export default {
    name: 'updateRevenue',
    components: { RevenueDetail }
  }
</script>
<style>
</style>

