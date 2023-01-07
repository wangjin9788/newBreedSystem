<template> 
  <operationDetail :is-edit='true'></operationDetail>
</template>
<script>
  import operationDetail from './components/operationDetail'
  export default {
    name: 'updateOperation',
    components: { operationDetail }
  }
</script>
<style>
</style>

