package edu.nf.movie.superadmin.service.impl;

import edu.nf.movie.superadmin.dao.SuperAdminDao;
import edu.nf.movie.superadmin.entity.SuperAdminInfo;
import edu.nf.movie.superadmin.entity.SuperAdminRole;
import edu.nf.movie.superadmin.service.SuperAdminService;
import edu.nf.movie.superadmin.service.exception.UserNotFoundException;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 */
@Service("cinemaService")
@Transactional(rollbackFor = RuntimeException.class)
@MapperScan("edu.nf.movie.cinema.dao")
public class SuperAdminServiceImpl implements SuperAdminService {

    @Autowired
    private SuperAdminDao superAdminDao;

    @Override
    public UserDetails loadUserByUsername(String accounts) throws UsernameNotFoundException {
        SuperAdminInfo user = superAdminDao.findSuperAdminByAccounts(accounts);
        if(user == null){
            throw new UserNotFoundException("用户不存在");
        }
        //将用户的角色信息封装为GrantedAuthority
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (SuperAdminRole role : user.getRoles()){
            authorities.add(new SimpleGrantedAuthority(role.getSuperAdminName()));
        }
        user.setAuthorities(authorities);
        return user;
    }
}
