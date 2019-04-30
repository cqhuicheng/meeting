import request from '@/utils/request'

export function add(data) {
  return request({
    url: 'api/fileInfo',
    method: 'post',
    data
  })
}

export function del(id) {
  return request({
    url: 'api/fileInfo/' + id,
    method: 'delete'
  })
}

export function edit(data) {
  return request({
    url: 'api/fileInfo',
    method: 'put',
    data
  })
}
