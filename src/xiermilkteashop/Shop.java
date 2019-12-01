package xiermilkteashop;
/*能完成进货——添加配料（参数：配料类）与出售奶茶（参数：奶茶名字，配
        料名字（ “Bubble”或“Coconut”），根据配料名字选择添加配料）的功能
        西二奶茶店需要实现这个接口
        注意：在进货的方法中你需要准确判断配料参数到底是珍珠还是椰果(用
        instanceof)，然后调用添加椰果或添加珍珠的私有方法（这两个方法仅参数不
        同,即重载）。*/


import java.util.ArrayList;

public class Shop implements TeaShop{
     ArrayList<Ingredient> bubbleList= new ArrayList<>();
     ArrayList<Ingredient> coconutList= new ArrayList<>();

    @Override    //重写进货方法；
    public void purchase(Ingredient I) {

            if (I instanceof Bubble) {

                addIngredient((Bubble) I);
            }

            if (I instanceof Coconut) {

                addIngredient((Coconut) I);
            }
        }
        //一个一个进货麻烦，自定义一个批量进货方法；
        public void purchaseLot(Shop shop,String ingredientName){
            if (ingredientName.equals("Bubble")) {
                shop.purchase(new Bubble("b1"));
                shop.purchase(new Bubble("b2"));
                shop.purchase(new Bubble("b3"));
                shop.purchase(new Bubble("b4"));
                shop.purchase(new Bubble("b5"));
            }
            if (ingredientName.equals("Coconut")) {
                shop.purchase(new Coconut("c1"));
                shop.purchase(new Coconut("c2"));
                shop.purchase(new Coconut("c3"));
                shop.purchase(new Coconut("c4"));
                shop.purchase(new Coconut("c5"));
            }
        }


    //添加配料的私有方法；
    private void addIngredient(Bubble b) {

        bubbleList.add(b);
    }
    private void addIngredient(Coconut c) {
        coconutList.add(c);
    }
    //重写卖奶茶方法
    @Override
    public void sale(String teaName,String ingredientName) {
     if(ingredientName.equals("Bubble"))//如果加的配料是珍珠
     {
        ;
         System.out.println(new MilkTea(teaName,bubbleList.get(0)));
        bubbleList.remove(0);//移除配料对象；

     }
        if(ingredientName.equals("Coconut"))//如果加的配料是椰果
        {

            System.out.println(new MilkTea(teaName,coconutList.get(0)));
            coconutList.remove(0);
        }


    }
}
