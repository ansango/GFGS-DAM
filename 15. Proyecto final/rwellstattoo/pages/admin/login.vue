<template>
  <div>
    <v-container grid-list-xl>
      <v-layout row wrap justify-center class="my-5">
        <v-flex xs12 sm7 md6 lg5 xl3>
          <v-form v-model="valid">
            <v-card class="elevation-0" style="background-color: #FFF8E1">
              <v-card-title
                primary-title
              >
                <h3>Login</h3>
              </v-card-title>
              <v-card-text>
                <v-container class="layout justify-center">
                  <img src="../../assets/cerebro.svg" height="150">
                </v-container>
                <v-layout row wrap justify-center>
                  <v-flex xs12>
                    <v-text-field
                      v-model="email"
                      outline
                      :rules="emailRules"
                      label="E-mail:"
                      required
                      :error-messages="errorsMsg.email"
                    />
                  </v-flex>
                  <v-flex xs12>
                    <v-text-field
                      v-model="password"
                      outline
                      :rules="passwordRules"
                      label="Password:"
                      type="password"
                      required
                      :error-messages="errorsMsg.password"
                      @keyup.enter="login"
                    />
                  </v-flex>
                </v-layout>
              </v-card-text>
              <v-card-actions>
                <v-container>
                  <v-layout row justify-end>
                    <v-btn round flat color="primary" @click="login">
                      Login
                    </v-btn>
                  </v-layout>
                </v-container>
              </v-card-actions>
            </v-card>
          </v-form>
        </v-flex>
      </v-layout>
    </v-container>

    <v-snackbar
      v-model="snackbar"
      :bottom="true"
      :timeout="4000"
    >
      {{ snackbarMsg }}
      <v-btn
        color="pink"
        flat
        @click="snackbar = false"
      >
        Close
      </v-btn>
    </v-snackbar>
  </div>
</template>

<script>
export default {
  layout: 'landing',
  name: 'Login',
  data: () => ({
    valid: false,
    password: '',
    passwordRules: [
      v => !!v || 'El password es obligatorio'
    ],
    email: '',
    emailRules: [
      v => !!v || 'El e-mail es obligatorio',
      v => /.+@.+/.test(v) || 'El e-mail tiene que ser válido'
    ],
    errorsMsg: {},
    snackbar: false,
    snackbarMsg: ''
  }),
  watch: {
    email() {
      this.errorsMsg.email = ''
    },
    password() {
      this.errorsMsg.password = ''
    }
  },
  methods: {
    login() {
      this.$auth.loginWith('local', {
        data: {
          email: this.email,
          password: this.password
        }
      })
        .then(() => {
          this.$router.push({ path: '/admin' })
        })
        .catch((err) => {
          this.errorsMsg = err.response.data
          if (err.response.data.msg) {
            this.snackbarMsg = err.response.data.msg
            this.snackbar = true
          }
        })
    }
  }
}
</script>
