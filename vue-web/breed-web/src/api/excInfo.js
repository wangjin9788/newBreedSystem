import request from '@/utils/request'

export function fetchList(params) {
  return request({
    url: '/exc-info/list',
    method: 'get',
    params: params
  })
}
export function updateStatus(eId) {
  return request({
    url: '/exc-info/update/status/' + eId,
    method: 'post'
  })
}
