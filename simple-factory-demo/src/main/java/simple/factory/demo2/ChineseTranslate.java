package simple.factory.demo2;

/**
* @Description:    具体实现类
* @Author:         kirago
* @CreateDate:     2019/11/14 11:03 PM
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
public class ChineseTranslate implements Translate{

    public String sayText(String txt) {
        return "您好: " + txt;
    }
}
