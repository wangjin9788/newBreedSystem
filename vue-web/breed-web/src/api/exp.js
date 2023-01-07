import request from '@/utils/request'

export function fetchList(params) {
  return request({
    url: '/exp-revenue/list',
    method: 'get',
    params: params
  })
}

export function createRevenue(data) {
  return request({
    url: '/exp-revenue/create',
    method: 'post',
    data: data
  })
}

export function getCategory(data) {
  return request({
    url: '/exp-revenue/category',
    method: 'get'
  })
}
export function updateRevenue(data) {
  return request({
    url: '/exp-revenue/update',
    method: 'post',
    data: data
  })
}

export function getRevenue(id) {
  return request({
    url: '/exp-revenue/' + id,
    method: 'get'
  })
}
export function deleteRevenue(id) {
  return request({
    url: '/exp-revenue/delete/' + id,
    method:'post'
  })
}
