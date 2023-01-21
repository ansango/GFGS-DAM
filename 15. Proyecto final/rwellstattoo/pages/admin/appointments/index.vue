<template>
  <v-container grid-list-md text-xs-center>
    <v-layout row>
      <v-flex >
        <v-switch v-model="switch1" />
      </v-flex>
    </v-layout>
    <v-layout v-if="switch1 === false" row wrap>
      <v-flex xs12>
        <v-card>
          <v-sheet height="600">
            <v-calendar
              ref="calendar"
              v-model="start"
              :weekdays="weekdays"
              :end="end"
              color="primary"
              locale="es-es"
            >
              <template v-slot:day="{ date }">
                <template v-for="event in formattedAppointments[date]">
                  <v-menu
                    :key="event.id"
                    full-width
                    offset-x
                  >
                    <template v-slot:activator="{ on }">
                      <div
                        v-if="!event.time"
                        class="my-event"
                        @click="edit(event.id)"
                      >
                        {{ event.title }}
                      </div>
                    </template>
                  </v-menu>
                </template>
              </template>
            </v-calendar>
          </v-sheet>
        </v-card>
      </v-flex>
      <v-layout row justify-center>
        <v-flex
          xs6
          class="text-sm-left text-xs-center"
        >
          <v-btn round @click="$refs.calendar.prev()">
            <v-icon
              dark
              left
            >
              keyboard_arrow_left
            </v-icon>
            Anterior
          </v-btn>
        </v-flex>
        <v-flex
          xs6
          class="text-sm-right text-xs-center"
        >
          <v-btn round @click="$refs.calendar.next()">
            Siguiente
            <v-icon
              right
              dark
            >
              keyboard_arrow_right
            </v-icon>
          </v-btn>
        </v-flex>
      </v-layout>
    </v-layout>
    <v-layout v-else row wrap>
      <v-flex v-for="appointment in getAppointments" :key="appointment.id" xs12>
        <v-card flat>
          <v-expansion-panel>
            <v-expansion-panel-content>
              <template v-slot:header>
                <v-list-tile-action>
                  <v-icon color="error">
                    mail
                  </v-icon>
                </v-list-tile-action>
                <v-list-tile-title>
                  <h4>{{appointment.name}} {{appointment.lastname}}</h4>
                </v-list-tile-title>
              </template>
              <v-card>
                <v-card-text>
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
                        Teléfono/Whatsapp:
                      </h6>
                    </v-flex>
                    <v-spacer />
                    <v-flex xs4 class="second-col">
                      <h6>
                        {{appointment.phone}}
                      </h6>
                    </v-flex>
                  </v-layout>
                  <v-layout row>
                    <v-flex class="first-col">
                      <h6>
                        Estilo:
                      </h6>
                    </v-flex>
                    <v-spacer />
                    <v-flex xs4 class="second-col">
                      <h6>
                        {{appointment.style}}
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
                        {{appointment.type}}
                      </h6>
                    </v-flex>
                  </v-layout>
                  <v-card-actions>
                    <v-spacer />
                    <v-btn flat icon :to="'/admin/dates/updateDate/' + appointment._id">
                      <v-icon>
                        edit
                      </v-icon>
                    </v-btn>
                    <delete-appointment :appointment-id="appointment._id"></delete-appointment>
                  </v-card-actions>
                </v-card-text>
              </v-card>
            </v-expansion-panel-content>
          </v-expansion-panel>
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
      to="/admin/appointments/createAppointment"
    >
      <v-icon>add</v-icon>
    </v-btn>
  </v-container>
</template>

<script>
/* eslint-disable */
import deleteAppointment from '../../../components/admin/appointments/deleteAppointment'
import { mapGetters } from 'vuex'
import { APPOINTMENTS_PATH, APPOINTMENTS_NAME, GET_APPOINTMENTS } from '../../../store/types'
export default {
  layout: 'admin',
  middleware: 'auth',
  components: {deleteAppointment},
  data() {
    return {
      appointments: {},
      switch1: false,
      start: new Date(new Date().getFullYear(), 0, 1).toString(),
      end: new Date(new Date().getFullYear(), 12, 31).toString(),
      weekdays: [1,2,3,4,5,6],
      type: 'month'
    }
  },
  computed: {
    ...mapGetters(APPOINTMENTS_NAME, ['getAppointments']),
    formattedAppointments() {
      const map = {}
      this.getAppointments.forEach(e => (map[e.date] = map[e.date] || []).push({
        date: e.date,
        details: e.description,
        open: false,
        title: e.name,
        id: e._id,
        startTime: e.startTime,
        endTime: e.endTime,
        price: e.price,
        deposit: e.deposit
      }))
      return map
    }
  },
  mounted() {
    this.$store.dispatch(APPOINTMENTS_PATH + GET_APPOINTMENTS)
  },
  methods: {
    edit(id) {
      this.$router.push({ path: '/admin/appointments/updateAppointment/' + id })
    }
  }
}
</script>
<style>
  .my-event {
    overflow: hidden;
    text-overflow: ellipsis;
    white-space: nowrap;
    border-radius: 2px;
    background-color: #6A1B9A;
    color: #ffffff;
    border: 1px solid #6A1B9A;
    width: 100%;
    font-size: 12px;
    padding: 3px;
    cursor: pointer;
    margin-bottom: 1px;
    font-weight: bold;
  }
  h6{
    font-size: 13px!important;
  }
  .first-col{
    margin-left: 15px;
    text-align: left;
  }
  .second-col{
    text-align: right;
    margin-right: 15px;
  }
</style>
