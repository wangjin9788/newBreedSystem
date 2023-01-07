import request from '@/utils/request'

export function fetchList(id,params) {
  return request({
    url: '/breed-detail/list/' + id,
    method: 'get',
    params: params
  })
}

export function createBreedDetail(data) {
  return request({
    url: '/breed-detail/create',
    method: 'post',
    data: data
  })
}

export function updateBreedDetail(data) {
  return request({
    url: '/breed-detail/update',
    method: 'post',
    data: data
  })
}

export function getBreedDetailInfo(id) {
  return request({
    url: '/breed-detail/info/' + id,
    method: 'get'
  })
}

export function deleteBreedDetail(id) {
  return request({
    url: '/breed-detail/delete/' + id,
    method: 'post'
  })
}
export function batchBreedDetail(data) {
  return request({
    url: '/breed-detail/batch/detail',
    method: 'post',
    data: data
  })
}


