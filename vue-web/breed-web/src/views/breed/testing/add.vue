<template> 
  <testing-detail :is-edit='false'></testing-detail>
</template>
<script>
  import testingDetail from './components/testingDetail'
  export default {
    name: 'addTesting',
    components: { testingDetail }
  }
</script>
<style>
</style>
