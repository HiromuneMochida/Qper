package com.example.qper.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.qper.entity.AccountEntity;
import com.example.qper.mapper.AccountMapper;

@Service
public class AccountDetailService implements UserDetailsService {

  @Autowired
  private AccountMapper accountMapper;

  /**
   * ログイン認証.
   * @param email メールアドレス
   * @return UserDetails
   */
  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

    AccountEntity entity = accountMapper.identifyUser(email);

    if (entity == null || "".equals(email)) {
      throw new UsernameNotFoundException("");
    }
    List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
    GrantedAuthority authority = new SimpleGrantedAuthority(entity.getRole().toString());
    grantList.add(authority);
    UserDetails userDetails = (UserDetails) new User(entity.getUsername(), entity.getPassword(), grantList);

    return userDetails;

  }

}
