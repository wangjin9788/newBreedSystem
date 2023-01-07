import request from '@/utils/request'

export function fetchList(params) {
  return request({
    url: '/exc-label/list',
    method: 'get',
    params: params
  })
}

export function createExcLabel(data) {
  return request({
    url: '/exc-label/create',
    method: 'post',
    data: data
  })
}

export function updateExcLabel(data) {
  return request({
    url: '/exc-label/update',
    method: 'post',
    data: data
  })
}

export function getExcLabelInfo(id) {
  return request({
    url: '/exc-label/info/' + id,
    method: 'get'
  })
}

export function deleteExcLabel(id) {
  return request({
    url: '/exc-label/delete/' + id,
    method: 'post'
  })
}
export function selectExcLabelList() {
  return request({
    url: '/exc-label/select/list',
    method: 'get',
  })
}
