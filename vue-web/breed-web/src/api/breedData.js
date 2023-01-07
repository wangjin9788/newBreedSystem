import request from '@/utils/request'

export function fetchList(params) {
  return request({
    url: '/breed-data/list',
    method: 'get',
    params: params
  })
}
export function selectLabel(params) {
  return request({
    url: '/breed-data/select/label',
    method: 'get',
    params: params
  })
}
export function cascaderLabel() {
  return request({
    url: '/breed-data/cascader/label',
    method: 'get'
  })
}
export function createBreedData(data) {
  return request({
    url: '/breed-data/create',
    method: 'post',
    data: data
  })
}

export function updateBreedInfo(data) {
  return request({
    url: '/breed-data/update',
    method: 'post',
    data: data
  })
}


export function getBreedInfo(id) {
  return request({
    url: '/breed-data/info/' + id,
    method: 'get'
  })
}
export function deleteBreedData(id) {
  return request({
    url: '/breed-data/delete/' + id,
    method: 'post'
  })
}
