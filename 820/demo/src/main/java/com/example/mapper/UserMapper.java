package com.example.mapper;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.example.pojo.User;

public interface UserMapper {
  @Select("select * from tb_user where id=#{id}")
  @Results({
      @Result(id = true, column = "id", property = "id"),
      @Result(column = "username", property = "username"),
      @Result(column = "address", property = "address"),
      @Result(column = "id", property = "orders", many = @Many(select = "com.example.mapper.OrderMapper.sel_orders_by_user_id"))
  })
  User sel_user_by_id(int id);
}
