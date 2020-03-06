package edu.nf.movie.cinema.service.impl;

import edu.nf.movie.cinema.dao.CinemaDao;
import edu.nf.movie.cinema.entity.CinemaInfo;
import edu.nf.movie.cinema.entity.CinemaRole;
import edu.nf.movie.cinema.service.CinemaService;
import edu.nf.movie.cinema.service.exception.UserNotFoundException;
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
public class CinemaServiceImpl implements CinemaService {

    @Autowired
    private CinemaDao cinemaDao;

    @Override
    public UserDetails loadUserByUsername(String accounts) throws UsernameNotFoundException {
        CinemaInfo user = cinemaDao.findCinemaByAccounts(accounts);
        if(user == null){
            throw new UserNotFoundException("用户不存在");
        }
        //将用户的角色信息封装为GrantedAuthority
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (CinemaRole role : user.getRoles()){
            authorities.add(new SimpleGrantedAuthority(role.getCinemaRoleName()));
        }
        user.setAuthorities(authorities);
        return user;
    }
}
