<template>
  <v-app class="secondary">
    <v-navigation-drawer
      v-model="drawer"
      temporary
      app
      class="secondary"
    >
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
      </v-list>
    </v-navigation-drawer>
    <v-toolbar
      class="secondary elevation-0"
      app
    >
      <v-toolbar-title class="primary--text" v-text="title" />
      <v-spacer />
      <NuxtLink  v-for="item in items" :key="item.title" :to="item.to" style="text-decoration: none">
        <v-btn
          id="routes"
          app
          flat
          round
          class="secondary primary--text hidden-sm-and-down"
        >
          {{ item.title }}
        </v-btn>
      </NuxtLink>
      <v-toolbar-side-icon class="primary--text hidden-md-and-up" @click="drawer = !drawer" />
    </v-toolbar>
    <v-content>
      <nuxt />
    </v-content>
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
          to: '/'
        },
        {
          icon: 'image',
          title: 'Galería',
          to: '/gallery'
        },
        {
          icon: 'info',
          title: 'Contacto',
          to: '/about'
        },
        {
          icon: 'account_circle',
          title: 'Admin',
          to: '/admin'
        }
      ],
      title: 'rwellstattoo'
    }
  }
}
</script>
