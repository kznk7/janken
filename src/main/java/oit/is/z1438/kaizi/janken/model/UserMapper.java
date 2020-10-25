package oit.is.z1438.kaizi.janken.model;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

  @Select("SELECT * from users")
  ArrayList<User> selectAllUsers();

  @Select("SELECT id from users where name = #{name}")
  int selectIdByName(String name);

  @Select("SELECT name from users where id = #{id}")
  String selectNameById(int id);

}
