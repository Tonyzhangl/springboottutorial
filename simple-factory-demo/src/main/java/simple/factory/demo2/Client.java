package simple.factory.demo2;

/**
* @Description:    客户端调用
* @Author:         kirago
* @CreateDate:     2019/11/14 11:09 PM
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
public class Client {
    public static void main(String[] args) {
        SimpleFactory simpleFactory = new SimpleFactory();
        Translate translate = simpleFactory.getTranslate(1);
        System.out.println(translate.sayText("666"));

    }
}
