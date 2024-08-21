
package com.example;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.example.mapper.PersonMapper;
import com.example.pojo.Person;
import com.example.util.Mybatis;

public class TestPerson {
  @Test
  public void test_person_by_id() {
    SqlSession sql_session = Mybatis.getSession();
    PersonMapper Person_mapper = sql_session.getMapper(PersonMapper.class);
    Person person = Person_mapper.sel_person_by_id(2);
    System.out.println(person);
    sql_session.close();
  }
}
