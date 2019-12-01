package xiermilkteashop;

import java.text.SimpleDateFormat;
import java.util.Calendar;
/*配料类Ingredient（一个抽象类），每个配料都有名字、生产日期（使用提
        供的Calendar类）、保质期（单位：天）。*/

public abstract class Ingredient {
    protected String ingredientName;//配料名字；
    protected Calendar dateProduced = Calendar.getInstance();//生产日期；
    protected int guaranteePeriod;//保质期；


    public Ingredient() {
    }

    public Ingredient(String ingredientName) {
        this.ingredientName = ingredientName;
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
