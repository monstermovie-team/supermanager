package edu.nf.movie.test;

import edu.nf.movie.superadmin.service.SuperAdminService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class SuperAdminServiceTest {

    @Autowired
    private SuperAdminService superAdminService;

    @Test
    public void loadUserByUsername() {
        UserDetails info = superAdminService.loadUserByUsername("admin");
        System.out.println(info.getPassword());
    }
}