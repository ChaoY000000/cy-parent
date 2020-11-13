import com.chao.note.util.DateUtils;

import java.math.BigDecimal;


/**
 * Created by 15313 on 2020/6/16.
 */
public class NoteTest {


    public static void main(String[] args) {
        String leftTimesToBegin = DateUtils.getBetweenSecond(DateUtils.getDateTime() , "2020-08-10 02:27:51");
        //距离结束剩余时间
        String leftTimesToEnd = DateUtils.getBetweenSecond(DateUtils.getDateTime() , "2020-08-14 02:24:25");

        System.out.println("DateUtils.getDateTime() = " + DateUtils.getDateTime());


        System.out.println("leftTimesToBegin = " + leftTimesToBegin);
        System.out.println("leftTimesToEnd = " + leftTimesToEnd);
    }




    public static String toHex(String numStr) {
        Integer num = new Integer(numStr);
        char[] hex = "0123456789ABCDEF".toCharArray();
        StringBuilder sb = new StringBuilder();
        while(num != 0){
            int end = num%16;
            sb = sb.append(hex[end]);
            //无符号右移
            num >>>=4;
        }
        if(sb.length() == 0){
            sb = sb.append("0");
        }
        //当结果只要一位时补位0
        if(sb.length() == 1) {
            sb.append("0");
        }
        //倒置字符串
        return "0x" + sb.reverse().toString();
    }

    public static String multiply(String num1, String num2) {
        //将字符串转成数组
        int[] numArr1 = string2IntArray(num1);
        int[] numArr2 = string2IntArray(num2);
        int[][] result = new int[numArr1.length][numArr2.length];
        int[][] res = new int[numArr1.length][numArr2.length];
        //按位依次相乘，并且存入数组对于的位置
        for (int i = 0; i <  numArr1.length; i++) {
            for (int j = 0; j <  numArr2.length; j++) {
                result[i][j] = numArr1[i] * numArr2[j];
            }
        }
        for (int i=0;i<result.length;i++) {
            //将每一行的数据进位相加
            res[i] = intAdd(result[i]);
        }
        //将本对应位的数字进行加和 并另存数组中
        int[] len = new int[numArr1.length + numArr2.length];
        for (int i = 0; i <  res.length; i++) {
            for (int j = 0; j <  res[i].length; j++) {
                len[i+j] += res[i][j];
            }
        }
        //向前进位 并 拼接成字符串
        return forwardAddAppend(len);
    }
    private static int[] string2IntArray(String s) {
        int[] numArr = new int[s.length()];
        for (int i=s.length()-1,j=0;i>=0;i--,j++){
            numArr[j] = Integer.valueOf(s.charAt(i)-'0');
        }
        return numArr;
    }
    private static int[] intAdd(int[] num) {
        for (int i=0;i<num.length-1;i++) {
            if (num[i]>=10){
                num[i+1] += num[i]/10;
                num[i] = num[i]%10;
            }
        }
        return num;
    }
    //向前进位 并 拼接成字符串
    private static String forwardAddAppend(int[] len) {
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<len.length-1;i++) {
            if (len[i]>=10){
                len[i+1] +=  len[i] / 10;
                len[i] = len[i] % 10;
            }
            sb.append(len[i]);
        }
        if (len[len.length-1]!=0){
            sb.append(len[len.length-1]);
        }
        return sb.reverse().toString();
    }

}
