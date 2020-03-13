package edu.nf.movie.actor.entity;

import lombok.Data;


/**
 * @author 我们狠可爱
 * @date 2020/3/6
 *参演电影表
 * 芊富
 */
@Data
public class ActorJoinMovie {
    /**
     * 演员编号
     */
    private int actorId;
    /**
     * 电影编号
     */
    private int movieId;

}
