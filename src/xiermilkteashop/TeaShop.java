package xiermilkteashop;

import java.util.ArrayList;

public interface TeaShop {
    public abstract  void purchase (Ingredient I);//进货的抽象方法
    public abstract  void sale(String teaName,String ingredientName);//卖奶茶的抽象方法
}
