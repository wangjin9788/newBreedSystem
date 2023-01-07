<template> 
  <pay-detail :is-edit='false'></pay-detail>
</template>
<script>
  import PayDetail from './components/PayDetail'
  export default {
    name: 'addPay',
    components: { PayDetail }
  }
</script>
<style>
</style>
