package edu.nf.movie.movie.entity;

import edu.nf.movie.actor.entity.ActorInfo;
import edu.nf.movie.actor.entity.ActorJoinMovie;
import lombok.Data;

/**
 * @author Fu
 * @date 2020/3/4
 */
@Data
public class MovieInfo {
    private Integer movieId;//电影编号
    private String movieName;//电影名称
    private String movieEnglishName;//电影英文名
    private Integer movieWantToSee;//电影想看数
    private Integer movieType;//电影类型
    private Integer movieRegion;//电影区域
    private Integer movieYear;//电影年代
    private Integer movieState;//电影状态
    private Integer movieTime;//电影时长
    private String movieIntroduce;//电影介绍
    private MovieImage movieImage;
    private MovieType moviesType;
    private MovieRegion moviesRegion;
    private MovieYear moviesYear;
    private MovieState moviesState;
    private ActorInfo actorInfo;
    private ActorJoinMovie actorJoinMovie;
}
