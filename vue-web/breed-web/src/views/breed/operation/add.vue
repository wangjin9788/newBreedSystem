<template> 
  <operation-detail :is-edit='false'></operation-detail>
</template>
<script>
  import operationDetail from './components/operationDetail'
  export default {
    name: 'addOperation',
    components: { operationDetail }
  }
</script>
<style>
</style>
