const Appointment = require('../models/appointment')
const responses = require('../utils/responses')

exports.testing = function (req, res) {
  res.send('Appointment TEST working...')
}

// Create an Appointment

exports.addAppointment = function (req, res) {
  const appointment = new Appointment(req.body)
  appointment.save((err) => {
    if (err) {
      return responses.error(res, { msg: err })
    }
    Appointment.find({})
      .then((appointments) => {
        return responses.success(res, { msg: 'appointment created', appointments })
      })
      .catch((err) => {
        return responses.error(res, { msg: err })
      })
  })
}

// Get all Appointments

exports.getAllAppointments = function (req, res) {
  Appointment.find({})
    .then((appointment) => {
      return responses.success(res, appointment)
    })
    .catch((err) => {
      return responses.error(res, { msg: err })
    })
}

// Get Appointment by ID

exports.getAppointmentById = function (req, res) {
  Appointment.findById(req.params.id)
    .then((appointment) => {
      return responses.success(res, appointment)
    })
    .catch((err) => {
      return responses.error(res, { msg: err })
    })
}

// Update Appointment by ID

exports.updateAppointmentById = function (req, res) {
  Appointment.findByIdAndUpdate(req.params.id, { $set: req.body })
    .then((appointment) => {
      Appointment.find({})
        .then((appointments) => {
          return responses.success(res, appointments)
        })
    })
    .catch((err) => {
      return responses.error(res, { msg: err })
    })
}

// Delete Appointment by ID

exports.deleteAppointmentById = function (req, res) {
  Appointment.findByIdAndRemove(req.params.id)
    .then(() => {
      Appointment.find({})
        .then((appointment) => {
          return responses.success(res, appointment)
        })
        .catch((err) => {
          return responses.error(res, { msg: err })
        })
    })
    .catch((err) => {
      return responses.error(res, { msg: err })
    })
}

// Delete All Appointments

exports.deleteAllAppoinments = function (req, res) {
  Appointment.deleteMany({})
    .then((appointment) => {
      return responses.success(res, appointment)
    })
    .catch((err) => {
      return responses.error(res, { msg: err })
    })
}
