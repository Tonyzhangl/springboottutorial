package simple.factory.demo1;

/**
* @Description:    客户端调用
* @Author:         kirago
* @CreateDate:     2019/11/14 10:55 PM
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
public class Client {
    public static void main(String[] args) {
        double r = SimpleFactory.getTotal(1,1,1);
        System.out.println(r);
    }
}
