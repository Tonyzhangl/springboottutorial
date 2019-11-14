package simple.factory.demo1;
/**
* @Description:    简单工厂模式的抽离出来的产品类用于初始化动作
* @Author:         kirago
* @CreateDate:     2019/11/14 10:47 PM
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
public class Product {
    private double num;
    private double price;
    private double rebate;

    private double total;

    public void setNum(double num) {
        this.num = num;
    }

    public void setPrice(double price){
        this.price = price;
    }

    public void setRebate(double rebate) {
        this.rebate = rebate;
    }

    public double getNum() {
        return num;
    }

    public double getPrice() {
        return price;
    }

    public double getRebate() {
        return rebate;
    }

    public double getTotal() {
        return num*price*rebate;
    }
}
