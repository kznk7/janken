package oit.is.z1438.kaizi.janken.model;

public class MatchInfo {
  int id;
  int user_1;
  int user_2;
  boolean is_active;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getUser_1() {
    return this.user_1;
  }

  public void setUser_1(int user_1) {
    this.user_1 = user_1;
  }

  public int getUser_2() {
    return this.user_2;
  }

  public void setUser_2(int user_2) {
    this.user_2 = user_2;
  }

  public boolean getActive() {
    return this.is_active;
  }

  public void setActive(boolean active) {
    this.is_active = active;
  }

}
