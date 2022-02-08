import java.util.Scanner;

public class Player {
  public static int decidesPlayerHand() {
    int playerHand;
    Scanner scanner = new Scanner(System.in);

    //課題2(Bot) Playerの手の決定とその表示
    //1~3以外の入力に対してエラー文の表示および再入力させる処理
    while(true) {
      try {
        playerHand = Integer.parseInt(scanner.next());
        if (playerHand < 1 || playerHand > 3) {
          System.out.println("1~3の数値を入力して下さい。");
          continue;
        }
        break;
      } catch(Exception e) {
        System.out.println("1~3の数値を入力して下さい。");
      }
    }
    scanner.close();
    return playerHand;
  }
}