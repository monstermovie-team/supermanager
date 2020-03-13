package edu.nf.movie.movie.service.impl;

import com.github.pagehelper.PageInfo;
import edu.nf.movie.exception.DataException;
import edu.nf.movie.movie.dao.MovieDao;
import edu.nf.movie.movie.entity.MovieInfo;
import edu.nf.movie.movie.entity.MovieRegion;
import edu.nf.movie.movie.entity.MovieType;
import edu.nf.movie.movie.entity.MovieYear;
import edu.nf.movie.movie.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Fu
 * @date 2020/3/4
 */
@Service("movieService")
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieDao movieDao;

    @Override
    public PageInfo<MovieInfo> movieInfoList(Integer pageNum, Integer pageSize) {
        List<MovieInfo> movieInfos = movieDao.movieInfoList(pageNum,pageSize);
        return new PageInfo<>(movieInfos);
    }

    @Override
    public PageInfo<MovieInfo> movieInfoListByState(Integer pageNum, Integer pageSize, Integer State) {
        List<MovieInfo> movieInfos = movieDao.movieInfoListByState(pageNum,pageSize,State);
        return new PageInfo<>(movieInfos);
    }

    @Override
    public List<MovieType> movieTypeList() {
        List<MovieType> movieType = movieDao.movieTypeList();
        return movieType;
    }

    @Override
    public List<MovieYear> movieYearList() {
        List<MovieYear> movieYear = movieDao.movieYearList();
        return movieYear;
    }

    @Override
    public List<MovieRegion> movieRegionList() {
        List<MovieRegion> movieRegion = movieDao.movieRegionList();
        return movieRegion;
    }



    @Override
    public MovieInfo findMovie(Integer movieId) {
        try{
            MovieInfo movieInfo=movieDao.findMovie(movieId);
            return movieInfo;
        }catch (Exception e){
            throw  new DataException("服务器内部错误,暂时无法访问");
        }
    }

    @Override
    public String moviePoster(Integer movieId) {
        try{
            return movieDao.moviePoster(movieId);
        }catch (Exception e){
            throw new DataException("服务器内部错误，无法查询海报");
        }
    }

    @Override
    public List<String> listMoviePoster(Integer movieId) {
        try{
            List<String> list=movieDao.listMoviePoster(movieId);
            return list;
        }catch (Exception e){
            throw new DataException("服务器内部错误，无法查询图集");
        }
    }

    @Override
    public List<MovieInfo> listMovieActor(Integer actorId) {
        try{
            List<MovieInfo> list=movieDao.listMovieActor(actorId);
            return list;
        }catch (Exception e){
            throw new DataException("服务器内部错误，无法查询该演员相关的电影");
        }
    }


}
