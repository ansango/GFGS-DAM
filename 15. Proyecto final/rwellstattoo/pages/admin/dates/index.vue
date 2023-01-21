<template>
  <v-container grid-list-md text-xs-center>
    <v-layout row wrap>
      <v-flex
        v-for="(appointment, index) in getAppointments"
        :key="index"
        xs12
        sm6
        md4
      >
        <v-card
          class="mx-auto"
          color="primary"
          max-width="500"
          style="border-radius: 15px"
          dark
        >
            <v-layout row style="padding: 5px 5px 0px 5px">
            <v-icon
              left
              style="margin-left: 25px"
            >
              face
            </v-icon>
              <v-card-title class="text-truncate"><h3>{{ appointment.name }} {{ appointment.lastname }}</h3></v-card-title>
            <v-spacer />
            <v-btn flat icon :to="'/admin/dates/updateDate/' + appointment._id">
              <v-icon>
                edit
              </v-icon>
            </v-btn>
            <delete-appointment :appointment-id="appointment._id"/>
            </v-layout>
          <v-divider />
          <v-card-text class="headline font-weight-bold">
            <v-layout row>
              <v-flex class="first-col">
                <h6>
                  Fecha:
                </h6>
              </v-flex>
              <v-spacer />
              <v-flex xs4 class="second-col">
                <h6>
                  {{ appointment.date }}
                </h6>
              </v-flex>
            </v-layout>
            <v-layout row>
              <v-flex class="first-col">
                <h6>
                  Hora:
                </h6>
              </v-flex>
              <v-spacer />
              <v-flex xs4 class="second-col">
                <h6>
                  {{ appointment.startTime }}
                </h6>
              </v-flex>
            </v-layout>
            <v-layout row>
              <v-flex class="first-col">
                <h6>
                  Tatuaje:
                </h6>
              </v-flex>
              <v-spacer />
              <v-flex xs4 class="second-col">
                <h6>
                  {{ appointment.style }}
                </h6>
              </v-flex>
            </v-layout>
            <v-layout row>
              <v-flex class="first-col">
                <h6>
                  Tipo:
                </h6>
              </v-flex>
              <v-spacer />
              <v-flex xs4 class="second-col">
                <h6>
                  {{ appointment.type }}
                </h6>
              </v-flex>
            </v-layout>
            <v-layout row>
              <v-flex class="first-col">
                <h6>
                  Precio:
                </h6>
              </v-flex>
              <v-spacer />
              <v-flex xs4 class="second-col">
                <h6>
                  {{ appointment.price }}
                </h6>
              </v-flex>
            </v-layout>
            <v-layout row>
              <v-flex class="first-col">
                <h6>
                  Fianza:
                </h6>
              </v-flex>
              <v-spacer />
              <v-flex xs4 class="second-col">
                <h6>
                  {{ appointment.deposit }}
                </h6>
              </v-flex>
            </v-layout>
            <v-layout row>
              <v-flex class="first-col">
                <h6>
                  Total a cobrar:
                </h6>
              </v-flex>
              <v-spacer />
              <v-flex xs4 class="second-col">
                <h6>
                  {{ appointment.price - appointment.deposit }}
                </h6>
              </v-flex>
            </v-layout>
          </v-card-text>
        </v-card>
      </v-flex>
    </v-layout>
    <v-btn
      color="purple darken-1"
      dark
      big
      fixed
      right
      bottom
      fab
      to="/admin/appointments/createAppointment"
    >
      <v-icon>add</v-icon>
    </v-btn>
  </v-container>
</template>

<script>
import { mapGetters } from 'vuex'
import { APPOINTMENTS_PATH, APPOINTMENTS_NAME, GET_APPOINTMENTS } from '../../../store/types'
import deleteAppointment from '../../../components/admin/appointments/deleteAppointment'

export default {
  components: { deleteAppointment },
  layout: 'admin',
  middleware: 'auth',
  data() {
    return {
      appointment: {}
    }
  },
  computed: {
    ...mapGetters(APPOINTMENTS_NAME, ['getAppointments'])
  },
  mounted() {
    this.$store.dispatch(APPOINTMENTS_PATH + GET_APPOINTMENTS)
  }
}
</script>
<style>
  h6{
    font-size: 13px!important;
  }
  .first-col{
    text-align: left;
  }
  .second-col{
    text-align: right;
  }
</style>
