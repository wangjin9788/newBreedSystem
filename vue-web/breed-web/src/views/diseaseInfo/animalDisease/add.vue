<template> 
  <animalDisease-detail :is-edit='false'></animalDisease-detail>
</template>
<script>
  import animalDiseaseDetail from './components/animalDiseaseDetail'
  export default {
    name: 'addAnimalDisease',
    components: { animalDiseaseDetail }
  }
</script>
<style>
</style>
