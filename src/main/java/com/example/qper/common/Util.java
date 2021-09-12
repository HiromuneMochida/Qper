package com.example.qper.common;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class Util {

  /**
   * ユーザー情報を取得する.
   *
   * @return ユーザーemail
   */
  public static String getUserEmail() {

    Authentication auth = SecurityContextHolder.getContext().getAuthentication();

    return auth.getName();
  }

}
