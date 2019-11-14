package factory.method.demo1;

/**
* @Description:    具体工厂类的实现
* @Author:         kirago
* @CreateDate:     2019/11/14 11:48 PM
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
public class EnglishFactoryMethod implements FactoryMethod{

    public Translate factoryMethod() {
        return new EnglishTranslate();
    }
}
