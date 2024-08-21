package com.example.mapper;

import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.example.pojo.Person;

public interface PersonMapper {
  @Select("select * from tb_person where id=#{id}")
  @Results({
      @Result(column = "card_id", property = "card", one = @One(select = "com.example.mapper.IdCardMapper.sel_id_card_by_id"))
  })
  Person sel_person_by_id(int id);
}
