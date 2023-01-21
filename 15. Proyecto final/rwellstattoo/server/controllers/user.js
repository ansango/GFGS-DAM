const responses = require('../utils/responses')
const User = require('../models/user')

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

exports.deleteUser = function (req, res) {
  User.findOneAndRemove(req.body)
    .then((user) => {
      return responses.success(res, user)
    })
    .catch((err) => {
      return responses.error(res, { msg: err })
    })
}

exports.getUser = function (req, res) {
  res.json({ user: req.user })
}
