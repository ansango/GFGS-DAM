<template>
  <div>
    <v-container
      grid-list-xl
      style="max-width: 500px"
    >
      <v-expansion-panel
        v-for="item in getAllItems"
        :key="item.id"
      >
        <v-expansion-panel-content>
          <template v-slot:header>
            <div>
              {{ item.name }}
            </div>
          </template>
          <v-card>
            <v-card-text>
              <v-layout row>
                <v-flex class="first-col">
                  <h6>
                    Descripción:
                  </h6>
                </v-flex>
                <v-spacer />
                <v-flex xs4 class="second-col">
                  <h6>
                    {{ item.description }}
                  </h6>
                </v-flex>
              </v-layout>
              <v-layout row>
                <v-flex class="first-col">
                  <h6>
                    Unidades:
                  </h6>
                </v-flex>
                <v-spacer />
                <v-flex xs4 class="second-col">
                  <h6>
                    {{ item.units }}
                  </h6>
                </v-flex>
              </v-layout>
              <v-layout row>
                <v-flex class="first-col">
                  <h6>
                    Pecio (ud):
                  </h6>
                </v-flex>
                <v-spacer />
                <v-flex xs4 class="second-col">
                  <h6>
                    {{ item.price }}
                  </h6>
                </v-flex>
              </v-layout>
              <v-layout row>
                <v-flex class="first-col">
                  <h6>
                    Precio total:
                  </h6>
                </v-flex>
                <v-spacer />
                <v-flex xs4 class="second-col">
                  <h6>
                    {{ item.price * item.units }} €
                  </h6>
                </v-flex>
              </v-layout>
            </v-card-text>
            <v-card-actions>
              <v-spacer />
              <v-btn flat icon color="primary" :to="'/admin/stocklist/updateItem/' + item._id">
                <v-icon>edit</v-icon>
              </v-btn>
              <delete-dialog :item-id="item._id" />
            </v-card-actions>
          </v-card>
        </v-expansion-panel-content>
      </v-expansion-panel>
      <v-btn
        color="primary"
        dark
        big
        fixed
        right
        bottom
        fab
        to="/admin/stocklist/createItem"
      >
        <v-icon>add</v-icon>
      </v-btn>
    </v-container>
  </div>
</template>

<script>

import { mapGetters } from 'vuex'
import { GET_ITEMS, ITEMS_PATH, ITEMS_NAME } from '../../../store/types'
import DeleteDialog from '../../../components/admin/stocklist/deleteItems'
export default {
  components: { DeleteDialog },
  layout: 'admin',
  middleware: 'auth',
  data() {
    return {
      item: {}
    }
  },
  computed: {
    ...mapGetters(ITEMS_NAME, ['getAllItems'])
  },
  mounted() {
    this.$store.dispatch(ITEMS_PATH + GET_ITEMS)
  }
}
</script>
<style>
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
