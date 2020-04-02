package edu.nf.movie.movie.pcweb.controller;

import com.github.pagehelper.PageInfo;
import edu.nf.movie.movie.entity.*;
import edu.nf.movie.movie.pcweb.vo.ResultVO;
import edu.nf.movie.movie.service.MovieService;
import edu.nf.movie.util.UploadUtil;
import edu.nf.movie.util.UploadUtil2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author Fu
 * @date 2020/3/4
 */
@RestController
public class MovieController extends BaseController{

    @Autowired
    private MovieService movieService;

    @GetMapping("/movie_list")
    public ResultVO<PageInfo<MovieInfo>> listMovie(MovieInfo movieInfo,Integer pageNum, Integer pageSize){
        PageInfo<MovieInfo> movieInfos = movieService.movieInfoList(movieInfo,pageNum,pageSize);
        return success(movieInfos);
    }

    @GetMapping("/movie_list_by_State")
    public ResultVO<PageInfo<MovieInfo>> listMovieByState(Integer pageNum, Integer pageSize, Integer State){
        PageInfo<MovieInfo> movieInfos = movieService.movieInfoListByState(pageNum,pageSize,State);
        return success(movieInfos);

    }

    @GetMapping("/movie_type")
    public ResultVO listMovieType(){
        List<MovieType> movieType = movieService.movieTypeList();
        return success(movieType);
    }
    @GetMapping("/movie_region")
    public ResultVO listMovieRegion(){
        List<MovieRegion> movieRegion = movieService.movieRegionList();
        return success(movieRegion);
    }
    @GetMapping("/movie_year")
    public ResultVO listMovieYear(){
        List<MovieYear> movieYear = movieService.movieYearList();
        return success(movieYear);
    }
    @GetMapping("/movie_state")
    public ResultVO listMovieState(){
        return success(movieService.movieStateList());
    }

    @GetMapping("/movie_poster")
    public ResultVO moviePoster(Integer movieId){
        MovieImage movieImage = movieService.moviePoster(movieId);
        return success(movieImage);
    }

    @GetMapping("/movie_find")
    public ResultVO findmovie(Integer movieId){
        MovieInfo movieInfo=movieService.findMovie(movieId);
        return success(movieInfo);
    }

    @GetMapping("/findListMovieActor")
    public ResultVO<List<MovieInfo>> getFindMovie(Integer actorId){
        List<MovieInfo> list=movieService.listMovieActor(actorId);
        return success(list);
    }

    @RequestMapping("/uploadPoster")
    public ResultVO uploadPoster(MultipartFile file) throws Exception{
        InputStream is = file.getInputStream();
        System.out.println(file.getOriginalFilename());
        String url = "http://101.37.28.124:8080/monster_movie/movie_images/";
        String fileName = file.getOriginalFilename();
        UploadUtil.upload(url,is,fileName);
        //UploadUtil2.logUpload(url,fileName);
        return success(url+fileName);
    }

    @PostMapping("/updateMovieInfo")
    public ResultVO updateMovieInfo(MovieInfo movieInfo){
        movieService.updateMovieInfo(movieInfo);
        return success("修改成功");
    }

    @PostMapping("/addMovieInfo")
    public ResultVO addMovieInfo(MovieInfo movieInfo){
        movieService.addMovieInfo(movieInfo);
        return success("添加成功");
    }
}
