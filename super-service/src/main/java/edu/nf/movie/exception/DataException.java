package edu.nf.movie.exception;

/**
 * @author wangl
 * @date 2019/11/14
 * 自定义数据访问异常
 */
public class DataException extends RuntimeException{
    public DataException(String message) {
        super(message);
    }

    public DataException(String message, Throwable cause) {
        super(message, cause);
    }

    public DataException(Throwable cause) {
        super(cause);
    }
}
