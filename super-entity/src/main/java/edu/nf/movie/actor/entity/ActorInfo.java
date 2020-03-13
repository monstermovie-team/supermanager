package edu.nf.movie.actor.entity;

import edu.nf.movie.movie.entity.MovieInfo;
import lombok.Data;

/**
 * @author 我们狠可爱
 * @date 2020/3/5
 * 演员表
 */
@Data
public class ActorInfo {
    /**
     *演员编号
     */
    private int actorId;
    /**
     * 演员姓名
     */
    private String actorName;
    /**
     * 演员英文名
     */
    private String actorEnglishName;
    /**
     * 演员身份
     */
    private String actorIdentity;
    /**
     * 演员生日
     */
    private String actorBirthday;
    /**
     * 演员性别
     */
    private String actorSex;
    /**
     * 演员介绍
     */
    private String actorIntroduce;
    /**
     * 演员出生地
     */
    private String actorBirthplace;
    /**
     * 演员国籍
     */
    private String actorNationality;
    /**
     * 演员演员毕业于
     */
    private String actorGraduation;
    /**
     * 演员奖项
     */
    private String actorPrize;

    /**
     * 关联的电影
     */
    private MovieInfo movieInfo;

    /**
     * 关联图片
     */
    private ActorImage actorImages;

    /**
     * 关联演员与用户管理表
     */
    private ActorJoinMovie actorJoinMovies;

}
