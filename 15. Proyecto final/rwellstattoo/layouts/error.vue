<template>
  <v-app class="secondary">
    <v-container fluid fill-height>
      <v-layout align-center>
        <v-flex md12 offset-md4>
          <h1>Ooops! An Error occurred, Sorry!</h1>
          <v-btn fab dark small to="/">
            <v-icon dark>
              home
            </v-icon>
          </v-btn>
        </v-flex>
      </v-layout>
    </v-container>
  </v-app>
</template>

<script>
export default {
  name: 'Error'
}
</script>

<style scoped>

</style>
