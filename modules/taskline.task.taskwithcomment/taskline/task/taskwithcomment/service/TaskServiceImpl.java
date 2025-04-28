package taskline.task.taskwithcomment;

import java.util.*;

import vmj.routing.route.VMJExchange;

import taskline.task.core.TaskServiceDecorator;
import taskline.task.core.TaskImpl;
import taskline.task.core.TaskServiceComponent;

public class TaskServiceImpl extends TaskServiceDecorator {
    public TaskServiceImpl (TaskServiceComponent record) {
        super(record);
    }

    
}
