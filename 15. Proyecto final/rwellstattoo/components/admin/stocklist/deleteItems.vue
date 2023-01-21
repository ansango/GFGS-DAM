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
        <v-icon>close</v-icon>
      </v-btn>
    </template>
    <v-card style="border-radius: 15px">
      <v-card-title
        class="warning"
        primary-title
      >
        <h3>Eliminar artículo</h3>
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
          @click="deleteItem()"
        >
          Aceptar
        </v-btn>
      </v-card-actions>
    </v-card>
  </v-dialog>
</template>

<script>
import { DELETE_ITEM, ITEMS_PATH } from '../../../store/types'

export default {
  name: 'DeleteDialog',
  props: {
    itemId: { type: String, default: '' }
  },
  data() {
    return {
      item: {},
      deleteBtn: false
    }
  },
  methods: {
    deleteItem() {
      this.$store.dispatch(ITEMS_PATH + DELETE_ITEM, this.itemId)
      this.deleteBtn = false
    }
  }
}
</script>
