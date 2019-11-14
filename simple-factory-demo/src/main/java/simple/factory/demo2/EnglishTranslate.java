package simple.factory.demo2;

/**
* @Description:    具体实现类2
* @Author:         kirago
* @CreateDate:     2019/11/14 11:05 PM
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
public class EnglishTranslate implements Translate{

    public String sayText(String txt) {
        return "Hello: " + txt;
    }
}
