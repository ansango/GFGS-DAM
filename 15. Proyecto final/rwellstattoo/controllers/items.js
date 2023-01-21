import request from '../utils/request'

export function getAllItems() {
  return request({
    url: '/getAllItems',
    method: 'get'
  })
}

export function getItembyId(id) {
  return request({
    url: '/getItemById/' + id,
    method: 'get'
  })
}

export function createItem(item) {
  return request({
    url: '/addItem',
    method: 'post',
    data: item
  })
}

export function updateItem(id, item) {
  return request({
    url: '/updateItemById/' + id,
    method: 'post',
    data: item
  })
}

export function deleteItem(id) {
  return request({
    url: '/deleteItemById/' + id,
    method: 'delete'
  })
}
