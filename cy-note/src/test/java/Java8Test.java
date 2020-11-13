import com.chao.note.util.DateUtils;
import com.google.appengine.repackaged.com.google.common.base.Splitter;
import org.assertj.core.util.Lists;
import org.junit.Test;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by 15313 on 2020/8/19.
 */

public class Java8Test {

    @Test
    public void flatMapTest(){
//        List<String> result = Stream.of(Lists.newArrayList("1", "1", "3"), Lists.newArrayList("1", "2"))
//                .flatMap(Collection::stream).distinct().collect(Collectors.toList());
//        result.forEach(System.out::println);

      List<String> list = Lists.newArrayList();
        for (String s : list) {
            System.out.println("============");
        }
    }


    @Test
    public void skipAndLimit(){

        int pageNum = 0;
        int defaultPageSize = 10;

        String stages = "1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23";
        List<String> skuCodes = Lists.newArrayList(Splitter.on(",").split(stages))
                .stream().map(String::valueOf).collect(Collectors.toList());

        // pageNum 首页为0时
        int i = pageNum * defaultPageSize;
        if (skuCodes != null && !skuCodes.isEmpty()){
            if (skuCodes.size() > i){
                skuCodes = skuCodes.stream().skip(i).limit(defaultPageSize).collect(Collectors.toList());
            }
        }

        skuCodes.forEach(System.out::print);

    }


    @Test
    public void java8Test(){
        ArrayList<String> detailIds = Lists.newArrayList("1", "2","3","4");
        List<Integer> ids = detailIds.stream().map(Integer::valueOf).collect(Collectors.toList());
        ids.stream().forEach(System.out::print);

        String stages = "15,1,6,3,9,12";
        List<Integer> collect = Lists.newArrayList(Splitter.on(",").split(stages))
                .stream().map(Integer::valueOf).sorted(Integer::compareTo)
                .collect(Collectors.toList());

        List<User> users = Lists.newArrayList(Splitter.on(",").split(stages)).stream()
                .map(Integer::valueOf).map(i -> {
                    User user = new User();
                    user.setInteger(i);
                    return user;
                }).sorted((u1,u2) -> u1.getInteger().compareTo(u2.getInteger()))
                .collect(Collectors.toList());


       users.forEach(System.out::println);
       users.forEach(user -> user.setInteger(user.getInteger()+1));
       users.forEach(System.out::println);


    }




    @Test
    public void getAddDayDate() {

        BigDecimal l = new BigDecimal(0.05);
        String s = l.equals(new BigDecimal(0)) ? "0首付" : l.multiply(new BigDecimal(100)).setScale(0, BigDecimal.ROUND_DOWN) + "%";
        System.out.println(s);

        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        System.out.println("当前日期： " + sf.format(c.getTime()));
        c.add(Calendar.DAY_OF_MONTH, 1);
        System.out.println("增加一天后日期 ：  " + sf.format(c.getTime()));
        System.out.println(sf.format(c.getTime()));
    }



    @Test
    public void getSurvivalTime(){

        Integer betweenSecond = null;
        //获取当前系统时间年月日时分秒
        //获取当前系统时间年月日+10
        String date1 = DateUtils.getDate("yyyy-MM-dd HH:mm:ss");
        String date2 = DateUtils.getDate() + "   16:00:00";
        int compare1 = DateUtils.compare(date1, date2);
        if (compare1 > 0) {
            // 和第二天10点比较
            String addDayDate = DateUtils.getAddDayDate(1);
            addDayDate = addDayDate + " 16:00:00  ";
            betweenSecond = Integer.valueOf(DateUtils.getBetweenSecond(date1, addDayDate));
        }else {
            // 和当天10点比较
            betweenSecond = Integer.valueOf(DateUtils.getBetweenSecond(date1, date2));
        }

        System.out.println(betweenSecond);

    }
    
}
