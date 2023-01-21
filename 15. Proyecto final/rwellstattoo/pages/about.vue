<template>
  <v-container grid-list-xl>
    <v-layout row wrap justify-center class="my-5" style="margin-top: -80px!important;">
      <v-flex xs10 sm6 md6 lg3>
        <img src="../assets/he.svg"></img>
      </v-flex>
    </v-layout>
    <v-layout row wrap justify-center class="my-5" style="margin-top: -120px!important;">
      <v-flex xs12 sm8 md6 lg4>
        <v-form
          ref="form"
          v-model="valid"
        >
          <v-card class="elevation-0" style="background-color: #FFF8E1">
            <v-card-title
              primary-title
            >
              <h3>Solicita una cita</h3>
            </v-card-title>
            <v-card-text>
              <v-layout row wrap justify-center>
                <v-flex xs12 sm12>
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
                        v-model="reqAppointment.date"
                        required
                        outline
                        label="Fecha:"
                        prepend-inner-icon="event"
                        readonly
                        v-on="on"
                      />
                    </template>
                    <v-date-picker
                      v-model="reqAppointment.date"
                      :first-day-of-week="1"
                      :allowed-dates="allowedDates"
                      locale="es-es"
                      @input="menuDate = false"
                    />
                  </v-menu>
                </v-flex>
                <v-flex xs12 sm12>
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
                        v-model="reqAppointment.startTime"
                        outline
                        label="Hora:"
                        prepend-inner-icon="access_time"
                        readonly
                        required
                        v-on="on"
                      />
                    </template>
                    <v-time-picker
                      v-if="startTime"
                      v-model="reqAppointment.startTime"
                      full-width
                      format="24hr"
                      min="11:00"
                      max="19:05"
                      :allowed-hours="allowedHours"
                      @click:minute="$refs.menu.save(reqAppointment.startTime)"
                    />
                  </v-menu>
                </v-flex>
              </v-layout>
              <v-layout row wrap justify-end>
                <v-btn icon flat color="primary" @click="show = !show">
                  <v-icon>{{ show ? 'keyboard_arrow_up' : 'keyboard_arrow_down' }}</v-icon>
                </v-btn>
              </v-layout>
              <v-slide-y-transition>
                <div v-show="show">
                  <v-layout row wrap justify-center>
                    <v-flex xs12>
                      <v-text-field
                        v-model="reqAppointment.name"
                        outline
                        label="Nombre:"
                        :rules="namerules"
                        required
                      />
                    </v-flex>
                    <v-flex xs12>
                      <v-text-field
                        v-model="reqAppointment.lastname"
                        outline
                        label="Apellidos:"
                        :rules="lastnamerules"
                        required
                      />
                    </v-flex>
                    <v-flex xs12>
                      <v-text-field
                        v-model="reqAppointment.phone"
                        outline
                        label="Teléfono/Whatsapp:"
                        :rules="phonerules"
                        required
                      />
                    </v-flex>
                    <v-flex xs12>
                      <v-text-field
                        v-model="reqAppointment.email"
                        outline
                        label="Email:"
                        :rules="emailrules"
                        required
                      />
                    </v-flex>
                    <v-flex xs12>
                      <v-textarea
                        v-model="reqAppointment.description"
                        outline
                        color="primary"
                        label="Descripción del tatuaje:"
                        hint="Estilo, ¿a color?, tamaño aprox, zona..."
                        :rules="descriptionrules"
                        required
                      />
                    </v-flex>
                  </v-layout>
                  <v-card-actions>
                    <v-spacer />
                    <v-dialog
                      v-model="dialogBtn"
                      width="500"
                    >
                      <template v-slot:activator="{ on }">
                        <v-btn
                          round
                          color="primary"
                          flat
                          v-on="on"
                        >
                          Enviar
                        </v-btn>
                      </template>
                      <v-card style="border-radius: 15px">
                        <v-card-title
                          class="primary white--text"
                          primary-title
                        >
                          <h3>!</h3>
                        </v-card-title>

                        <v-card-text>
                          Estás a punto de solicitar una cita. Los plazos disponibles y los horarios son orientativos y pueden estar sujetos a modificaciones. Nos pondremos en contacto contmigo en la mayor brevedad para confirmar el evento. ¡Muchas gracias por tu confianza!
                        </v-card-text>

                        <v-divider />

                        <v-card-actions>
                          <v-spacer />
                          <v-btn
                            round
                            color="error"
                            flat
                            @click="dialogBtn = false"
                          >
                            Cancelar
                          </v-btn>
                          <v-btn
                            round
                            color="primary"
                            flat
                            @click="addRequest()"
                          >
                            Aceptar
                          </v-btn>
                        </v-card-actions>
                      </v-card>
                    </v-dialog>
                  </v-card-actions>
                </div>
              </v-slide-y-transition>
            </v-card-text>
          </v-card>
        </v-form>
      </v-flex>
    </v-layout>
  </v-container>
</template>

<script>
import { CREATE_REQAPPOINTMENT, REQAPPOINTMENTS_PATH } from '../store/types'
export default {
  layout: 'landing',
  data() {
    return {
      reqAppointment: {},
      menuDate: false,
      startTime: false,
      valid: false,
      dialogBtn: false,
      show: false,
      namerules: [
        v => !!v || 'El nombre es obligatorio'
      ],
      lastnamerules: [
        v => !!v || 'El apellido es obligatorio'
      ],
      phonerules: [
        v => !!v || 'El teléfono es obligatorio'
      ],
      emailrules: [
        v => !!v || 'El email es obligatorio'
      ],
      descriptionrules: [
        v => !!v || 'La descripción es obligatoria'
      ]
    }
  },
  methods: {
    allowedDates: val => ![0, 7].includes(new Date(val).getDay()),
    addRequest() {
      if (this.$refs.form.validate()) {
        this.$store.dispatch(REQAPPOINTMENTS_PATH + CREATE_REQAPPOINTMENT, this.reqAppointment)
          .then((response) => {
            this.$router.push({ path: '/' })
          })
        this.dialogBtn = false
      }
      this.dialogBtn = false
    }
  }
}
</script>
