<template> 
  <revenue-detail :is-edit='false'></revenue-detail>
</template>
<script>
  import RevenueDetail from './components/RevenueDetail'
  export default {
    name: 'addRevenue',
    components: { RevenueDetail }
  }
</script>
<style>
</style>
