package oit.is.z1438.kaizi.janken.model;

import java.util.HashMap;
import java.util.Map;

public class Janken {
  private int user_hand;
  private int cpu_hand;

  Map<Integer, String> hand = new HashMap<Integer, String>() {
    {
      put(0, "ぐー");
      put(1, "ちょき");
      put(2, "ぱー");
    }
  };

  // コンストラクタ
  public Janken(int user_hand) {
    this.user_hand = user_hand;
    this.cpu_hand = 0;
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
