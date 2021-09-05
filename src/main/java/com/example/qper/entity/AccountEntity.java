package com.example.qper.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.qper.common.ConstantValue;

import lombok.Data;


/**
 * TBL.account
 */
@Data
public class AccountEntity implements UserDetails {

  private final long serialVersionUID = 1L;

  /** メールアドレス */
  private String email;

  /** パスワード */
  private String password;

  /** 権限 */
  private String role;

  /** 削除フラグ */
  private String delFlg;

  /** コンストラクタ */
  public AccountEntity(String userName, String password, String email) {
    this.email = email;
    this.password = password;
    this.role = ConstantValue.DEFAULT_USER;
    this.delFlg = ConstantValue.DEFAULT_VALUE_ZERO;
  }
  /** 引数なしコンストラクタ */
  public AccountEntity() {
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    List<GrantedAuthority> authorities = new ArrayList<>();
    authorities.add(new SimpleGrantedAuthority(this.role.toString()));

    return authorities;
  }

  /** ユーザー名を返却する */
  @Override
  public String getUsername() {
    return email;
  }

  /** アカウントの有効期限の状態を判定する */
  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  /** アカウントのロック状態を判定する */
  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  /** 資格情報の有効期限の状態を判定する */
  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  /** アカウントの状態を判定する */
  @Override
  public boolean isEnabled() {
    return true;
  }

}
