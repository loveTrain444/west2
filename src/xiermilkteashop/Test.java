package xiermilkteashop;

import java.util.ArrayList;
import java.util.Calendar;

public class Test {
    public static void main(String[] args) {

        Shop shop = new Shop();

        shop.purchaseLot(shop,"Coconut"); //批量进货方法，不进货时原库存为空
            try{
                saleCheck(shop.coconutList);
            } catch (SoldOutException e) {
                e.printStackTrace();

            }//抛出捕获处理异常；
        shop.sale("奶茶1", "Coconut");//卖一杯椰果奶茶1；




        }
        //处理异常
     public static void saleCheck(ArrayList<Ingredient> list) throws SoldOutException{
         Calendar now = Calendar.getInstance();
         now.add(Calendar.DAY_OF_MONTH,-7);
         for (int i = 0; i < list.size(); i++) {
             if (list.get(i).dateProduced.before(now)) {
                 list.remove(i);
             }
         }//发现过期配料，移除；
             if(list.isEmpty())
             {
                throw new SoldOutException("该配料已售完,需重新进货");
             }//该配料已售完，告知顾客；
         }
    }

