import com.kirago.aop.*;
import org.junit.Test;

public class SimpleAopTest {

    @Test
    public void getProxy() throws Exception {
        //1.创建一个 MethodInvocation 实现类
        MethodInvocation logTask = () -> System.out.println("log task start");
        HelloServiceImpl helloService = new HelloServiceImpl();

        //2.创建一个 Advice
        Advice beforeAdvice = new BeforeAdvice(helloService, logTask);

        //3.为目标对象生成代理
        HelloService helloServiceImplProxy = (HelloService) SimpleAop.getProxy(helloService,beforeAdvice);

        helloServiceImplProxy.sayHello();
    }
}
