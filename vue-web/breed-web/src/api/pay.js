import request from '@/utils/request'

export function fetchList(params) {
  return request({
    url: '/exp-pay/list',
    method: 'get',
    params: params
  })
}

export function createPay(data) {
  return request({
    url: '/exp-pay/create',
    method: 'post',
    data: data
  })
}

export function getCategory(data) {
  return request({
    url: '/exp-pay/category',
    method: 'get'
  })
}
export function updatePay(data) {
  return request({
    url: '/exp-pay/update',
    method: 'post',
    data: data
  })
}

export function getPay(id) {
  return request({
    url: '/exp-pay/' + id,
    method: 'get'
  })
}
export function deletePay(id) {
  return request({
    url: '/exp-pay/delete/' + id,
    method:'post'
  })
}
