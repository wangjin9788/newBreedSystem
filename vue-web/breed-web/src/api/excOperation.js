import request from '@/utils/request'

export function fetchList(params) {
  return request({
    url: '/exc-operation/list',
    method: 'get',
    params: params
  })
}

export function createExcOperation(data) {
  return request({
    url: '/exc-operation/create',
    method: 'post',
    data: data
  })
}

export function updateExcOperation(data) {
  return request({
    url: '/exc-operation/update',
    method: 'post',
    data: data
  })
}

export function getExcOperationInfo(id) {
  return request({
    url: '/exc-operation/info/' + id,
    method: 'get'
  })
}
export function getSummaryOperationInfo(id) {
  return request({
    url: '/exc-operation/summary/operation/' + id,
    method: 'get'
  })
}

export function deleteExcOperation(id) {
  return request({
    url: '/exc-operation/delete/' + id,
    method: 'post'
  })
}


