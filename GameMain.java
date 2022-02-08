public class GameMain {
    public static void main(String[] args) {
        //課題1 文章の表示
        System.out.println("1:グー 2:チョキ 3:パー");
        System.out.println("じゃんけん...");

        //課題2(Bot) Playerの手の決定とその表示
        //PlayerクラスのdecidesPlayerHandメソッドとHandクラスのgetHandNameメソッドを使ってPlayerの手を表示する
        int playerHand = Player.decidesPlayerHand();
        System.out.println("プレイヤー : " + Hand.getHandName(playerHand));

        //課題3 Computerの手の決定とその表示
        //ComputerクラスのdecidesComputerHandメソッドとHandクラスのgetHandNameメソッドを使ってPlayerの手を表示する
        //int computerHand =

        //課題4(Bot) 勝敗判定とその表示
        //課題2,3において実装したPlayerおよびComputerの手の表示はVictoryOrDefeatクラスに移動する
    }
}