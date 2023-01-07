import request from '@/utils/request'

export function fetchList(params) {
  return request({
    url: '/feed-info/list',
    method: 'get',
    params: params
  })
}

export function createFeedInfo(data) {
  return request({
    url: '/feed-info/create',
    method: 'post',
    data: data
  })
}

export function updateFeedInfo(data) {
  return request({
    url: '/feed-info/update',
    method: 'post',
    data: data
  })
}

export function getFeedInfo(id) {
  return request({
    url: '/feed-info/info/' + id,
    method: 'get'
  })
}

export function deleteFeedInfo(id) {
  return request({
    url: '/feed-info/delete/' + id,
    method: 'post'
  })
}
export function selectFeedList() {
  return request({
    url: '/feed-info/select/list',
    method: 'get',
  })
}
