<template> 
  <day-ferment-detail :is-edit='false'></day-ferment-detail>
</template>
<script>
  import DayFermentDetail from './components/DayFermentDetail'
  export default {
    name: 'addFermentDetail',
    components: { DayFermentDetail }
  }
</script>
<style>
</style>
