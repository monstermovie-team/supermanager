package edu.nf.movie.movie.pcweb.controller;

import edu.nf.movie.movie.pcweb.vo.ResultVO;
import org.springframework.http.HttpStatus;

/**
 * @author BoomShaGa1aGa
 * @date 2019-12-26
 */
public class BaseController {
    public static <T> ResultVO<T> success(T data){
        ResultVO<T> vo = new ResultVO<T>();
        vo.setCode(HttpStatus.OK.value());
        vo.setData(data);
        return vo;
    }
    public static <T> ResultVO<T> orr(String message){
        ResultVO<T> vo = new ResultVO<T>();
        vo.setCode(500);
        vo.setMessage(message);
        return vo;
    }
}
