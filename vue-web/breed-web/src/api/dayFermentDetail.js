import request from '@/utils/request'

export function fetchList(params) {
  return request({
    url: '/ferment-detail/list',
    method: 'get',
    params: params
  })
}
export function deleteFermentDetail(id) {
  return request({
    url: '/ferment-detail/delete/' + id,
    method: 'post'
  })
}
export function createFermentDetail(data) {
  return request({
    url: '/ferment-detail/create',
    method: 'post',
    data: data
  })
}

export function updateFermentDetail(data) {
  return request({
    url: '/ferment-detail/update',
    method: 'post',
    data: data
  })
}


export function getFermentDetailInfo(id) {
  return request({
    url: '/ferment-detail/info/' + id,
    method: 'get'
  })
}
