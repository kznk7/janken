package oit.is.z1438.kaizi.janken.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Janken {
  private int user_hand;
  private int cpu_hand;

  Map<Integer, String> hand = new HashMap<Integer, String>() {
    {
      put(0, "Gu");
      put(1, "Choki");
      put(2, "Pa");
    }
  };

  // コンストラクタ
  public Janken(int user_hand) {
    this.user_hand = user_hand;
    this.cpu_hand = new Random().nextInt(3);
  }

  public String getUserHand() {
    return hand.get(user_hand);
  }

  public String getCpuHand() {
    return hand.get(cpu_hand);
  }

  public String result() {
    int result = (user_hand - cpu_hand + 3) % 3;
    switch (result) {
      case 0:
        return "Draw.";
      case 1:
        return "You Lose.";
      case 2:
        return "You Win!";
    }
    return "Error.";
  }
}
