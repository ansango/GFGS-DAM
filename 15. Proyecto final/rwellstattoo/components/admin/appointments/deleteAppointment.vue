<template>
  <v-dialog
    v-model="deleteBtn"
    width="500"
  >
    <template v-slot:activator="{ on }">
      <v-btn
        flat
        icon
        v-on="on"
      >
        <v-icon>close</v-icon>
      </v-btn>
    </template>

    <v-card style="border-radius: 15px">
      <v-card>
        <v-card-title
          class="warning"
          primary-title
        >
          <h3>Eliminar evento</h3>
        </v-card-title>

        <v-card-text>
          Está acción eliminará el registro correspondiente ¿Seguro?
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
            @click="deleteAppointment()"
          >
            Aceptar
          </v-btn>
        </v-card-actions>
      </v-card>
    </v-card>
  </v-dialog>
</template>

<script>
import { DELETE_APPOINTMENT, APPOINTMENTS_PATH } from '../../../store/types'

export default {
  name: 'deleteAppointment',
  props: {
    appointmentId: { type: String, default: '' }
  },
  data() {
    return {
      appointment: {},
      deleteBtn: false
    }
  },
  methods: {
    deleteAppointment() {
      this.$store.dispatch(APPOINTMENTS_PATH + DELETE_APPOINTMENT, this.appointmentId)
      this.deleteBtn = false
    }
  }
}
</script>
