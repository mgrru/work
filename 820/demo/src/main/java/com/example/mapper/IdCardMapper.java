package com.example.mapper;

import org.apache.ibatis.annotations.Select;

import com.example.pojo.IdCard;

public interface IdCardMapper {
  @Select("select * from tb_idcard where id=#{id}")
  IdCard sel_id_card_by_id(int id);
}
