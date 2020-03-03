package edu.nf.movie;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author BoomShaGa1aGa
 * @date 2020-03-02
 */
@SpringBootApplication
@MapperScan("edu.nf.movie.customer.dao")
public class MonsterMovieApplication {

    public static void main(String[] args) {
        SpringApplication.run(MonsterMovieApplication.class);
    }
}
