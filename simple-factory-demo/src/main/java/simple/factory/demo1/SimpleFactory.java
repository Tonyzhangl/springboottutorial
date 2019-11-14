package simple.factory.demo1;

/**
* @Description:    抽离出来的简单工厂类
* @Author:         kirago
* @CreateDate:     2019/11/14 10:52 PM
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
public class SimpleFactory {
    /**
     * 简单工厂模式又叫静态工厂模式
     * @param num
     * @param price
     * @param rebate
     * @return
     */
    public static double getTotal(double num, double price, double rebate) {
        Product product = new Product();
        product.setNum(num);
        product.setPrice(price);
        product.setRebate(rebate);

        return product.getTotal();
    }
}
