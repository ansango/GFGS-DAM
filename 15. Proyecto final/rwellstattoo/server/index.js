const express = require('express')
const session = require('express-session')
const passport = require('passport')
const expressValidator = require('express-validator')
const consola = require('consola')
const morgan = require('morgan')
const mongoose = require('mongoose')
const chalk = require('chalk')
const { Nuxt, Builder } = require('nuxt')
require('dotenv').config()

const app = express()

// Import and Set Nuxt.js options
const config = require('../nuxt.config.js')
config.dev = !(process.env.NODE_ENV === 'production')

/**
 * MongoDB config and connection
 */
const mongodbOptions = {
  useNewUrlParser: true,
  useFindAndModify: false,
  useCreateIndex: true
}

mongoose.connect(process.env.DB_URL, mongodbOptions, (err) => {
  if (err) {
    console.error(err)
    console.log('%s MongoDB connection error. Please make sure MongoDB is running.', chalk.red('✗'))
    process.exit()
  } else {
    console.log('Database connection stablished')
  }
})

/**
 * API keys and Passport configuration.
 */
const passportConfig = require('./config/passport')

async function start() {
  // Init Nuxt.js
  const nuxt = new Nuxt(config)

  const {
    host = process.env.HOST || '127.0.0.1',
    port = process.env.PORT || 3000
  } = nuxt.options.server

  // Build only in dev mode
  if (config.dev) {
    const builder = new Builder(nuxt)
    await builder.build()
  }

  // express setup
  app.use(expressValidator())
  app.use(morgan('dev'))
  app.use(session({
    secret: process.env.SESSION_SECRET,
    cookie: { maxAge: 1800000 },
    resave: false,
    saveUninitialized: false
  }))
  app.use(passport.initialize())
  app.use(passport.session())
  require('./config/passport')
  app.use((req, res, next) => {
    res.locals.user = req.user
    next()
  })
  app.use((req, res, next) => {
    if (!req.user &&
      req.path !== '/login' &&
      req.path !== '/signup' &&
      !req.path.match(/^\/auth/) &&
      !req.path.match(/\./)) {
      req.session.returnTo = req.originalUrl
    } else if (req.user &&
      (req.path === '/account' || req.path.match(/^\/api/))) {
      req.session.returnTo = req.originalUrl
    }
    next()
  })

  // Give nuxt middleware to express
  app.use(nuxt.render)

  // Listen the server
  app.listen(port, host)
  consola.ready({
    message: `Server listening on http://${host}:${port}`,
    badge: true
  })
}

start()
