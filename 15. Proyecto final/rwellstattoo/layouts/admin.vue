<template>
  <v-app>
    <v-navigation-drawer
      v-model="drawer"
      absolute
      app
    >
      <v-toolbar flat>
        <v-list>
          <v-list-tile>
            <v-list-tile-title class="title">
              rwellstattoo
            </v-list-tile-title>
          </v-list-tile>
        </v-list>
      </v-toolbar>
      <v-divider />
      <v-list>
        <v-list-tile
          v-for="(item, i) in items"
          :key="i"
          :to="item.to"
          router
          exact
        >
          <v-list-tile-action>
            <v-icon>{{ item.icon }}</v-icon>
          </v-list-tile-action>
          <v-list-tile-content>
            <v-list-tile-title v-text="item.title" />
          </v-list-tile-content>
        </v-list-tile>

        <v-list-tile
          router
          exact
          @click="logout"
        >
          <v-list-tile-action>
            <v-icon>exit_to_app</v-icon>
          </v-list-tile-action>
          <v-list-tile-content>
            <v-list-tile-title v-text="'Logout'" />
          </v-list-tile-content>
        </v-list-tile>
      </v-list>
    </v-navigation-drawer>
    <v-toolbar
      class="elevation-0"
      app
    >
      <v-toolbar-side-icon @click="drawer = !drawer" />
      <v-spacer />
      <v-btn icon to="/">
        <v-icon>home</v-icon>
      </v-btn>
    </v-toolbar>
    <v-content>
      <nuxt />
    </v-content>
    <v-footer
      app
    />
  </v-app>
</template>

<script>
export default {
  data() {
    return {
      drawer: false,
      items: [
        {
          icon: 'home',
          title: 'Home',
          to: '/admin/'
        },
        {
          icon: 'calendar_today',
          title: 'Calendario',
          to: '/admin/appointments'
        },
        {
          icon: 'timer',
          title: 'Citas',
          to: '/admin/dates'
        },
        {
          icon: 'list_alt',
          title: 'Inventario',
          to: '/admin/stocklist'
        }
      ],
      right: null
    }
  },
  methods: {
    logout() {
      this.$auth.logout()
        .then(() => {
          this.$router.push({ path: '/admin/login' })
        })
    }
  }
}
</script>

<style>
</style>
