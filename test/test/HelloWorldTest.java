//import mypro.hello.*;         推荐测试类和原来的被测试类(HelloWorld)同包
import junit.framework.*;

public class HelloWorldTest extends TestCase{
    public HelloWorldTest(String name){
        super(name);
        }

    public static void main(String args[]){
        junit.textui.TestRunner.run(HelloWorldTest.class);
        }

    public void testSayHello(){
        HelloWorld world=new HelloWorld();
        assert(world!=null);                                          //当结果是-1时,assert将报错
        assertEquals("Hello World",world.sayHello());
        }
}

