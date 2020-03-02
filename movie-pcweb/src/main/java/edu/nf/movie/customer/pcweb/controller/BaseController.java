package edu.nf.movie.customer.pcweb.controller;

import edu.nf.movie.customer.pcweb.vo.ResultVO;
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
}
