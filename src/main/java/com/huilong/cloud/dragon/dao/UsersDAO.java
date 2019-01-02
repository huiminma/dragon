package com.huilong.cloud.dragon.dao;

import com.huilong.cloud.dragon.model.UsersPO;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

/**
 * @author zhanghuilong
 * @desc
 * @since 2018/11/11
 */
@MapperScan
public interface UsersDAO {

  UsersPO get(@Param("id") Long id);

  UsersPO login(@Param("phoneNo") String phoneNo, @Param("loginPwd") String loginPwd);

  List<UsersPO> listByName(@Param("name") String name);

  int insert(UsersPO usersPO);

  int update(UsersPO usersPO);

  int delete(Integer id);
}
