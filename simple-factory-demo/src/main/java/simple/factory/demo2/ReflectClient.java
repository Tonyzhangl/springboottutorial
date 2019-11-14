package simple.factory.demo2;

/**
* @Description:    调用反射生成的实类
* @Author:         kirago
* @CreateDate:     2019/11/14 11:18 PM
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
public class ReflectClient {
    public static void main(String[] args) {
        ReflectSimpleFactory reflectSimpleFactory = new ReflectSimpleFactory();
        Translate translate = reflectSimpleFactory.getTranslate("ChineseTranslate");
        System.out.println(translate.sayText("666"));
    }
}
