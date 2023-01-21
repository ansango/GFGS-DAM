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
                <h3>Editar artículo</h3>
              </v-card-title>
              <v-card-text>
                <v-text-field
                  v-model="item.name"
                  box
                  label="Nombre del artículo:"
                  :rules="namerules"
                  required
                />
                <v-text-field
                  v-model="item.description"
                  box
                  label="Descripción:"
                />
                <v-text-field
                  v-model="item.price"
                  box
                  label="Precio:"
                  :rules="pricerules"
                  required
                />
                <v-text-field
                  v-model="item.units"
                  box
                  label="Unidades:"
                  :rules="unitrules"
                  required
                />
              </v-card-text>
              <v-divider />
              <v-card-actions style="padding-bottom: 20px; padding-top: 20px">
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
                  round
                  flat
                  color="error"
                  dark
                  to="/admin/stocklist"
                >
                  Cancelar
                </v-btn>
                <v-btn round flat dark color="primary" @click="updateItem(item)">
                  Actualizar
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
import { getItembyId } from '../../../../controllers/items'
import { ITEMS_PATH, UPDATE_ITEM } from '../../../../store/types'
export default {
  name: 'Id',
  layout: 'admin',
  middleware: 'auth',
  data() {
    return {
      valid: false,
      item: {},
      namerules: [
        v => !!v || 'El nombre es un campo obligatorio'
      ],
      pricerules: [
        v => !!v || 'El precio es un campo obligatorio',
        v => /^[1-9]\d*$/.test(v) || 'Introduce un valor correcto'
      ],
      unitrules: [
        v => !!v || 'Las unidades son un campo obligatorio',
        v => /^[1-9]\d*$/.test(v) || 'Introduce un valor correcto'
      ]
    }
  },
  mounted() {
    getItembyId(this.$route.params.id)
      .then((response) => {
        this.item = response.data
      })
  },
  methods: {
    reset() {
      this.$refs.form.reset()
    },
    updateItem(item) {
      if (this.$refs.form.validate()) {
        this.$store.dispatch(ITEMS_PATH + UPDATE_ITEM, item)
          .then((response) => {
            this.$router.push({ path: '/admin/stocklist' })
          })
      }
    }
  }
}
</script>

<style scoped>

</style>
