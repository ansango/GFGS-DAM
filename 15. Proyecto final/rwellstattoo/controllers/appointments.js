import request from '../utils/request'

export function getAppointments() {
  return request({
    url: '/appointment/getAppointments',
    method: 'get'
  })
}

export function getAppointmentById(id) {
  return request({
    url: '/appointment/getAppointmentById/' + id,
    method: 'get'
  })
}

export function createAppointment(appointment) {
  return request({
    url: '/appointment/addAppointment',
    method: 'post',
    data: appointment
  })
}

export function updateAppointmentById(id, appointment) {
  return request({
    url: '/appointment/updateAppointmentById/' + id,
    method: 'post',
    data: appointment
  })
}

export function deleteAppointmentById(id) {
  return request({
    url: '/appointment/deleteAppointmentById/' + id,
    method: 'delete'
  })
}
