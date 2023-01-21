// const jsonwebtoken = require('jsonwebtoken')
const passport = require('passport')
const responses = require('../utils/responses')
const User = require('../models/user')

exports.login = function (req, res, next) {
  req.assert('email', 'Email is not valid').isEmail()
  req.assert('password', 'Password cannot be blank').notEmpty()
  req.sanitize('email').normalizeEmail({ gmail_remove_dots: false })

  const errors = req.validationErrors()
  if (errors) {
    return responses.errorMessages(res, errors)
  }

  passport.authenticate('local', (err, user, info) => {
    if (err) { return responses.error(res, err) }
    if (!user) {
      return responses.error(res, info)
    }
    req.logIn(user, (err) => {
      if (err) { return responses.error(res, err) }
      responses.success(res, { msg: 'Success! You are logged in.' })
    })
  })(req, res, next)
}

exports.logout = function (req, res) {
  responses.success(res, { status: 'OK' })
}

exports.register = function (req, res) {
  const user = new User(req.body)
  user.save()
    .then((userInfo) => {
      responses.success(res, userInfo)
    })
    .catch((err) => {
      responses.error(res, { msg: err })
    })
}
