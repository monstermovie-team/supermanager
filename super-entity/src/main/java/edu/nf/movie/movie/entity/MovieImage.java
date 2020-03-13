package edu.nf.movie.movie.entity;

import lombok.Data;

/**
 * @author 我们狠可爱
 * @date 2020/3/6
 * 电影图片表
 * 芊富
 */
@Data
public class MovieImage {
    /**
     * 电影图片ID
     */
    private Integer movieImageId ;
    /**
     * 电影ID
     */
    private Integer movieId;
    /**
     * 电影图片路径
     */
    private String movieImagePath;
    /**
     * 电影图片类型，1海报2图集
     */
    private Integer movieImageType;
}
