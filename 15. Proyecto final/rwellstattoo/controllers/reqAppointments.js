import request from '../utils/request'

export function getReqAppointments() {
  return request({
    url: '/request/getAllRequests',
    method: 'get'
  })
}

export function getReqAppointmentById(id) {
  return request({
    url: '/request/getRequestById/' + id,
    method: 'get'
  })
}

export function createReqAppointment(reqAppointment) {
  return request({
    url: '/request/addRequest',
    method: 'post',
    data: reqAppointment
  })
}

export function deleteReqAppointmentById(id) {
  return request({
    url: '/request/deleteRequestById/' + id,
    method: 'delete'
  })
}
