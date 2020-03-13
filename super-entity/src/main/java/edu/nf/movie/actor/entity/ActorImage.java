package edu.nf.movie.actor.entity;

import lombok.Data;

/**
 * @author 我们狠可爱
 * @date 2020/3/6
 */
@Data
public class ActorImage {
    /**
     * 图片ID
     */
    private int actorImageId;
    /**
     * 演员ID
     */
    private int actorId;
    /**
     * 图片路径
     */
    private String actorImagePath;
    /**
     * 图片类型，1头像2图集
     */
    private int actorImageType;
}
