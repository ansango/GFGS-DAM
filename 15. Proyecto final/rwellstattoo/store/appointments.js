import { getAppointments, createAppointment, updateAppointmentById, deleteAppointmentById } from '../controllers/appointments'
import { CREATE_APPOINTMENT, GET_APPOINTMENTS, SET_APPOINTMENTS, UPDATE_APPOINTMENT, DELETE_APPOINTMENT } from './types'

// STATE

export const state = () => ({
  appointments: []
})

// Getters

export const getters = {
  getAppointments: state => state.appointments
}

// Actions

export const actions = {
  // ejemplo promise
  [GET_APPOINTMENTS]({ state, commit }) {
    return new Promise((resolve, reject) => {
      getAppointments()
        .then((response) => {
          commit(SET_APPOINTMENTS, response.data)
          resolve()
        })
        .catch((err) => {
          reject(err)
        })
    })
  },

  // ejemplo async
  [CREATE_APPOINTMENT]({ state, commit }, appointment) {
    return new Promise(async (resolve, reject) => {
      try {
        const response = await createAppointment(appointment)
        commit(SET_APPOINTMENTS, response.data.appointments)
        resolve()
      } catch (err) {
        reject(err)
      }
    })
  },

  [UPDATE_APPOINTMENT]({ state, commit }, appointment) {
    updateAppointmentById(appointment._id, appointment)
      .then((response) => {
        commit(SET_APPOINTMENTS, response.data)
      })
      .catch((err) => {
        alert(err)
      })
  },

  [DELETE_APPOINTMENT]({ state, commit }, appointmentId) {
    deleteAppointmentById(appointmentId)
      .then((response) => {
        commit(SET_APPOINTMENTS, response.data)
      })
      .catch((err) => {
        alert(err)
      })
  }
}

// Mutations

export const mutations = {
  [SET_APPOINTMENTS](state, appointments) {
    state.appointments = appointments
  }
}
