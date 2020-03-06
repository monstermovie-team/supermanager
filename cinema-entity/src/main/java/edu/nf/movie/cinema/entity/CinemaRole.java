package edu.nf.movie.cinema.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 * 影厅后台管理员角色表
 */
@Data
public class CinemaRole {

    /**
     * 角色id
     */
    private int cinemaRoleId;
    /**
     * 角色名称
     */
    private String cinemaRoleName;
    /**
     * 关联菜单
     */
    private List<CinemaMenu> menus = new ArrayList<>();

}
