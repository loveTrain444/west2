package xiermilkteashop;

import java.util.Calendar;

/*Coconut（继承自配料类），过期时间：5天。*/
public class Coconut extends Ingredient {

    public Coconut() {
    }

    //创建对象时给生产日期赋值
    public Coconut(String ingredientName) {
        super(ingredientName);
        super.guaranteePeriod = 5;
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

