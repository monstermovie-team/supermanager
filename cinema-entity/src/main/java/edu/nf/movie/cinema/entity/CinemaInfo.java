package edu.nf.movie.cinema.entity;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 * 影厅后台管理员用户信息
 */
@Data
public class CinemaInfo implements UserDetails {

    /**
     * 用户ID
     */
    private Integer cinemaId;
    /**
     * 用户名称
     */
    private String cinemaName;
    /**
     * 用户账号
     */
    private String cinemaAccounts;
    /**
     * 用户密码
     */
    private String cinemaPassword;
    /**
     * 用户照片
     */
    private String cinemaPhoto;
    /**
     * 用户性别
     */
    private String cinemaSex;
    /**
     * 用户电话
     */
    private String cinemaTelephone;
    /**
     * 用户地址
     */
    private String cinemaAddress;
    /**
     * 用户身份证
     */
    private String cinemaIDCard;
    /**
     * 用户状态
     */
    private boolean cinemaState;

    /**
     * 关联角色
     */
    private List<CinemaRole> roles = new ArrayList<>();
    /**
     * 用于将Roles信息封装到GrantedAuthority对象中，
     * 因此当查询出Roles信息后需要转换到GrantedAuthority中
     */
    private List<GrantedAuthority> authorities = new ArrayList<>();

    @Override
    public String getPassword() {
        return cinemaPassword;
    }

    @Override
    public String getUsername() {
        return cinemaAccounts;
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
        return cinemaState;
    }

}
