package edu.nf.movie.test;

import edu.nf.movie.movie.entity.MovieType;
import edu.nf.movie.movie.service.MovieService;
import edu.nf.movie.superadmin.service.SuperAdminService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class SuperAdminServiceTest {

    @Autowired
    private SuperAdminService superAdminService;

    @Autowired
    private MovieService movieService;

    @Test
    public void loadUserByUsername() {
        UserDetails info = superAdminService.loadUserByUsername("admin");
        System.out.println(info.getPassword());
    }

    @Test
    public void testMovieType() {
        List<MovieType> pageInfo = movieService.movieTypeList();
        pageInfo.forEach(movieInfo -> System.out.println(movieInfo.getMovieTypeMessage()));
    }
}