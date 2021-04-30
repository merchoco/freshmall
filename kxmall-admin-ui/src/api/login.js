import request from '@/utils/request'

const captchaImagePath = process.env.HOST + '/captchaImage'

export function loginByUsername(username, password, verifyCode, uuid) {
  const data = {
    username,
    password,
    verifyCode,
    uuid
  }
  return request({
    method: 'post',
    params: {
      _gp: 'admin',
      _mt: 'login',
      ...data
    }
  })
}

export function logout() {
  return request({
    method: 'post',
    params: {
      _gp: 'admin',
      _mt: 'logout'
    }
  })
}

export function getUserInfo() {
  return request({
    method: 'post',
    params: {
      _gp: 'admin',
      _mt: 'info'
    }
  })
}

// 获取验证码
export function getCodeImg() {
  return request({
    url: captchaImagePath,
    method: 'get'
  })
}
