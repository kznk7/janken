package oit.is.z1438.kaizi.janken.model;

public class Match {
  int id;
  int user_1;
  int user_2;
  String user_1_hand;
  String user_2_hand;

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

  public String getUser_1_hand() {
    return this.user_1_hand;
  }

  public void setUser_1_hand(String user_1_hand) {
    this.user_1_hand = user_1_hand;
  }

  public String getUser_2_hand() {
    return this.user_2_hand;
  }

  public void setUser_2_hand(String user_2_hand) {
    this.user_2_hand = user_2_hand;
  }

}
