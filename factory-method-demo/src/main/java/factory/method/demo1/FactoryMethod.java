package factory.method.demo1;

/**
* @Description:    这边是和简单工厂模式的区别，简单工厂方法是直接通过工厂类中做了条件判断来直接生成实类的，
*                  那么当工厂中创建实类的区别很大且很复杂的时候
*                  此时将动作全部塞到工厂类中就使得工厂类及其的臃肿，此时的做法是将工厂类进一步抽象出接口，然后
*                  对每个工厂类再进行具体工厂类的实现来进一步拆分实现
*                  最主要的区分点就是每个工厂实类是否有较大的区别，是否值得去抽象一个工厂接口来提供各个工厂的具体实现化。
* @Author:         kirago
* @CreateDate:     2019/11/14 11:42 PM
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
public interface FactoryMethod {
    // 进一步抽象工厂类 提供一个抽象接口，此接口用于说明工厂是生产Translate对象的
    Translate factoryMethod();
}
