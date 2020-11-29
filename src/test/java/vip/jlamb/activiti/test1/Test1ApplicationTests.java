package vip.jlamb.activiti.test1;

import org.activiti.engine.RuntimeService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Test1ApplicationTests {

    @Autowired
    private RuntimeService runtimeService;

    @Test
    public void contextLoads() {
        System.out.println(runtimeService);
    }

}
