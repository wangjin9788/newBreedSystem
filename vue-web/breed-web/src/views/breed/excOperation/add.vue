<template> 
  <excOperation-detail :is-edit='false'></excOperation-detail>
</template>
<script>
  import excOperationDetail from './components/excOperationDetail'
  export default {
    name: 'addExcOperation',
    components: { excOperationDetail }
  }
</script>
<style>
</style>
