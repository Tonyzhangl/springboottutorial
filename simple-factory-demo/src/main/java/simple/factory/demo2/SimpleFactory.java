package simple.factory.demo2;

/**
* @Description:    工厂类 用于生产具体的实现类
* @Author:         kirago
* @CreateDate:     2019/11/14 11:07 PM
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
public class SimpleFactory {
    public Translate getTranslate(int type) {
        if(type == 1) {
            return new ChineseTranslate();
        }else if (type == 2){
            return new EnglishTranslate();
        }else return null;
    }
}
