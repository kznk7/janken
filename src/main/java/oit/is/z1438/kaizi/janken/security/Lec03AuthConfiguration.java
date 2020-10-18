package oit.is.z1438.kaizi.janken.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class Lec03AuthConfiguration extends WebSecurityConfigurerAdapter {

  /**
   * 認証されたユーザがどこにアクセスできるか（認可処理）
   */
  @Override
  protected void configure(HttpSecurity http) throws Exception {

    // Spring Securityのフォームを利用してログインを行う
    http.formLogin();

    // http://localhost:8080/lec02 で始まるURLへのアクセスはログインが必要
    // antMatchers().authenticated がantMatchersへのアクセスに認証を行うことを示す
    // antMatchers()の他にanyRequest()と書くとあらゆるアクセス先を表現できる
    // authenticated()の代わりにpermitAll()と書くと認証処理が不要であることを示す
    http.authorizeRequests().antMatchers("/lec02/**").authenticated();

    // Spring Securityの機能を利用してログアウト．ログアウト時は http://localhost:8080/ に戻る
    http.logout().logoutSuccessUrl("/");
  }

}
