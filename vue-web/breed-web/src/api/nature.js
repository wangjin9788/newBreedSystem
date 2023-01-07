import request from '@/utils/request'

export function fetchList(params) {
  return request({
    url: '/nature/list',
    method: 'get',
    params: params
  })
}

export function createNature(data) {
  return request({
    url: '/nature/create',
    method: 'post',
    data: data
  })
}

export function updateNature(data) {
  return request({
    url: '/nature/update',
    method: 'post',
    data: data
  })
}

export function deleteNature(id) {
  return request({
    url: '/nature/delete/' + id,
    method: 'post'
  })
}
export function getNatureInfo(id) {
  return request({
    url: '/nature/info/' + id,
    method: 'get'
  })
}

export function selectNatureList() {
  return request({
    url: '/nature/select/list',
    method: 'get',
  })
}
