import com.kirago.ioc.Car;
import com.kirago.ioc.SimpleIoc;
import com.kirago.ioc.Wheel;
import org.junit.Test;

public class SimpleIocTest {

    @Test
    public void getBean() throws Exception {
        String location = SimpleIoc.class.getClassLoader().getResource("ioc.xml").getFile();

        SimpleIoc simpleIoc = new SimpleIoc(location);
        Wheel wheel = (Wheel) simpleIoc.getBean("wheel");
        System.out.println(wheel);
        Car car = (Car) simpleIoc.getBean("car");
        System.out.println(car);
    }

}
