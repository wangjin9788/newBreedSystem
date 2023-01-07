import request from '@/utils/request'

export function fetchList(params) {
  return request({
    url: '/testing/list',
    method: 'get',
    params: params
  })
}

export function createTesting(data) {
  return request({
    url: '/testing/create',
    method: 'post',
    data: data
  })
}

export function updateTesting(data) {
  return request({
    url: '/testing/update',
    method: 'post',
    data: data
  })
}

export function getTestingInfo(id) {
  return request({
    url: '/testing/info/' + id,
    method: 'get'
  })
}

export function deleteTesting(id) {
  return request({
    url: '/testing/delete/' + id,
    method: 'post'
  })
}
