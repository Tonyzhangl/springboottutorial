package simple.factory.demo2;

/**
* @Description:    为避免过多的if-else，通过反射来进行工厂实类的生成
* @Author:         kirago
* @CreateDate:     2019/11/14 11:13 PM
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
public class ReflectSimpleFactory {
    public Translate getTranslate(String type) {
        Translate translate = null;
        try {
            //实现这部分内容还得提前能够将两种 Translate 加载进去 才能对 Class 实例化
            // TODO
            translate = (Translate) Class.forName(type).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return translate;
    }
}
