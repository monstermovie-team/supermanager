package edu.nf.movie.movie.service;

import com.github.pagehelper.PageInfo;
import edu.nf.movie.movie.entity.*;

import java.util.List;


/**
 * @author Fu
 * @date 2020/3/4
 */
public interface MovieService {
    PageInfo<MovieInfo> movieInfoList(MovieInfo movieInfo,Integer pageNum, Integer pageSize);

    PageInfo<MovieInfo> movieInfoListByState(Integer pageNum, Integer pageSize, Integer State);

    List<MovieType> movieTypeList();

    List<MovieYear> movieYearList();

    List<MovieRegion> movieRegionList();

    List<MovieState> movieStateList();

    /**
     * 电影介绍
     * @param movieId
     * @return
     * 芊富
     */
    MovieInfo findMovie(Integer movieId);
    /**
     * 加载电影海报
     *芊富
     */
    MovieImage moviePoster(Integer movieId);

    /**
     * 加载电影图集
     * 芊富
     */
    List<String> listMoviePoster(Integer movieId);


    /**
     * 查询演员相关电影
     * @param actorId
     * @return
     */
    List<MovieInfo> listMovieActor(Integer actorId);

    /**
     * 修改电影信息
     * @param movieInfo
     */
    void updateMovieInfo(MovieInfo movieInfo);

    /**
     * 添加电影信息
     * @param movieInfo
     */
    void addMovieInfo(MovieInfo movieInfo);
}
