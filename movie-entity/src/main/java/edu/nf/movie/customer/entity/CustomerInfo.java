package edu.nf.movie.customer.entity;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author BoomShaGa1aGa
 * @date 2020-02-29
 * 用户信息
 */
@Data
public class CustomerInfo implements UserDetails {
    /**
     * 用户id
     */
    private int customerId;
    /**
     * 用户姓名
     */
    private String customerName;
    /**
     * 用户账号
     */
    private String customerAccounts;
    /**
     * 用户密码
     */
    private String customerPassword;
    /**
     * 用户头像
     */
    private String customerPhoto;
    /**
     * 用户性别
     */
    private String customerSex;
    /**
     * 用户出生日期
     */
    private Date customerBirthday;
    /**
     * 用户兴趣
     */
    private String customerInterest;
    /**
     * 用户签名
     */
    private String customerSign;
    /**
     * 用户状态
     */
    private Boolean customerState;
    /**
     * 关联角色
     */
    private List<CustomerRole> roles = new ArrayList<>();
    /**
     * 用于将Roles信息封装到GrantedAuthority对象中，
     * 因此当查询出Roles信息后需要转换到GrantedAuthority中
     */
    private List<GrantedAuthority> authorities = new ArrayList<>();

    @Override
    public String getPassword() {
        return customerPassword;
    }

    @Override
    public String getUsername() {
        return customerAccounts;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return customerState;
    }
}
