package edu.nf.movie.superadmin.entity;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 * 超级管理员用户信息
 */
@Data
public class SuperAdminInfo implements UserDetails {

    /**
     * 用户ID
     */
    private Integer superAdminId;
    /**
     * 用户名称
     */
    private String superAdminName;
    /**
     * 用户账号
     */
    private String superAdminAccounts;
    /**
     * 用户密码
     */
    private String superAdminPassword;
    /**
     * 用户照片
     */
    private String superAdminPhoto;
    /**
     * 用户性别
     */
    private String superAdminSex;
    /**
     * 用户电话
     */
    private String superAdminTelephone;
    /**
     * 用户地址
     */
    private String superAdminAddress;
    /**
     * 用户身份证
     */
    private String superAdminIDCard;
    /**
     * 用户状态
     */
    private boolean superAdminState;

    /**
     * 关联角色
     */
    private List<SuperAdminRole> roles = new ArrayList<>();
    /**
     * 用于将Roles信息封装到GrantedAuthority对象中，
     * 因此当查询出Roles信息后需要转换到GrantedAuthority中
     */
    private List<GrantedAuthority> authorities = new ArrayList<>();

    @Override
    public String getPassword() {
        return superAdminPassword;
    }

    @Override
    public String getUsername() {
        return superAdminAccounts;
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
        return superAdminState;
    }

}
