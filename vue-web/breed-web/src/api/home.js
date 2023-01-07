import request from '@/utils/request'
export function getPayAndRevenue() {
  return request({
    url: '/pay-analysis/pay_revenue_analysis',
    method: 'get',
  })
}
export function getYearPicRate(yearPic) {
  return request({
    url: '/pay-analysis/year_pic_analysis/' + yearPic,
    method: 'get',
  })
}
export function getPayCategoryRate(yearPayTime) {
  return request({
    url: '/pay-analysis/pay_category_analysis/' + yearPayTime,
    method: 'get',
  })
}
export function getMonthData() {
  return request({
    url: '/pay-analysis/month',
    method: 'get',
  })
}
export function getYearData() {
  return request({
    url: '/pay-analysis/year',
    method: 'get',
  })
}
