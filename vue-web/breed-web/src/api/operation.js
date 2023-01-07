import request from '@/utils/request'

export function fetchList(params) {
  return request({
    url: '/operation/list',
    method: 'get',
    params: params
  })
}

export function createOperation(data) {
  return request({
    url: '/operation/create',
    method: 'post',
    data: data
  })
}

export function updateOperation(data) {
  return request({
    url: '/operation/update',
    method: 'post',
    data: data
  })
}

export function getOperationInfo(id) {
  return request({
    url: '/operation/info/' + id,
    method: 'get'
  })
}

export function deleteOperation(id) {
  return request({
    url: '/operation/delete/' + id,
    method: 'post'
  })
}

export function selectOperation() {
  return request({
    url: '/operation/select/list',
    method: 'get',
  })
}
