import request from '@/utils/request'

export function fetchList(params) {
  return request({
    url: '/animal-disease/list',
    method: 'get',
    params: params
  })
}

export function createAnimalDisease(data) {
  return request({
    url: '/animal-disease/create',
    method: 'post',
    data: data
  })
}

export function updateAnimalDisease(data) {
  return request({
    url: '/animal-disease/update',
    method: 'post',
    data: data
  })
}

export function deleteAnimalDisease(id) {
  return request({
    url: '/animal-disease/delete/' + id,
    method: 'post'
  })
}
export function getAnimalDiseaseInfo(id) {
  return request({
    url: '/animal-disease/info/' + id,
    method: 'get'
  })
}


