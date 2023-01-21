<template>
  <div>
    <v-container grid-list-xl>
      <v-layout row wrap justify-center class="my-5">
        <v-flex xs12 sm8>
          <v-form
            ref="form"
            v-model="valid"
          >
            <v-card style="border-radius: 15px">
              <v-card-title
                class="primary white--text"
                primary-title
              >
                <h3>Crear evento</h3>
              </v-card-title>
              <v-card-text>
                <v-layout row wrap justify-center>
                  <v-flex xs12 sm12 md4>
                    <v-menu
                      v-model="menuDate"
                      :close-on-content-click="false"
                      :nudge-right="40"
                      lazy
                      transition="scale-transition"
                      offset-y
                      full-width
                      min-width="290px"
                    >
                      <template v-slot:activator="{ on }">
                        <v-text-field
                          v-model="appointment.date"
                          box
                          label="Fecha:"
                          prepend-inner-icon="event"
                          readonly
                          v-on="on"
                        />
                      </template>
                      <v-date-picker
                        v-model="appointment.date"
                        :first-day-of-week="1"
                        locale="es-es"
                        @input="menuDate = false"
                      />
                    </v-menu>
                  </v-flex>
                  <v-flex xs12 sm12 md4>
                    <v-menu
                      ref="menu"
                      v-model="startTime"
                      :close-on-content-click="false"
                      :nudge-right="40"
                      :return-value.sync="startTime"
                      lazy
                      transition="scale-transition"
                      offset-y
                      full-width
                      max-width="290px"
                      min-width="290px"
                    >
                      <template v-slot:activator="{ on }">
                        <v-text-field
                          v-model="appointment.startTime"
                          box
                          label="Inicio:"
                          prepend-inner-icon="access_time"
                          readonly
                          v-on="on"
                        />
                      </template>
                      <v-time-picker
                        v-if="startTime"
                        v-model="appointment.startTime"
                        full-width
                        format="24hr"
                        @click:minute="$refs.menu.save(appointment.startTime)"
                      />
                    </v-menu>
                  </v-flex>
                  <v-flex xs12 sm12 md4>
                    <v-menu
                      ref="menu"
                      v-model="endTime"
                      :close-on-content-click="false"
                      :nudge-right="40"
                      :return-value.sync="endTime"
                      lazy
                      transition="scale-transition"
                      offset-y
                      full-width
                      max-width="290px"
                      min-width="290px"
                    >
                      <template v-slot:activator="{ on }">
                        <v-text-field
                          v-model="appointment.endTime"
                          box
                          label="Fin:"
                          prepend-inner-icon="access_time"
                          readonly
                          v-on="on"
                        />
                      </template>
                      <v-time-picker
                        v-if="endTime"
                        v-model="appointment.endTime"
                        format="24hr"
                        full-width
                        @click:minute="$refs.menu.save(appointment.endTime)"
                      />
                    </v-menu>
                  </v-flex>
                </v-layout>
                <v-layout row wrap>
                  <v-flex xs12>
                    <v-text-field
                      v-model="appointment.name"
                      box
                      label="Nombre:"
                      :rules="namerules"
                      required
                    />
                  </v-flex>
                  <v-flex xs12>
                    <v-text-field
                      v-model="appointment.lastname"
                      box
                      label="Apellidos:"
                      :rules="lastnamerules"
                      required
                    />
                  </v-flex>
                  <v-flex xs12>
                    <v-text-field
                      v-model="appointment.phone"
                      box
                      label="Teléfono/Whatsapp:"
                      :rules="phonerules"
                      required
                    />
                  </v-flex>
                  <v-flex xs12>
                    <v-text-field
                      v-model="appointment.email"
                      box
                      label="Email:"
                      :rules="emailrules"
                      required
                    />
                  </v-flex>
                  <v-flex xs12 sm12 md6>
                    <v-text-field
                      v-model="appointment.price"
                      box
                      label="Precio:"
                      :rules="pricerules"
                      required
                    />
                  </v-flex>
                  <v-flex xs12 sm12 md6>
                    <v-text-field
                      v-model="appointment.deposit"
                      box
                      label="Fianza:"
                      :rules="depositrules"
                      required
                    />
                  </v-flex>
                  <v-flex xs12>
                    <v-textarea
                      v-model="appointment.description"
                      box
                      color="primary"
                      label="Descripción del tatuaje:"
                      :rules="descriptionrules"
                      required
                    />
                  </v-flex>
                  <v-flex xs12>
                    <v-select
                      v-model="appointment.style"
                      :items="styles"
                      box
                      label="Estilo:"
                    />
                  </v-flex>
                  <v-flex xs12>
                    <v-select
                      v-model="appointment.type"
                      :items="types"
                      box
                      label="Tipo:"
                    />
                  </v-flex>
                </v-layout>
              </v-card-text>
              <v-divider />
              <v-card-actions style="padding-top: 20px; padding-bottom: 20px;">
                <v-btn
                  round
                  flat
                  color="warning"
                  @click="reset"
                >
                  Limpiar
                </v-btn>
                <v-spacer />
                <v-btn
                  color="error"
                  flat
                  round
                  @click="cancel"
                >
                  Cancelar
                </v-btn>
                <v-btn
                  color="primary"
                  round
                  flat
                  @click="addAppointment()"
                >
                  Aceptar
                </v-btn>
              </v-card-actions>
            </v-card>
          </v-form>
        </v-flex>
      </v-layout>
    </v-container>
  </div>
</template>

<script>
/* eslint-disable */
import { CREATE_APPOINTMENT, APPOINTMENTS_PATH } from '../../../store/types'
export default {
  layout: 'admin',
  name: 'CreateAppointment',
  data() {
    return {
      appointment: {},
      menuDate: false,
      startTime: false,
      endTime: false,
      styles: ['Tradicional', 'Black work', 'Asiático', 'Walking'],
      types: ['Linea', 'Negro', 'Color'],
      valid: false,
      namerules: [
        v => !!v || 'El nombre es obligatorio'
      ],
      lastnamerules: [
        v => !!v || 'El apellido es obligatorio'
      ],
      phonerules: [
        v => !!v || 'El telefono es obligatorio'
      ],
      emailrules: [
        v => !!v || 'El mail es obligatorio'
      ],
      descriptionrules: [
        v => !!v || 'La descripción es obligatoria'
      ],
      pricerules: [
        v => !!v || 'El precio es obligatorio',
        v => /^[1-9]\d*$/.test(v) || 'Introduce un valor correcto'
      ],
      depositrules: [
        v => !!v || 'La fianza es obligatoria',
        v => /^[1-9]\d*$/.test(v) || 'Introduce un valor correcto'
      ]
    }
  },
  methods: {
    reset() {
      this.$refs.form.reset()
    },
    addAppointment() {
      if (this.$refs.form.validate()) {
        this.$store.dispatch(APPOINTMENTS_PATH + CREATE_APPOINTMENT, this.appointment)
          .then((response) => {
            this.$router.push({path: '/admin/appointments'})
          })
      }
    },
    cancel() {
      this.$router.push({ path: '/admin/appointments' })
    }
  }
}
</script>
