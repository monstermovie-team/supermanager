package edu.nf.movie.test;

import edu.nf.movie.cinema.dao.CinemaDao;
import edu.nf.movie.cinema.entity.CinemaInfo;
import edu.nf.movie.cinema.service.CinemaService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class CinemaDaoTest {

    @Autowired
    private CinemaService cinemaService;

    @Test
    public void loadUserByUsername() {
        UserDetails info = cinemaService.loadUserByUsername("123456789");
        info.getAuthorities();
    }
}