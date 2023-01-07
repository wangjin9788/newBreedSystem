import request from '@/utils/request'

export function fetchList(params) {
  return request({
    url: '/feed-formula/list',
    method: 'get',
    params: params
  })
}

export function selectType(params) {
  return request({
    url: '/feed-formula/select/type',
    method: 'get',
    params: params
  })
}
export function getFormulaInfo(id) {
  return request({
    url: '/feed-formula/info/' + id,
    method: 'get'
  })
}
export function sendMail(data) {
  return request({
    url: '/feed-formula/send/mail',
    method: 'post',
    data: data
  })
}
