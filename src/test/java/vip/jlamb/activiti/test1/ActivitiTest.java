package vip.jlamb.activiti.test1;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ActivitiTest {

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private TaskService taskService;

    @Test
    public void test1(){
        Map<String, Object> param = new HashMap<>();
        System.out.println(runtimeService);
        param.put("assigneeList", Arrays.asList("zs", "ls", "ww"));
        ProcessInstance huiqian = runtimeService.startProcessInstanceByKey("myProcess_1", param);
        Map<String, Object> processVariables = huiqian.getProcessVariables();
        System.out.println(processVariables);
    }
    @Test
    public void test2(){
        //查询任务
        List<Task> list = taskService.createTaskQuery().taskCandidateOrAssigned("ww").list();
        for (Task task : list) {
            System.out.println(task.getId());
            Map<String, Object> param = new HashMap<>();
            param.put("pass", true);
            //完成任务
            taskService.complete(task.getId(), param);
        }
        list = taskService.createTaskQuery().taskCandidateOrAssigned("zs").list();
        System.out.println(list);
        list = taskService.createTaskQuery().taskCandidateOrAssigned("ww").list();
        System.out.println(list);
    }


}
