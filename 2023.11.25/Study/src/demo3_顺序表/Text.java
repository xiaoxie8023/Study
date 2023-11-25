package demo3_顺序表;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2023-11-25
 * Time: 19:23
 */

import java.util.Arrays;

/** * @author xiaoxie
 * @date 2023年11月25日 19:23
 */
class SeqList implements Ilist {
    public int[] arr;
    public int size;
    private static final int a_size = 5;
   public SeqList() {
       arr = new int[a_size];
   }
    @Override
    public void add(int data) {
       if(isfull()) {
           this.arr = Arrays.copyOf(arr,arr.length+(arr.length >>1));
       }
        arr[size] = data;
        size++;
    }
    @Override
    public void add(int pos, int data) {
       posofAdd(pos);
      if(isfull()) {
          this.arr = Arrays.copyOf(arr,arr.length+(arr.length >>1));
      }
        for (int i = size-1; i >= pos ; i--) {
            arr[i+1] = arr[i];
        }
        arr[pos] = data;
        size++;
    }
    public void posofAdd(int pos) {
        if(pos < 0 || pos >size) {
            throw new PosException("pos位置不合法:"+pos);
        }
    }

    @Override
    public boolean contains(int toFind) {
        for (int i = 0; i < size-1; i++) {
            if(arr[i] == toFind) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(int toFind) {
        for (int i = 0; i < size; i++) {
            if(arr[i] == toFind) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int get(int pos) {
       posofAdd(pos);
       return arr[pos];
    }

    @Override
    public void set(int pos, int value) {
       posofAdd(pos);
       isEympt();
       this.arr[pos] = value;
    }
    @Override
    public boolean isEympt() {
       if(size == 0) {
           throw new EymptException("顺序表为空！");
       }
       return true;
    }

    @Override
    public void remove(int toRemove) {
       isEympt();
       int index = IndexRemove(toRemove);
       if(index == -1) {
           System.out.println("没有找到这个元素");
       } else {
           for (int i = index; i <size-1; i++) {
               arr[i] = arr[i+1];
           }
           size--;
       }
    }
    public int IndexRemove(int toRemove) {
        for (int i = 0; i < size; i++) {
            if(arr[i] == toRemove) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void clear() {
       size = 0;
    }

    @Override
    public void display() {
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    @Override
    public boolean isfull() {
       return size == arr.length;
    }
}
public class Text {
    public static void main(String[] args) {
        SeqList seqList = new SeqList();
        seqList.add(12);
        seqList.add(23);
        seqList.add(34);
        seqList.add(45);
        seqList.add(56);
        //seqList.add(-1,67);
        /*System.out.println(seqList.contains(23));
        System.out.println(seqList.indexOf(23));*/
        //System.out.println(seqList.size());
        //System.out.println(seqList.indexOf(56));
        seqList.display();
        seqList.remove(23);
        seqList.display();

    }
}
