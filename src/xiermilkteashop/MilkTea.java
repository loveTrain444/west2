package xiermilkteashop;

import java.security.PublicKey;

/*每杯奶茶都有自己的名字（如“奶茶1”，“奶茶2”），
        以及一个配料类成员变量（具体是什么配料取决于实际情况，即多态）*/
public class MilkTea {
    public String teaName;
    public Ingredient I;

    public MilkTea() {
    }

    public MilkTea(String teaName, Ingredient i) {
        this.teaName = teaName;
        I = i;
    }
    //重写toString方法
    @Override
    public String toString() {
        if(this.I instanceof Bubble)
        return "卖出一杯"+"Bubble"+teaName;
        if(this.I instanceof Coconut)
            return "卖出一杯"+"Coconut"+teaName;
        else
            return "没有这种配料";


    }
}
