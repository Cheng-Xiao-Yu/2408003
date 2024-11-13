package cn.tedu.ivos.base.exception;

import cn.tedu.ivos.base.response.StatusCode;
import lombok.Getter;
//1.自定义业务异常类
public class ServiceException extends RuntimeException{
    //2.定义状态码为其属性
    @Getter
    private StatusCode statusCode;
    //3.添加构造方法
    public ServiceException(StatusCode statusCode) {
        this.statusCode = statusCode;
    }
}
