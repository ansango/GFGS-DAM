<template>
  <v-dialog
    v-model="deleteBtn"
    width="500"
  >
    <template v-slot:activator="{ on }">
      <v-btn
        flat
        icon
        color="error"
        v-on="on"
      >
        <v-icon>delete</v-icon>
      </v-btn>
    </template>
    <v-card class="" style="border-radius: 15px">
      <v-card-title
        class="warning"
        primary-title
      >
        <h3>Rechazar solicitud</h3>
      </v-card-title>

      <v-card-text>
        Está acción rechazará el registro correspondiente ¿Seguro?
      </v-card-text>

      <v-divider />

      <v-card-actions>
        <v-spacer />
        <v-btn
          round
          color="error"
          flat
          @click="deleteBtn = false"
        >
          Cancelar
        </v-btn>
        <v-btn
          round
          color="primary"
          flat
          @click="deleteReq()"
        >
          Aceptar
        </v-btn>
      </v-card-actions>
    </v-card>
  </v-dialog>
</template>

<script>
import { REQAPPOINTMENTS_PATH, DELETE_REQAPPOINTMENT } from '../../../store/types'
export default {
  name: 'DeleteAppointment',
  props: {
    reqAppointmentId: { type: String, default: '' }
  },
  data() {
    return {
      reqAppointment: {},
      deleteBtn: false
    }
  },
  methods: {
    deleteReq() {
      this.$store.dispatch(REQAPPOINTMENTS_PATH + DELETE_REQAPPOINTMENT, this.reqAppointmentId)
      this.deleteBtn = false
    }
  }
}
</script>
