package oit.is.z1438.kaizi.janken.model;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MatchMapper {

  @Select("SELECT * FROM matches")
  ArrayList<Match> selectAllMatches();

  @Select("SELECT * FROM matches WHERE is_active = true")
  ArrayList<Match> selectActiveMatche();

  @Insert("INSERT INTO matches (user_1,user_2,user_1_hand,user_2_hand,is_active) VALUES (#{user_1},#{user_2},#{user_1_hand},#{user_2_hand},#{is_active});")
  @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
  void insertMatch(Match match);

}
