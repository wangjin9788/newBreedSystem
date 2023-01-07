
import request from '@/utils/request'
export function createNutritionCla(data) {
  return request({
    url: '/nutritionCla/create',
    method: 'post',
    data: data
  })
}
