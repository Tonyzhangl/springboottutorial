package factory.method.demo1;

/**
* @Description:    工厂类的具体实现
* @Author:         kirago
* @CreateDate:     2019/11/14 11:47 PM
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
public class ChineseFactoryMethod implements FactoryMethod {

    public Translate factoryMethod() {
        return new ChineseTranslate();
    }
}
