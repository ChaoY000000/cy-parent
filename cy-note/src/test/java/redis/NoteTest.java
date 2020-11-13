package redis;

/**
 * Created by Chao on 2020/6/15.
 */
public class NoteTest {

    public static void main(String[] args) {
        int num = -155;

        String s = "0x" + toHex(num);
        System.out.println("十进制数" + num + "的十六进制数为：" + s);
        System.out.println(toHex(num));

        System.out.println(toHex2(num));

    }
    public static String toHex(int num) {
        char[] hex = "0123456789ABCDEF".toCharArray();
        String s = new String();
        while(num != 0){
            int end = num&15;
            s = hex[end] + s;
            //无符号右移
            num = num >>> 4;
        }
        if(s.length() == 0){
            s = "0";
        }

        return s;
    }



    // 将10进制数转换成16进制的
    public static String toHex2(int decimal) {
        String hex = "";
        while (decimal != 0) {
            int hexValue = decimal % 16;
            hex = toHexChar(hexValue) + hex;
            decimal = decimal / 16;
        }
        return hex;
    }

    //将0~15的十进制数转换成0~F的十六进制数
    public static char toHexChar(int hexValue) {
        if (hexValue >= 0 && hexValue <= 9)
            return (char) (hexValue + '0');
        else
            return (char) (hexValue - 10 + 'A');
    }


}
