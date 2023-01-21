<template>
  <v-container grid-list-md text-xs-center>
    <v-layout row wrap>
      <v-flex xs12 sm12 md6>
        <img src="../assets/head.svg">
      </v-flex>
      <v-flex xs12 sm12 md6>
        <img src="../assets/head2.svg">
      </v-flex>
    </v-layout>
    <v-layout row wrap>
      <v-flex
        v-for="item in items"
        :key="item.id"
        xs12
        sm6
        md3
        lg4
      >
        <v-card flat class="secondary">
          <v-img
            :src="item.img"
            class="primary lighten-2"
          />
        </v-card>
      </v-flex>
    </v-layout>
    <v-btn
      color="primary"
      dark
      big
      fixed
      right
      bottom
      fab
      href="https://www.instagram.com/rwellstattoo/"
      target="_blank"
    >
      <v-icon>instagram</v-icon>
    </v-btn>
  </v-container>
</template>
<script>
export default {
  layout: 'landing',
  data() {
    return {
      items: [
        {
          id: '1',
          img: require('../assets/ig/2018-08-31_23-01-51_UTC.jpg')
        },
        {
          id: '2',
          img: require('../assets/ig/2018-09-01_10-10-32_UTC.jpg')
        },
        {
          id: '3',
          img: require('../assets/ig/2018-09-17_14-07-35_UTC_3.jpg')
        },
        {
          id: '4',
          img: require('../assets/ig/2018-09-20_19-07-58_UTC_1.jpg')
        },
        {
          id: '5',
          img: require('../assets/ig/2018-11-12_23-51-14_UTC.jpg')
        },
        {
          id: '6',
          img: require('../assets/ig/2018-11-13_21-49-39_UTC.jpg')
        },
        {
          id: '7',
          img: require('../assets/ig/2018-11-15_20-45-31_UTC_1.jpg')
        },
        {
          id: '8',
          img: require('../assets/ig/2018-11-30_22-08-54_UTC.jpg')
        },
        {
          id: '9',
          img: require('../assets/ig/2019-01-02_21-46-56_UTC.jpg')
        },
        {
          id: '10',
          img: require('../assets/ig/2019-01-28_20-18-38_UTC.jpg')
        },
        {
          id: '11',
          img: require('../assets/ig/2019-03-05_15-01-15_UTC.jpg')
        },
        {
          id: '12',
          img: require('../assets/ig/2019-03-20_22-04-13_UTC.jpg')
        },
        {
          id: '13',
          img: require('../assets/ig/2019-03-27_20-37-59_UTC.jpg')
        },
        {
          id: '14',
          img: require('../assets/ig/2019-03-29_22-17-48_UTC.jpg')
        },
        {
          id: '15',
          img: require('../assets/ig/2019-04-02_19-52-48_UTC.jpg')
        }
      ]
    }
  }
}
</script>
