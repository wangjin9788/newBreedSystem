import request from '@/utils/request'
export function fetchList(params) {
  return request({
    url: '/ferment-testing/list',
    method: 'get',
    params: params
  })
}
