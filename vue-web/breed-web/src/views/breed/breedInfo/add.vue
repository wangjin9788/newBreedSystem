<template> 
  <breed-detail :is-edit='false'></breed-detail>
</template>
<script>
  import BreedDetail from './components/BreedDetail'
  export default {
    name: 'addBreed',
    components: { BreedDetail }
  }
</script>
<style>
</style>
