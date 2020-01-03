package com.chao.note.leetcode;




import com.chao.note.leetcode.entry.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 *
 * Created by 15313 on 2019/12/18.
 */
public class Solution {

    public static void main(String[] args) {

        //7. 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
//        System.out.println(reverse(1534236469));


        //8. 字符串转换整数 (atoi)
//        System.out.println(myAtoi("  -2000000000000000000000000000000000000000000000000000000000000000000000000000000000000000012345678"));
//        System.out.println(myAtoiOptimize("     -42"));


        //11. 盛最多水的容器
//        int[] height = new int[]{1,8,6,2,5,4,8,3,7};
//        System.out.println(maxArea(height));


        //12. 整数转罗马数字
//        System.out.println(intToRoman(4));


        //13. 罗马数字转整数
//        System.out.println(romanToInt("MCMXCIVIII"));


        //14. 最长公共前缀
//        String[] strs = new String[]{"aaaaaaaaaaaaaaaaaaaaaaaaa"};
//        System.out.println(longestCommonPrefix(strs));


        //15. 三数之和
//        int[] nums = new int[]{-1, 0, 1, 2, -1,2, -4 , 4};
//        List<List<Integer>> lists = threeSum(nums);
//        System.out.println(lists.toString());


        //16. 最接近的三数之和
//        int[] nums = new int[]{1,2,4,8,16,32,64,128};
//        System.out.println(threeSumClosestOptimize(nums , 82));


        //17. 电话号码的字母组合
//        System.out.println(letterCombinations(""));
//        System.out.println(letterCombinationsOptimize("234"));


        //18. 四数之和
//        int[] nums = new int[]{-3,-2,-1,0,0,1,2,3};
//        System.out.println(fourSum(nums, 0).toString());


        System.out.println(isValid("]"));

    }


     /**
      * @Author Chao
      * @Description 7. 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
      * @Date  2019/12/18
      */
    public static int reverse(int x) {
        long y = 0;
        while (x != 0){
            y = y*10 + x%10;
            x /= 10;
        }
        return (y > Integer.MAX_VALUE || y < Integer.MIN_VALUE) ? 0 : (int) y;
    }

     /**
      * @Author Chao
      * @Description  8. 字符串转换整数 (atoi)                     执行用时: 23 ms  36.4 MB
      * @Date  2020/1/2
      */
    public static int myAtoi(String str) {
        if (str.isEmpty()){
            return 0;
        }
        str = str.trim();
        String pattern = "^[\\-+[0-9]][0-9]*";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(str);
        if (m.find( )) {
            str = m.group(0);
        } else {
            return 0;
        }
        if (str.equals("-") || str.equals("+")){
            return 0;
        }
        if ((!str.startsWith("0") && !str.startsWith("-") && !str.startsWith("+")) && str.length() >= 12){
            str = str.substring(0,12);
        }
        if ( ((str.startsWith("-") || str.startsWith("+")) && str.charAt(1) != '0' ) && str.length() >= 12) {
            str = str.substring(0,12);
        }
        long aLong = Long.valueOf(str);
        if (aLong > Integer.MAX_VALUE){
            aLong = Integer.MAX_VALUE;
        }else if (aLong < Integer.MIN_VALUE){
            aLong = Integer.MIN_VALUE;
        }
        return (int) aLong;
    }
    /**
     * @Author Chao
     * @Description  8. 字符串转换整数 (atoi)  (优化)optimize        执行用时: 2 ms  35.9 MB
     * @Date  2020/1/2
     */
    public static int myAtoiOptimize(String str) {
        if (str.isEmpty()) return 0;
//        str = str.trim();

        long sum = 0;
        int index = 0 , sign = 1, len = str.length();

        // while 比 str = str.trim();  取出空格 优化了 1ms
        while(index<len&&str.charAt(index)==' ') {
            index++;
        }

        if (index<len && '+'== str.charAt(index)){
            index++;
        }else if (index<len && '-' == str.charAt(index)) {
            index++;
            sign = -1;
        }
        while (index<len && str.charAt(index) >= '0' && str.charAt(index) <= '9'){
            sum = sum*10 + str.charAt(index)-'0';
            if (sum != (int)sum){
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            index++;
        }
        if (sum != (int)sum){
            return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
        return (int)(sum * sign);
    }

     /**
      * @Author Chao
      * @Description  11. 盛最多水的容器
      * @Date  2019/12/18
      */
    public static int maxArea(int[] height) {
        int max = 0;
//        for (int i = 1; i <= height.length; i++){
//            for (int j=i+1; j<= height.length; j++){
//                int y = (height[i-1] <= height[j-1]) ? height[i-1] : height[j-1];
//               max = ( (j-i) * y ) > max ? ( (j-i) * y ) : max;
//            }
//        }

//===================== 优化 ============================
        //思路：y点 从前往后与当前点x对比 ，如果y点的 高大于x 则此时是x为起始点的最大面积
        //  x 点 加 1 ， 进行下个一点为起始点 同理寻找最大面积值
        int i=0;
        int j=height.length-1;
        int h = 0;
        while (j > i){
            h = Math.min(height[j],height[i]);
            max = Math.max(max,(j-i)*h);
            if (height[j] >= height[i]){
                i++;
            }else {
                j--;
            }
        }
        return max;

    }

     /**
      * @Author Chao
      * @Description  12. 整数转罗马数字
      *                 罗马数字包含以下七种字符： I，V，X(10)，L(50)，C(100)，D(500) 和 M(1000)。
      *
      *         I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
      *         X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
      *         C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
      * @Date  2019/12/18
      */
    public static String intToRoman(int num) {

        int index = 0;
        int[] romanNum =   {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] romanStr = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

        StringBuffer sb = new StringBuffer();
        while (num != 0){
            if (num >= romanNum[index]){
                num -= romanNum[index];
                sb = sb.append(romanStr[index]);
            }
            while (num != 0 && num < romanNum[index]) {
                index++;
            }
        }
        return sb.toString();
    }

     /**
      * @Author Chao
      * @Description    13. 罗马数字转整数
      * @Date  2019/12/18
      */
    public static int romanToInt(String s) {
//        List<String> romanStr = Arrays.asList("M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I");
//        int[] romanNum =   {1000,900,500,400,100,90,50,40,10,9,5,4,1};
//        int sum = 0 , index = 0 , len = s.length()-1;
//        while (index <= len){
//            if (index < len && romanStr.contains(s.substring(index,index+2))){
//                int i = romanStr.indexOf(s.substring(index,index+2));
//                sum += romanNum[i];
//                index += 2;
//            }else {
//                int i = romanStr.indexOf(s.charAt(index)+"");
//                sum += romanNum[i];
//                index++;
//            }
//        }

// ========================优化===================================================
        int sum = 0 , index = 0 , len = s.length()-1 , num = 0;
        int preNum = getValue(s.charAt(index));
        while (index < len){
            num = getValue(s.charAt(++index));
            if (num > preNum){
                sum -= preNum;
            }else {
                sum += preNum;
            }
            preNum = num;
        }
        sum += preNum;
        return sum;
    }
    private static int getValue(char c){
        switch(c){
            case 'I':return 1;
            case 'V':return 5;
            case 'X':return 10;
            case 'L':return 50;
            case 'C':return 100;
            case 'D':return 500;
            case 'M':return 1000;
            default:return 0;
        }
    }

     /**
      * @Author Chao
      * @Description    14. 最长公共前缀
      * @Date  2019/12/18
      */
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0){
            return "";
        }
        String prefix = strs[0];
        for (int i=0;i < strs.length;i++) {
            if (strs[i]==null || "".equals(strs[i])) {//如果数组中存在空字符串，则返回""
                return "";
            }
            while(!strs[i].startsWith(prefix)) {//取出第一个字符串作为公共前缀进行匹配，不满足则每次取其去掉最后一位的子串再度匹配
                prefix=prefix.substring(0,prefix.length()-1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        return prefix;
    }

     /**
      * @Author Chao
      * @Description  15. 三数之和
      *         执行用时 :28 ms ms, 我的提交执行用时已经战胜 99.36 % 的 java 提交记录
      *         内存消耗 :48.4 MB MB
      *
      * @Date  2020/1/2
      */
    public static List<List<Integer>> threeSum(int[] nums) {
//        -4 , -1, 0, 1, 2, -1, 2, 4
//        -4 , -1, -1, 0, 1, 2, 2, 4
        Arrays.sort(nums);
        int left, right, sum, len = nums.length;
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < len - 2; i++) {
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            left = i + 1;
            right = len - 1;
            while (left < right) {
                //        -4 , -1, -1, 0, 1, 2, 2, 4
                sum = nums[left] + nums[right] + nums[i];
                if (sum < 0) left++;
                else if (sum > 0) right--;
                else if (sum == 0) {
                    list.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left + 1] == nums[left]) left++;
                    while (left < right && nums[right - 1] == nums[right]) right--;
                    left++;
                    right--;
                }
            }
        }
        return list;
    }

     /**
      * @Author Chao
      * @Description  16. 最接近的三数之和
      *         执行用时 :60 ms, 在所有 java 提交中击败了9.30%的用户
                内存消耗 :36.3 MB, 在所有 java 提交中击败了84.18%的用户

      * @Date  2020/1/2
      */
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int num =0 , sum = 0 , diff = Integer.MAX_VALUE;
        int index = 0 , begin = 1 , end = nums.length-1;
        while (begin < end){
            sum = nums[index] + nums[begin] + nums[end];
            if (target == sum) return sum;
            if (Math.abs(target - sum) < diff){
                diff = Math.abs(target - sum);
                num = sum;
            }
            if (diff == 0) break;
            end--;
            if (begin >= end && index < end){
                begin++;
                end = nums.length-1;
            }
            if (begin == nums.length-1) {
                index++;
                begin = index + 1;
                end = nums.length-1;
            }
        }
        return num;
    }

    /**
     * @Author Chao
     * @Description  16. 最接近的三数之和       (优化)optimize
     *          执行用时 :4 ms, 在所有 java 提交中击败了95.16%的用户
                内存消耗 :37 MB, 在所有 java 提交中击败了82.85%的用户
     *
     * @Date  2020/1/2
     */
    public static int threeSumClosestOptimize(int[] nums, int target){
        Arrays.sort(nums);
        int sum = 0;
        int diff = Integer.MAX_VALUE;
        int index = 0 , end = nums.length-1;
        while (index < end){
            //1,2,4,8,16,32,64,128
            int left = index + 1 , right = nums.length-1;
            while (left < right){
                int localSum =  nums[index] + nums[left] + nums[right];
                if (localSum == target) return localSum;
                if (localSum > target){
                    if (diff > localSum - target){
                        diff = localSum - target;
                        sum = localSum;
                    }
                    right--;
                }else {
                    if (diff > target - localSum){
                        diff = target - localSum;
                        sum = localSum;
                    }
                    left++;
                }
            }
            index++;
        }
        return sum;
    }

     /**
      * @Author Chao
      * @Description  17. 电话号码的字母组合
      *         执行用时 :2 ms, 在所有 Java 提交中击败了14.20%的用户
                内存消耗 :36.3 MB, 在所有 Java 提交中击败了73.00%的用户
      *
      * @Date  2020/1/2
      */
    public static List<String> letterCombinations(String digits) {

        if (digits == null || digits.isEmpty())return new ArrayList<String>();
        List<String> listSb = new ArrayList<>();

        List<String> keyValue = getKeyValue(digits.charAt(0) + "");
        for (String s : keyValue) {
            listSb.add(s);
        }
        int index = 1;
        while (index < digits.length()){
            List<String> list = new ArrayList<>();
            keyValue = getKeyValue(digits.charAt(index) + "");
            for (String str : listSb) {
                for (String s : keyValue) {
                    StringBuffer sb = new StringBuffer();
                    list.add(str+s);
                }
            }

            int i = listSb.size()-1;
            while (i >= 0){
                listSb.remove(i--);
            }
            i++;
            while ( i < list.size()){
                listSb.add(list.get(i++));
            }

            if (++index == digits.length()){
                break;
            }
        }
        return listSb;
    }
    private static List<String> getKeyValue(String str){
        switch (str){
            case "2":
                return Arrays.asList("a","b","c");
            case "3":
                return Arrays.asList("d","e","f");
            case "4":
                return Arrays.asList("g","h","i");
            case "5":
                return Arrays.asList("j","k","l");
            case "6":
                return Arrays.asList("m","n","o");
            case "7":
                return Arrays.asList("p","q","r","s");
            case "8":
                return Arrays.asList("t","u","v");
            case "9":
                return Arrays.asList("w","x","y","z");
            default:
                return new ArrayList<>();
        }
    }


     /**
      * @Author Chao
      * @Description  17. 电话号码的字母组合         (优化)optimize
      *         执行用时 :1 ms, 在所有 Java 提交中击败了93.90%的用户
      *         内存消耗 :35.9 MB, 在所有 Java 提交中击败了74.17%的用户
      *
      * @Date  2020/1/3
      */
    public static List<String> letterCombinationsOptimize(String digits){
        String[] arr = new String[]{"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        List<String> result = new ArrayList<>();
        if (digits == null || digits.isEmpty()) return result;
        letterCombinationsDFS(digits , arr , result , "");
        return result;
    }
    private static void letterCombinationsDFS(String digits, String[] arr, List<String> result, String letter){
        if (letter.length() == digits.length()) {
            result.add(letter);
            return;
        }
        char[] chars = arr[digits.charAt(letter.length()) - '0' - 2].toCharArray();
        for (char aChar : chars) {
            letterCombinationsDFS(digits , arr , result , aChar+letter);
        }
    }



     /**
      * @Author Chao
      * @Description  18. 四数之和
      *         //使用while()
      *         执行用时 :50 ms, 在所有 Java 提交中击败了20.29%的用户
                内存消耗 :37.1 MB, 在所有 Java 提交中击败了97.03%的用户

                //使用lists.contains(list)
                执行用时 :37 ms, 在所有 Java 提交中击败了41.88%的用户
                内存消耗 :36.7 MB, 在所有 Java 提交中击败了98.84%的用户

      * @Date  2020/1/3
      */
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        if (nums.length < 4) return lists;
        Arrays.sort(nums);
        int first = 0 , secend = 1 , left = 2 , right = nums.length-1;
        int sum = 0;
        //-3,-2,-1,0,0,1,2,3
        while (first < nums.length-3){
            while (secend < nums.length-2){
                sum = nums[first] + nums[secend] + nums[left] + nums[right];
                if (sum == target) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[first]);
                    list.add(nums[secend]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    if (!lists.contains(list)){
                        lists.add(list);
                    }
                }
                if (left < right){
                    if (sum < target){
                        left++;
//                        while (left < right && nums[left-1] == nums[left]){
//                            left++;
//                        }
                    }else {
                        right--;
//                        while (left < right && nums[right] == nums[right+1]){
//                            right--;
//                        }
                    }
                }
                if (left >= right){
                    secend++;
//                    while (secend < nums.length-2 && nums[secend-1] == nums[secend]){
//                        secend++;
//                    }
                    left = secend+1;
                    right = nums.length-1;
                }
            }
            first++;
//            while (first < nums.length-3 && nums[first-1] == nums[first]){
//                first++;
//            }
            secend = first+1;
            left = secend+1;
            right = nums.length-1;
        }
        return lists;
    }

     /**
      * @Author Chao
      * @Description    19. 删除链表的倒数第N个节点
      * @Date  2020/1/3
      */
    public ListNode removeNthFromEnd(ListNode head, int n) {
       return null;
    }


     /**
      * @Author Chao
      * @Description    20. 有效的括号
      *         执行用时 :12 ms, 在所有 Java 提交中击败了9.27% 的用户
                内存消耗 :36.7 MB, 在所有 Java 提交中击败了34.78% 的用户
      *
      *   ==========================(优化)optimize============================================
      *         执行用时 :1 ms, 在所有 Java 提交中击败了98.91% 的用户
      *         内存消耗 :34.2 MB, 在所有 Java 提交中击败了86.74% 的用户
      * @Date  2020/1/3
      */
    public static boolean isValid(String s) {
        if (s.equals("")) return true;
        char[] chars = s.toCharArray();
        int length = chars.length;
        char[] stack = new char[length/2+1];
        int index = 0;
        char c;
        for (int i=0; i<length; i++){
            if (' ' == chars[i]) continue;
            if (index == length/2+1) return false;
            switch (chars[i]){
                case '(':
                case '[':
                case '{':
                    stack[index++] = chars[i];
                    break;
                case ')':
                    if (index>0){
                        c = stack[--index];
                        if (!(c == '('))  return false;
                        break;
                    }
                case ']':
                    if (index>0){
                        c = stack[--index];
                        if (!(c == '['))  return false;
                        break;
                    }
                case '}':
                    if (index>0){
                        c = stack[--index];
                        if (!(c == '{'))  return false;
                        break;
                    }else {
                        return false;
                    }
            }
        }
        if (index!=0) return false;
        return true;

        //========================  Old =======================================
//        List<String> stack = new ArrayList<>();
//        for (int i=0; i<s.toCharArray().length; i++){
//            String sc = s.charAt(i) + "";
//            if (" ".equals(sc)){
//                continue;
//            }
//            if ("(".equals(sc) || "{".equals(sc) || "[".equals(sc) ){
//                stack.add(0, sc);
//            }else {
//                if (stack.size() == 0){
//                    return false;
//                }
//                String pop = stack.get(0);
//                stack.remove(0);
//                if ( !(("(".equals(pop) && ")".equals(sc)) ||  ("{".equals(pop) && "}".equals(sc)) || ("[".equals(pop) && "]".equals(sc))) ){
//                    return false;
//                }
//            }
//        }
//        if (stack.size() != 0){
//            return false;
//        }
//        return true;
    }


    /**
     * @Author chao
     * @Description  22. 括号生成   (动态规划)
     *
     * @Date 2019/12/21 12:51
     */
    public static List<String> generateParenthesis(int n) {
        if(n == 0){
            return  new ArrayList<String>();
        }
        List<List<String>> dp = new ArrayList<>();
        List<String> dp0 = new ArrayList<>();

        dp0.add("");
        dp.add(dp0);

        for (int i=1;i<=n;i++){
            List<String> cur = new ArrayList<>();
            for (int j=0;j<i;j++){
                List<String> str1 = dp.get(j);
                List<String> str2 = dp.get(i - 1 - j);
                for (String s1 : str1) {
                    for (String s2 : str2) {
                        cur.add("(" + s1 + ")" + s2);
                    }
                }
            }
            dp.add(cur);
        }
        return dp.get(n);
    }



}
