<template> 
  <operation-detail :is-edit='true'></operation-detail>
</template>
<script>
  import operationLabelDetail from './components/operationLabelDetail'
  export default {
    name: 'updateOperationLabel',
    components: { operationLabelDetail }
  }
</script>
<style>
</style>

