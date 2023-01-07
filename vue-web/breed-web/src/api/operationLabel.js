import request from '@/utils/request'

export function fetchList(params) {
  return request({
    url: '/operation-label/list',
    method: 'get',
    params: params
  })
}

export function createOperationLabel(data) {
  return request({
    url: '/operation-label/create',
    method: 'post',
    data: data
  })
}

export function updateOperationLabel(data) {
  return request({
    url: '/operation-label/update',
    method: 'post',
    data: data
  })
}

export function getOperationLabelInfo(id) {
  return request({
    url: '/operation-label/info/' + id,
    method: 'get'
  })
}

export function deleteOperationLabel(id) {
  return request({
    url: '/operation-label/delete/' + id,
    method: 'post'
  })
}
export function selectLabelList() {
  return request({
    url: '/operation-label/select/list',
    method: 'get',
  })
}
