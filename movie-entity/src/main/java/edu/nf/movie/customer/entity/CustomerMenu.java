package edu.nf.movie.customer.entity;

import lombok.Data;

/**
 * @author BoomShaGa1aGa
 * @date 2020-03-01
 * 用户权限表
 */
@Data
public class CustomerMenu {
    /**
     * 权限id
     */
    private int customerMenuId;
    /**
     * 权限名称
     */
    private String customerMenuName;
}
