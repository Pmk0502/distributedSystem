import oracle.jrockit.jfr.ActiveSettingEvent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ComputingServerTest {
    Server serverWithoutEnoughtResources;
    Server serverWithEnoughtResources;
    List<Task> tasksToCompute = new ArrayList<>();


    @BeforeEach
    void setUp() {
        serverWithoutEnoughtResources = new Server(1);
        serverWithEnoughtResources = new Server(5);

        List<Operation> operations1 = new ArrayList<>();
        List<Operation> operations2 = new ArrayList<>();
        Operation [] tab1 = { new Operation("pell","5"), new Operation("prime","10")};
        Operation [] tab2 = {new Operation("pell","12"), new Operation("prime","6500")};
        Collections.addAll(operations1, tab1);
        Collections.addAll(operations2, tab2);


        tasksToCompute.add(new Task(operations1));
        tasksToCompute.add(new Task(operations2));
    }

    @Test
    void testComputeTask() {
        ComputingServer cps = new ComputingServer();

       /* cps.setServer(serverWithEnoughtResources);
        Assertions.assertAll(
                () -> Assertions.assertEquals(1907, cps.computeTask(tasksToCompute).getFinalResult()),
                () -> Assertions.assertEquals(0, cps.computeTask(tasksToCompute).getNotComputedTask().size())
        );*/

        cps.setServer(serverWithoutEnoughtResources);
        Assertions.assertAll(
                () -> Assertions.assertEquals(0, cps.computeTask(tasksToCompute).getFinalResult()),
                () -> Assertions.assertEquals(tasksToCompute.size(), cps.computeTask(tasksToCompute).getNotComputedTask().size())
        );

    }

    @Test
    void testAllocateResource() {
       /* ComputingServer cps = new ComputingServer();

        cps.setServer(serverWithoutEnoughtResources);
        Assertions.assertEquals(false, cps.allocateResource(taskToCompute));

        cps.setServer(serverWithEnoughtResources);
        Assertions.assertEquals(true, cps.allocateResource(taskToCompute));*/
    }
}