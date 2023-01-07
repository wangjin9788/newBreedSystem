import request from '@/utils/request'

export function fetchList(params) {
  return request({
    url: '/breed-model/list',
    method: 'get',
    params: params
  })
}

export function createBreedModel(data) {
  return request({
    url: '/breed-model/create',
    method: 'post',
    data: data
  })
}

export function updateBreedModel(data) {
  return request({
    url: '/breed-model/update',
    method: 'post',
    data: data
  })
}

export function deleteBreedModel(id) {
  return request({
    url: '/breed-model/delete/' + id,
    method: 'post'
  })
}
export function getBreedModelInfo(id) {
  return request({
    url: '/breed-model/info/' + id,
    method: 'get'
  })
}

export function selectModelList() {
  return request({
    url: '/breed-model/select/list',
    method: 'get',
  })
}
