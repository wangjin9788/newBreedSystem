import request from '@/utils/request'

export function fetchList(params) {
  return request({
    url: '/exc-summary/list',
    method: 'get',
    params: params
  })
}
