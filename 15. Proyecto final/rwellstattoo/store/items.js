import { getAllItems, createItem, updateItem, deleteItem } from '../controllers/items'
import { GET_ITEMS, UPDATE_ITEM, DELETE_ITEM, SET_ITEMS, CREATE_ITEM } from './types'

export const state = () => ({
  items: []
})

export const getters = {
  getAllItems: state => state.items
}

export const actions = {
  [GET_ITEMS]({ state, commit }) {
    getAllItems()
      .then((response) => {
        commit(SET_ITEMS, response.data)
      })
      .catch((err) => {
        alert(err)
      })
  },
  [CREATE_ITEM]({ state, commit }, item) {
    createItem(item)
      .then((response) => {
        commit(SET_ITEMS, response.data.item)
      })
      .catch((err) => {
        alert(err)
      })
  },
  [UPDATE_ITEM]({ state, commit }, item) {
    updateItem(item._id, item)
      .then((response) => {
        commit(SET_ITEMS, response.data.item)
      })
      .catch((err) => {
        alert(err)
      })
  },
  [DELETE_ITEM]({ state, commit }, item) {
    deleteItem(item)
      .then((response) => {
        commit(SET_ITEMS, response.data)
      })
      .catch((err) => {
        alert(err)
      })
  }
}

export const mutations = {
  [SET_ITEMS](state, items) {
    state.items = items
  }
}
