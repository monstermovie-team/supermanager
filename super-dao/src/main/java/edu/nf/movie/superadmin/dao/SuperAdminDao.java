package edu.nf.movie.superadmin.dao;

import edu.nf.movie.superadmin.entity.SuperAdminInfo;
import org.springframework.stereotype.Repository;

/**
 * @author Administrator
 * 管理员
 */
@Repository
public interface SuperAdminDao {

    /**
     * @param accounts 账号
     * @return 根据账号查询用户
     */
    SuperAdminInfo findSuperAdminByAccounts(String accounts);
}
