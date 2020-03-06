package edu.nf.movie.cinema.dao;


import edu.nf.movie.cinema.entity.CinemaInfo;
import org.springframework.stereotype.Repository;

/**
 * @author Administrator
 * 管理员
 */
@Repository
public interface CinemaDao {

    /**
     * @param accounts 账号
     * @return 根据账号查询用户
     */
    CinemaInfo findCinemaByAccounts(String accounts);
}
