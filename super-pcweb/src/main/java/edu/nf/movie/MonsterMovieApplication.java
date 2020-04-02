package edu.nf.movie;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.CorsRegistry;


/**
 * @author BoomShaGa1aGa
 * @date 2020-03-02
 */
@SpringBootApplication
@MapperScan(basePackages = {"edu.nf.movie.superadmin.dao",
                            "edu.nf.movie.movie.dao",
                            "edu.nf.movie.actor.dao"})
public class MonsterMovieApplication{

    public static void main(String[] args) {
        SpringApplication.run(MonsterMovieApplication.class);
    }
}
