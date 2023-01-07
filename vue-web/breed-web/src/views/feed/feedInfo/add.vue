<template> 
  <feedInfo-detail :is-edit='false'></feedInfo-detail>
</template>
<script>
  import FeedInfoDetail from './components/FeedInfoDetail'
  export default {
    name: 'addFeedInfo',
    components: { FeedInfoDetail }
  }
</script>
<style>
</style>
