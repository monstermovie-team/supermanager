package edu.nf.movie.test;

import com.github.pagehelper.PageInfo;
import edu.nf.movie.movie.entity.MovieInfo;
import edu.nf.movie.movie.entity.MovieType;
import edu.nf.movie.movie.service.MovieService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author Fu
 * @date 2020/3/4
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class MovieTest {

    @Autowired
    private MovieService movieService;

    @Test
    public void testListMovie() {
        PageInfo<MovieInfo> pageInfo = movieService.movieInfoList(1, 5);
        pageInfo.getList().forEach(movieInfo -> System.out.println(movieInfo.getMovieName()));
    }

    @Test
    public void testListMovieByStatic() {
        PageInfo<MovieInfo> pageInfo = movieService.movieInfoListByState(1, 5,1);
        pageInfo.getList().forEach(movieInfo -> System.out.println(movieInfo.getMovieName()));
    }

    @Test
    public void testMovieType() {
        List<MovieType> pageInfo = movieService.movieTypeList();
        pageInfo.forEach(movieInfo -> System.out.println(movieInfo.getMovieTypeMessage()));
    }

    @Test
    public void testfindMovie(){
        MovieInfo movieInfo=movieService.findMovie(1);
        System.out.println(movieInfo.getMoviesType().getMovieTypeMessage());

    }

    @Test
    public void testMoviePoster(){
        String s=movieService.moviePoster(1);
        System.out.println(s);
    }

    @Test
    public void testMovieListPoster(){
        List<String> list=movieService.listMoviePoster(1);
        for (String s : list) {
            System.out.println(s);
        }
    }

    @Test
    public void testListMovieActor(){
        List<MovieInfo> list=movieService.listMovieActor(1);
        for (MovieInfo m : list) {
            System.out.println(m.getMovieId());
            System.out.println(m.getMovieName());
            System.out.println(m.getMovieImage().getMovieImagePath());
        }
    }
}
