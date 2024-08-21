package com.example.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.example.pojo.Worker;

public interface WorkerMapper {
  @Select("SELECT * from tb_worker where id=#{id}")
  Worker select(int id);

  @Insert("INSERT INTO tb_worker(name,age,sex,worker_id) VALUES(#{name},#{age},#{sex},#{worker_id});")
  int insert_work(Worker worker);

  @Delete("delete from tb_worker where id=#{id}")
  int del_work(int id);
}
