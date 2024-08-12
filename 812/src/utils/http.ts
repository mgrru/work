import axios, { type AxiosInstance, type InternalAxiosRequestConfig, type AxiosResponse } from 'axios'

const http: AxiosInstance = axios.create({  // 创建axios实例，实例名为http
    // baseURL: 'http://127.0.0.1:8088',  // 注意不能使用localhost
    timeout: 10000,
    headers: {
        // 'Content-Type': 'application/json' ,
    }
})

// 根据需要加入拦截器 interceptors的配置
// 请求拦截器
http.interceptors.request.use(
    (config: InternalAxiosRequestConfig) => {
        // 在每个请求发送前可以进行一些处理，例如在请求头中加入Token
        const token = localStorage.getItem('token')
        if (token) {
            //   config.headers.Authorization = `Rounding ${token}`;
            config.headers.token = token // header中添加一个参数，参数名是"token"，值是上方token变量值
        }
        return config
    },
    (error: any) => {
        return Promise.reject(error)
    }
)
// 响应拦截器
http.interceptors.response.use(
    (response: AxiosResponse) => {
        // 在每个响应返回后可以进行一些处理，例如处理错误状态码
        if (response.status >= 200 && response.status < 300) {
            return response.data
        } else {
            // 可以进行错误处理
            return Promise.reject(response)
        }
    },
    (error) => {
        // 响应错误处理
        return Promise.reject(error)
    }
)

export default http