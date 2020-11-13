import java.math.BigDecimal;
import java.util.List;

/**
 * Created by 15313 on 2020/7/8.
 */
public class User {
    private BigDecimal age;
    private BigDecimal ageBig;
    private String ageString;
    private String ageBigString;

    private Integer integer;


    private List<String> skus;

    public List<String> getSkus() {
        return skus;
    }

    public void setSkus(List<String> skus) {
        this.skus = skus;
    }

    public Integer getInteger() {
        return integer;
    }

    public void setInteger(Integer integer) {
        this.integer = integer;
    }

    public BigDecimal getAge() {
        return age;
    }

    public void setAge(BigDecimal age) {
        this.age = age;
    }

    public BigDecimal getAgeBig() {
        return ageBig;
    }

    public void setAgeBig(BigDecimal ageBig) {
        this.ageBig = ageBig;
    }

    public String getAgeString() {
        return ageString;
    }

    public void setAgeString(String ageString) {
        this.ageString = ageString;
    }

    public String getAgeBigString() {
        return ageBigString;
    }

    public void setAgeBigString(String ageBigString) {
        this.ageBigString = ageBigString;
    }

    @Override
    public String toString() {
        return "User{" +
                "age=" + age +
                ", ageBig=" + ageBig +
                ", ageString='" + ageString + '\'' +
                ", ageBigString='" + ageBigString + '\'' +
                ", integer=" + integer +
                ", skus=" + skus +
                '}';
    }
}
