package demo3_顺序表;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2023-11-25
 * Time: 20:45
 */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/** * @author xiaoxie
 * @date 2023年11月25日 20:45
 */
public class Text1 {
    public static void main(String[] args) {

    }
    public static List<Character> func(String str1, String str2) {
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < str1.length(); i++) {
            char ch = str1.charAt(i);
            if(!str2.contains(ch+"")) {
                list.add(str1.charAt(i));
             }
        }
        return list;
    }
    public static void main5(String[]args){
        List<Character> list1 = func("welcome to cvte","come");
        for (Character ch:list1) {
            System.out.print(ch);
        }
        System.out.println();
        }
        public static void main2 (String[]args){
            List<Integer> list = new ArrayList<>();
            list.add(1);
            list.add(6);
            list.add(5);
            list.add(9);
            list.add(10);
            System.out.println(list);
            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i) + " ");
            }
            System.out.println();
            for (Integer i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                System.out.print(it.next() + " ");
            }
            System.out.println();
            ListIterator<Integer> it2 = list.listIterator();
            while (it2.hasNext()) {
                System.out.print(it2.next() + " ");
            }
            System.out.println();
            ListIterator<Integer> it3 = list.listIterator(list.size());
            while (it3.hasPrevious()) {
                System.out.print(it3.previous() + " ");
            }
            System.out.println();
        }
        public static void main1 (String[]args){
            List<Integer> list1 = new ArrayList<>(10);
            list1.add(10);
            list1.add(8);
            list1.add(19);
            list1.add(30);
            System.out.println(list1);
            List<Integer> list2 = new ArrayList<>(list1);
            list2.add(999);
            System.out.println(list2);
            //List<String> list3 = new ArrayList<>(list1);
            list1.set(0, 999);
            System.out.println(list1.subList(0, 3));
        }
    }
