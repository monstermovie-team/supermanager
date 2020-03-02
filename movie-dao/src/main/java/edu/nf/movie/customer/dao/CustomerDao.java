package edu.nf.movie.customer.dao;

import edu.nf.movie.customer.entity.CustomerInfo;
import org.springframework.stereotype.Repository;

/**
 * @author BoomShaGa1aGa
 * @date 2020-02-29
 * 用户
 */
@Repository
public interface CustomerDao {

    /**
     * @param accounts 账号
     * @return
     * 根据账号查询用户
     */
    CustomerInfo findCustomerByAccounts(String accounts);
}
