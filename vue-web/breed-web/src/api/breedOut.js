import request from '@/utils/request'
export function fetchList(params) {
  return request({
    url: '/breed-out/list',
    method: 'get',
    params: params
  })
}
export function createBreedOut(data) {
  return request({
    url: '/breed-out/create',
    method: 'post',
    data: data
  })
}
