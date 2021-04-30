import request from '@/utils/request'

export function listOrder(query) {
  return request({
    method: 'get',
    params: {
      _gp: 'admin.order',
      _mt: 'list',
      ...query
    }
  })
}

export function detailOrder(orderId) {
  return request({
    method: 'get',
    params: {
      _gp: 'admin.order',
      _mt: 'detail',
      orderId
    }
  })
}

export function shipOrder(shipForm) {
  return request({
    method: 'post',
    params: {
      _gp: 'admin.order',
      _mt: 'ship',
      ...shipForm
    }
  })
}

export function refundOrder(refundForm) {
  return request({
    method: 'post',
    params: {
      _gp: 'admin.order',
      _mt: 'refund',
      ...refundForm
    }
  })
}

export function getExcelInfo(data) {
  return request({
    method: 'post',
    params: {
      _gp: 'admin.order',
      _mt: 'queryToExcel',
      ...data
    }
  })
}

export function listByStatus(data) {
  return request({
    method: 'get',
    params: {
      _gp: 'admin.order',
      _mt: 'listByStatus',
      ...data
    }
  })
}

export function updateOrderStatus(data) {
  return request({
    method: 'get',
    params: {
      _gp: 'admin.order',
      _mt: 'updateOrderStatus',
      ...data
    }
  })
}

export function distributeOrder(data) {
  return request({
    method: 'get',
    params: {
      _gp: 'admin.order',
      _mt: 'distributeOrder',
      ...data
    }
  })
}

export function doExport(data) {
  return request({
    method: 'get',
    params: {
      _gp: 'order.export',
      ...data
    }
  })
}

