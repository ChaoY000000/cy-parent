import com.google.appengine.repackaged.com.google.common.collect.Maps;
import org.junit.Test;

import java.util.Map;
import java.util.function.Function;

/**
 * Created by 15313 on 2020/11/9.
 */
public class FunctionDemo {

    private final Map<String , Function< Integer , Integer>> map = Maps.newHashMap();

    @Test
    public void fun (){
        Integer i = 3;
        Function<Integer ,Integer> fun = i1 -> {
            Integer sum = 0;
            sum = i1 + 5;
            return sum;
        };
        map.put("add" , fun);

        Function<Integer, Integer> add = map.get("add");
        Integer apply = add.apply(i);
        System.out.println(apply);
    }


}
