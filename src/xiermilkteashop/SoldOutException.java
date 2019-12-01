package xiermilkteashop;
/*在出售奶茶时，如果发现其配料过期应将其从列表中移除。如售完（即该种配料
        用完）需要告知顾客(抛出一个异常并捕获处理这个异常)，如果成功卖出去需要
        将使用的配料从列表中移除*/
public class SoldOutException extends Exception {
    public SoldOutException() {
    }

    public SoldOutException(String message) {
        super(message);
    }
}
