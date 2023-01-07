<template> 
  <breedModel-detail :is-edit='false'></breedModel-detail>
</template>
<script>
  import BreedModelDetail from './components/breedModelDetail'
  export default {
    name: 'addBreedModel',
    components: { BreedModelDetail }
  }
</script>
<style>
</style>
