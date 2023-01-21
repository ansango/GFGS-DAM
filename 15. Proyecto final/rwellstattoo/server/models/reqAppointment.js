const mongoose = require('mongoose')

const ReqAppointmentSchema = new mongoose.Schema({
  date: String,
  startTime: String,
  name: { type: String, default: 'Anonymous' },
  lastname: { type: String, default: 'Anonymous' },
  phone: String,
  email: String,
  description: String
}, { timestamps: true })

module.exports = mongoose.model('ReqAppointment', ReqAppointmentSchema)
