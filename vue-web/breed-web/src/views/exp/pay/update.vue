<template> 
  <pay-detail :is-edit='true'></pay-detail>
</template>
<script>
  import PayDetail from './components/PayDetail'
  export default {
    name: 'updatePay',
    components: { PayDetail }
  }
</script>
<style>
</style>

