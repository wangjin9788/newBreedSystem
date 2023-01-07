<template> 
  <breedData-detail :is-edit='false'></breedData-detail>
</template>
<script>
  import breedDataDetail from './components/breedDataDetail'
  export default {
    name: 'addBreedData',
    components: { breedDataDetail }
  }
</script>
<style>
</style>
