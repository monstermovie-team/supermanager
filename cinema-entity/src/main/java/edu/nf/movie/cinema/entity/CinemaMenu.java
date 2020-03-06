package edu.nf.movie.cinema.entity;


import lombok.Data;

/**
 * @author Administrator
 * 权限表
 */
@Data
public class CinemaMenu {

    /**
     * 权限id
     */
    private int cinemaMenuId;
    /**
     * 权限名称
     */
    private String  cinemaMenuName;

    /**
     * url
     */
    private String cinemaMenuUrl;

}
