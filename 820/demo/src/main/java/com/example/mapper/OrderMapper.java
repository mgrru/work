package com.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.example.pojo.Order;

public interface OrderMapper {
  @Select("select * from tb_orders where user_id=#{user_id}")
  @Results({
      @Result(id = true, column = "id", property = "id"),
      @Result(column = "number", property = "number"),
      @Result(column = "user_id",property = "user_id")
  })
  List<Order> sel_orders_by_user_id(int user_id);

  
}
