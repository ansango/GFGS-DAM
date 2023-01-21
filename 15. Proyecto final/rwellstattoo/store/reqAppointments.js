import { getReqAppointments, createReqAppointment, deleteReqAppointmentById } from '../controllers/reqAppointments'
import { CREATE_REQAPPOINTMENT, DELETE_REQAPPOINTMENT, GET_REQAPPOINTMENTS, SET_REQAPPOINTMENTS } from './types'

// State

export const state = () => ({
  reqAppointments: []
})

// Getters

export const getters = {
  getReqAppointments: state => state.reqAppointments
}

// Actions

export const actions = {
  [GET_REQAPPOINTMENTS]({ state, commit }) {
    getReqAppointments()
      .then((response) => {
        commit(SET_REQAPPOINTMENTS, response.data)
      })
      .catch((err) => {
        alert(err)
      })
  },

  [CREATE_REQAPPOINTMENT]({ state, commit }, reqAppointment) {
    createReqAppointment(reqAppointment)
      .then((response) => {
        commit(SET_REQAPPOINTMENTS, response.data.reqAppointments)
      })
      .catch((err) => {
        alert(err)
      })
  },

  [DELETE_REQAPPOINTMENT]({ state, commit }, reqAppointmentId) {
    deleteReqAppointmentById(reqAppointmentId)
      .then((response) => {
        /*eslint-disable*/
        console.log(response.data)
        commit(SET_REQAPPOINTMENTS, response.data)
      })
      .catch((err) => {
        alert(err)
      })
  }

}

// Mutations

export const mutations = {
  [SET_REQAPPOINTMENTS](state, reqAppointments) {
    state.reqAppointments = reqAppointments
  }
}
