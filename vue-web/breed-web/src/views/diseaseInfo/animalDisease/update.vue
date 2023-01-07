<template> 
  <animalDisease-detail :is-edit='true'></animalDisease-detail>
</template>
<script>
  import animalDiseaseDetail from './components/animalDiseaseDetail'
  export default {
    name: 'updateAnimalDisease',
    components: { animalDiseaseDetail }
  }
</script>
<style>
</style>

