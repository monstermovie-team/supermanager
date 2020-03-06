package edu.nf.movie.cinema.pcweb.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.nf.movie.cinema.service.CinemaService;
import edu.nf.movie.cinema.pcweb.vo.ResultVO;
import edu.nf.movie.cinema.service.CinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author BoomShaGa1aGa
 * @date 2019/12/24
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CinemaService cinemaService;

    /**
     *  重写父类的configure方法
     *  HttpSecurity就是用来构建和装配当前整个过滤链
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                //禁用csrf
                .csrf().disable()
                //配置登陆表单
                .formLogin()
                //配置登陆页面
                .loginPage("/login.html")
                //指定登陆请求的url
                .loginProcessingUrl("/cinema_login").permitAll()
                //设置页面input的name属性值
                .usernameParameter("accounts")
                .passwordParameter("password")
                //验证通过后转发的url
                //.successForwardUrl("/get_user")
                //验证通过后跳转的url地址
                //.defaultSuccessUrl("/get_user")
                //当验证成功需要自定义响应消息或者返回json等数据时，使用successHandler方法
                .successHandler(succHandler())
                //验证失败需要跳转的页面
                //.failureUrl("/login.html")
                //当验证失败需要自定义响应消息或者返回json等数据时，使用failureHandler方法
                .failureHandler(failHandler())
                .and()
                //请求认证鉴权配置
                .authorizeRequests()
                //任何请求都需要身份认证
                .anyRequest().authenticated()
                .and()
                //登出
                .logout()
                //处理登出请求的url
                .logoutUrl("/log_out")
                //指定登出之后需要跳转的url
                .logoutSuccessUrl("/login.html")
                //如果登出需要返回自定义信息或json，可以调用logoutSuccessHandler()
                //并自定义一个LogoutSuccessHandler实现
                //.logoutSuccessHandler()
                //销毁当前Session
                .invalidateHttpSession(true)
                //清除cookie的sessionId
                .deleteCookies("JSESSIONID")
                .and()
                //会话管理
                .sessionManagement()
                //指定session的创建方式（创建策略）
                //IF_REQUIRED：Security默认的创建方式，当需要的时候，就会创建Session
                //ALWAYS：如果session不存在，则创建
                //NEVER：Security从不创建Session，但是如果Session已存在，会使用该Session
                //STATELESS：Security不会创建也不会使用Session
                .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
                //防止会话固定攻击（默认是启用的）
                .sessionFixation().migrateSession()
                //当session过期以后指定一个跳转的页面
                .invalidSessionUrl("/login.html");
        //session的并发控制，保证用户的Session只有一个，防止用户二次登陆
        //.maximumSessions(1)
        //security可以直接阻止用户再次登陆，从而保证原来的会话可用性
        //.maxSessionsPreventsLogin(true);

    }

    /**
     *  重写参数为WebSecurity的configure方法
     *  说明WebSecurity和HttpSecurity区别：
     *  HttpSecurity是针对某一条验证链的配置
     *  WebSecurity是针对所有验证链的一个公共配置
     *  可以通过WebSecurity中设置静态资源不经过任何的验证链
     * @param web
     * @throws Exception
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/css/**", "/js/**",
                "/**/*.html", "/**/*.jpg", "/**/*.png", "/**/*.ico");
    }

    /**
     *  指定获取用户信息的Service类，因为该Service类必须实现UserDetailsService接口
     *  ，所以security会调用该接口的loadUserByUsername方法获取用户以及角色信息
     *
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //auth.inMemoryAuthentication().withUser("wangl").password("{noop}123456").roles("user");
        auth.userDetailsService(cinemaService);
    }

    /**
     *  装配AuthenticationFailureHandler，
     *  当验证未通过时，可以调用此对象来响应自定义验证消息
     * @return
     */
    private AuthenticationFailureHandler failHandler(){
        return new AuthenticationFailureHandler() {
            @Override
            public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
                response.setContentType("application/json;charset=utf-8");
                ResultVO vo = new ResultVO();
                vo.setCode(HttpStatus.UNAUTHORIZED.value());
                vo.setMessage("账号或密码错误");
                ObjectMapper mapper = new ObjectMapper();
                mapper.writeValue(response.getWriter(), vo);
            }
        };
    }

    /**
     *  自定义成功的消息响应
     * @return
     */
    private AuthenticationSuccessHandler succHandler(){
        return new AuthenticationSuccessHandler() {
            @Override
            public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
                response.setContentType("application/json;charset=utf-8");
                ResultVO vo = new ResultVO();
                vo.setCode(HttpStatus.OK.value());
                ObjectMapper mapper = new ObjectMapper();
                mapper.writeValue(response.getWriter(), vo);
            }
        };
    }
}
