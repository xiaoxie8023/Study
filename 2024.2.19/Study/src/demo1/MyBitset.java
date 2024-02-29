package demo1;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2024-02-28
 * Time: 15:33
 */

import java.util.Arrays;

/** * @author xiaoxie
 * @date 2024年02月28日 15:33
 */
public class MyBitset {
    public byte[] elem;
    public int size;
    public MyBitset() {
        this.elem = new byte[1];
    }
    /**
     * 向上取整
     * @author xiaoxie
     * @date 2024/2/28 15:35
     * @param n  最大位数
     * @return null
     */
    public MyBitset(int n) {
        this.elem = new byte[n / 8 + 1];
    }
    /**
     * 设置一个值为1
     * @author xiaoxie
     * @date 2024/2/28 18:31
     * @param val
     */
    public void set(int val) {
        if(val < 0) {
            throw new IndexOutOfBoundsException();
        }
        int arrayIndex = val / 8 ;
        //扩容
        if(arrayIndex > elem.length-1) {
            elem = Arrays.copyOf(elem,arrayIndex+1);
        }
        int bitIndex = val % 8;
        elem[arrayIndex] |=  (1 << bitIndex); //不能进行异或
        size++;
    }
    /**
     *  判断当前位  是不是1
     * @author xiaoxie 
     * @date 2024/2/29 11:22
     * @param val 
     * @return boolean 
     */
    public boolean get(int val) {
        if(val < 0) {
            throw new IndexOutOfBoundsException();
        }
        int arrayIndex = val / 8 ;
        int bitIndex = val % 8;
        if((elem[arrayIndex] & (1 << bitIndex)) != 0) {
            return true;
        }
        return false;
    }
    /**
     * 将对应位置设为0
     * @author xiaoxie 
     * @date 2024/2/29 11:23
     * @param val  
     */
    public void reSet(int val) {
        if(val < 0) {
            throw new IndexOutOfBoundsException();
        }
        int arrayIndex = val / 8 ;
        int bitIndex = val % 8;
        elem[arrayIndex] &= ~(1 << bitIndex);
        size--;
    }
    /**
     * 记录当前储存数据的个数
     * @author xiaoxie
     * @date 2024/2/28 21:04
     * @return int
     */
    public int size() {
        return size;
    }
}
