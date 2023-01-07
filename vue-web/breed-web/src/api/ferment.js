import request from '@/utils/request'

export function fetchList(params) {
  return request({
    url: '/feed-ferment/list',
    method: 'get',
    params: params
  })
}

export function createFerment(data) {
  return request({
    url: '/feed-ferment/create',
    method: 'post',
    data: data
  })
}
export function updateFermentStatus(data) {
  return request({
    url: '/feed-ferment/update/status',
    method: 'post',
    data: data
  })
}

export function updateFerment(data) {
  return request({
    url: '/feed-ferment/update',
    method: 'post',
    data: data
  })
}

export function getFermentInfo(id) {
  return request({
    url: '/feed-ferment/info/' + id,
    method: 'get'
  })
}

export function deleteFerment(id) {
  return request({
    url: '/feed-ferment/delete/' + id,
    method: 'post'
  })
}

export function selectFermentList() {
  return request({
    url: '/feed-ferment/select/list',
    method: 'get',
  })
}
