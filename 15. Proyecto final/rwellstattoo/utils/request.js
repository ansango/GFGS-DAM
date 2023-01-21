import axios from 'axios'
/* eslint-disable */
console.log('----------- ' + process.env.NODE_ENV + ' -----------')

const axiosRequest = axios.create({
  baseURL: '/api',
  timeout: 10000,
  withCredentials: true
})

export default axiosRequest
