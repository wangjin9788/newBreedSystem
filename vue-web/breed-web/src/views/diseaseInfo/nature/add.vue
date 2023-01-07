<template> 
  <nature-detail :is-edit='false'></nature-detail>
</template>
<script>
  import natureDetail from './components/natureDetail'
  export default {
    name: 'addNature',
    components: { natureDetail }
  }
</script>
<style>
</style>
