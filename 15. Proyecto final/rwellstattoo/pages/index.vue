<template>
  <v-container grid-list-md text-xs-center>
    <v-layout row wrap>
      <v-flex xs12>
        <img src="../assets/maskjap1.svg">
      </v-flex>
    </v-layout>
    <v-layout row>
      <v-flex xs4>
        <v-card tile class="secondary" flat>
          <v-card-text><img src="../assets/f1.svg"></v-card-text>
        </v-card>
      </v-flex>
      <v-flex xs4>
        <v-card tile class="secondary" flat>
          <v-card-text><img src="../assets/f2.svg"></v-card-text>
        </v-card>
      </v-flex>
      <v-flex xs4>
        <v-card tile class="secondary" flat>
          <v-card-text><img src="../assets/f3.svg"></v-card-text>
        </v-card>
      </v-flex>
    </v-layout>
    <v-layout row>
      <v-flex xs4>
        <v-card tile class="secondary" flat>
          <v-card-text><img src="../assets/f4.svg"></v-card-text>
        </v-card>
      </v-flex>
      <v-flex xs4>
        <v-card tile class="secondary" flat>
          <v-card-text><img src="../assets/f5.svg"></v-card-text>
        </v-card>
      </v-flex>
      <v-flex xs4>
        <v-card tile class="secondary" flat>
          <v-card-text><img src="../assets/f6.svg"></v-card-text>
        </v-card>
      </v-flex>
    </v-layout>
    <v-layout row wrap justify-center class="my-5">
      <v-flex xs12 sm8>
        <v-card>
          <iframe
            id="place"
            src="https://www.google.com/maps/embed?pb=!1m14!1m8!1m3!1d753.2008720636826!2d-5.6500089!3d40.9638836!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x0%3A0xd5ce5539672cfd13!2sNot+Sorry+Hair+%26+Tattoo!5e0!3m2!1ses!2ses!4v1554292901495!5m2!1ses!2ses"
            width="100%"
            height="400"
            frameborder="0"
            style="border:0"
            allowfullscreen
          />
        </v-card>
      </v-flex>
    </v-layout>
    <v-btn
      class="primary"
      dark
      big
      fixed
      right
      bottom
      fab
      to="/about"
    >
      <v-icon>mail</v-icon>
    </v-btn>
  </v-container>
</template>
<script>
export default {
  layout: 'landing',
  data() {
    return {}
  }
}
</script>
