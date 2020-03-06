package edu.nf.movie.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author wangl
 * @date 2019/12/26
 */
public class PasswordUtils {

    public static String encodePassword(String password){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(password);
    }

    public static void main(String[] args) {
        String password = encodePassword("123");
        System.out.println(password);
    }
}
