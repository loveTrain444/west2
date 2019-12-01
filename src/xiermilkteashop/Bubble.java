package xiermilkteashop;

import java.util.Calendar;

/*珍珠类Bubble（继承自配料类），过期时间：7天。*/
public class Bubble extends Ingredient {


    public Bubble() {
    }

    //创建对象时给生产日期赋值
    public Bubble(String ingredientName) {
        super(ingredientName);
        super.guaranteePeriod = 7;
    }

    //重写toString方法
    @Override
    public String toString() {
        return "配料名字："+ingredientName+","
                +"生产日期："
                +dateProduced.get(Calendar.YEAR)+"年"
                +dateProduced.get(Calendar.MONTH)+"月"
                +dateProduced.get(Calendar.DAY_OF_MONTH)+"日"
                +",保质期："+guaranteePeriod+"天";
    }
}
