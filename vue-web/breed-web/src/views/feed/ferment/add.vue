<template> 
  <ferment-detail :is-edit='false'></ferment-detail>
</template>
<script>
  import FermentDetail from './components/FermentDetail'
  export default {
    name: 'addFerment',
    components: { FermentDetail }
  }
</script>
<style>
</style>
