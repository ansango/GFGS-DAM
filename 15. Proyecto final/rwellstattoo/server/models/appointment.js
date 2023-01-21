const mongoose = require('mongoose')

const AppointmentSchema = new mongoose.Schema({
  startTime: String,
  endTime: String,
  date: String,
  name: { type: String, default: 'Anonymous' },
  lastname: { type: String, default: 'Anonymous' },
  phone: String,
  email: String,
  description: String,
  type: String,
  style: String,
  size: Number,
  price: Number,
  deposit: Number
}, { timestamps: true })

module.exports = mongoose.model('Appointment', AppointmentSchema)
