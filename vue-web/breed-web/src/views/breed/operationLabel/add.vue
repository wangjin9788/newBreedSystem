<template> 
  <operationLabel-detail :is-edit='false'></operationLabel-detail>
</template>
<script>
  import operationLabelDetail from './components/operationLabelDetail'
  export default {
    name: 'addOperationLabel',
    components: { operationLabelDetail }
  }
</script>
<style>
</style>
