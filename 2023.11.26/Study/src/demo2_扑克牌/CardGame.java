package demo2_扑克牌;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2023-11-26
 * Time: 17:58
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/** * @author xiaoxie
 * @date 2023年11月26日 17:58
 */
public class CardGame  {
  private static final String[] Decor = {"♥","♠","♣","♦"};
  //初始化牌
  public List<Card> Cards() {
      List<Card> cards = new ArrayList<>();
      for (int i = 0; i < 4; i++) {
          for (int j = 1; j <= 13; j++) {
              cards.add(new Card(Decor[i],j));
          }
      }
      return cards;
  }
  //洗牌
 public void Shuffle(List<Card> cards) {
     Random random = new Random();
     for (int i = cards.size()-1;i > 0; i--) {
         int index = random.nextInt(i);
         Swap(cards,index,i);
     }
 }
 private void Swap(List<Card> cardList,int i,int j) {
      Card temp = cardList.get(i);
      cardList.set(i,cardList.get(j));
      cardList.set(j,temp);
 }
 //发牌
  public List<List<Card>> Licensing(List<Card> cards) {
      List<Card> A = new ArrayList<>();
      List<Card> B = new ArrayList<>();
      List<Card> C = new ArrayList<>();
      List<List<Card>> hand = new ArrayList<>();
      hand.add(A);
      hand.add(B);
      hand.add(C);
      for (int i = 0; i < 5; i++) {
          for (int j = 0; j < 3 ; j++) {
              Card card =cards.remove(0);
              hand.get(j).add(card);
          }
      }
      return hand;
  }
  //牛牛比大小
  public void Compare(List<List<Card>> cards) {
      int[] sum = new int[3];
      for (int i = 0; i < 3; i++) {
          for (int j = 0; j < 5; j++) {
              if(cards.get(i).get(j).Nums > 10) {
                  cards.get(i).get(j).Nums = 10;
              }
              sum[i] += cards.get(i).get(j).Nums;
          }
      }
      int ans = Max(sum);
      System.out.println("最大的牌为："+"牛"+(ans == 0?"牛":ans));
  }
  private int Max(int[] sum) {
      int max = -1;
      for (int i = 0; i < sum.length; i++) {
          int ret = sum[i] % 10;
          if((max != 0 && ret > max) || ret == 0) {
              max = ret;
          }
      }
      return max;
  }
}
