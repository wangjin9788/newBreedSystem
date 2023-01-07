import request from '@/utils/request'

export function fetchList(params) {
  return request({
    url: '/nutritional-rate/list',
    method: 'get',
    params: params
  })
}
export function createRate(data) {
  return request({
    url: '/nutritional-rate/create',
    method: 'post',
    data: data
  })
}
