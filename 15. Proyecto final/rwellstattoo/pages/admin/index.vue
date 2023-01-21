<template>
  <div style="padding-left: 5%; padding-right: 5%">
    <v-container grid-list-md text-xs-center>
      <v-layout row wrap justify-center>
        <v-flex xs5 sm4 md2>
          <clock />
        </v-flex>
      </v-layout>
    </v-container>
    <v-container grid-list-md text-xs-center>
      <v-layout row wrap justify-center>
        <v-layout row wrap justify-center style="max-width: 500px">
          <v-flex v-for="(req, index) in getReqAppointments" :key="req.id" xs12>
            <v-card class="elevation-1" style="border: #BDBDBD solid 1.25px; border-radius:15px;">
              <v-card-title
                primary-title
                style="padding: 10px;"
              >
                <v-icon color="primary" style="margin-left:10px; margin-right: 10px">
                  mail
                </v-icon>
                <div style="font-weight: bold">
                  {{ req.name }} {{ req.lastname }}
                </div>
                <v-layout row wrap justify-end>
                  <v-btn icon flat color="primary" @click="toggle(index)">
                    <v-icon> keyboard_arrow_up <!--{{ toggle ? 'keyboard_arrow_up' : 'keyboard_arrow_down' }}--></v-icon>
                  </v-btn>
                </v-layout>
              </v-card-title>
              <div v-if="selectedIndex == index">
                <v-container>
                  <v-layout row wrap>
                    <v-flex xs12 sm6>
                      <v-text-field
                        box
                        label="Petición creada:"
                        :value="req.createdAt"
                        disabled
                      />
                    </v-flex>
                    <v-flex xs12 sm6>
                      <v-text-field
                        box
                        label="Fecha solicitada:"
                        :value="req.date"
                        disabled
                      />
                    </v-flex>
                    <v-flex xs12 sm6>
                      <v-text-field
                        box
                        label="Hora solicitada:"
                        :value="req.startTime"
                        disabled
                      />
                    </v-flex>
                    <v-flex xs12 sm6>
                      <v-text-field
                        box
                        label="Teléfono:"
                        :value="req.phone"
                        disabled
                      />
                    </v-flex>
                    <v-flex xs12 sm6>
                      <v-text-field
                        box
                        label="Email:"
                        :value="req.email"
                        disabled
                      />
                    </v-flex>
                    <v-flex xs12 sm6>
                      <v-text-field
                        box
                        label="Descripción:"
                        :value="req.description"
                        disabled
                      />
                    </v-flex>
                  </v-layout>
                  <v-card-actions>
                    <v-spacer />
                    <v-btn flat icon color="error">
                      <delete-req-appointment :req-appointment-id="req._id" />
                    </v-btn>
                    <v-btn flat icon color="success" :to="'/admin/reqAppointments/' + req._id">
                      <v-icon>check</v-icon>
                    </v-btn>
                  </v-card-actions>
                </v-container>
              </div>
            </v-card>
          </v-flex>
        </v-layout>
      </v-layout>
    </v-container>
  </div>
</template>

<script>
import { mapGetters } from 'vuex'
import deleteReqAppointment from '../../components/admin/reqAppointments/deleteReqAppointment'
import { GET_REQAPPOINTMENTS, REQAPPOINTMENTS_NAME, REQAPPOINTMENTS_PATH } from '../../store/types'
import clock from '../../components/admin/utils/clock'
export default {
  layout: 'admin',
  middleware: 'auth',
  components: { deleteReqAppointment, clock },
  data() {
    return {
      reqAppointment: {},
      selectedIndex: null
    }
  },
  computed: {
    ...mapGetters(REQAPPOINTMENTS_NAME, ['getReqAppointments'])
  },
  mounted() {
    this.$store.dispatch(REQAPPOINTMENTS_PATH + GET_REQAPPOINTMENTS)
  },
  methods: {
    toggle(index) {
      this.selectedIndex = index
    }
  }
}
</script>
