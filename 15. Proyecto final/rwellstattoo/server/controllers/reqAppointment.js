const ReqAppointment = require('../models/reqAppointment')
const responses = require('../utils/responses')

exports.testing = function (req, res) {
  res.send('Request Appointment TEST working...')
}

// Create a Request Appointment

exports.addRequest = function (req, res) {
  const reqAppointment = new ReqAppointment(req.body)
  reqAppointment.save((err) => {
    if (err) {
      return responses.error(res, {msg: err})
    }
    ReqAppointment.find({})
      .then((reqAppointments) => {
        return responses.success(res, { msg: 'request appointment created', reqAppointments })
      })
      .catch((err) => {
        return responses.error(res, { msg: err })
      })
  })
}

// Get all Requests Appointment

exports.getAllRequests = function (req, res) {
  ReqAppointment.find({})
    .then((reqAppointment) => {
      return responses.success(res, reqAppointment)
    })
    .catch((err) => {
      return responses.error(res, { msg: err })
    })
}

// Get Request By Id

exports.getRequestById = function (req, res) {
  ReqAppointment.findById(req.params.id)
    .then((reqAppointment) => {
      return responses.success(res, reqAppointment)
    })
    .catch((err) => {
      return responses.error(res, { msg: err })
    })
}

// Delete a Request Appointment By Id

exports.deleteRequestById = function (req, res) {
  ReqAppointment.findByIdAndRemove(req.params.id)
    .then(() => {
      ReqAppointment.find({})
        .then((reqAppointment) => {
          return responses.success(res, reqAppointment)
        })
        .catch((err) => {
          return responses.error(res, { msg: err })
        })
    })
    .catch((err) => {
      return responses.error(res, { msg: err })
    })
}
