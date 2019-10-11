package com.xuexi.concurrency;

import com.xuexi.concurrency.model.Order;
import static com.xuexi.concurrency.util.TaskUtil.dispatchOrderTask;
import static com.xuexi.concurrency.util.TaskUtil.getOrderTask;
import static com.xuexi.concurrency.util.TaskUtil.processOrderTask;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class AsyncBlockingFlow {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // Within 1 flow tasks are dependant on each other, but flows aren't dependant

        // flows executed sequentially, when it aren't dependant
        for (int i = 0; i < 1000; i++) {
            ExecutorService service = Executors.newFixedThreadPool(6);

            Future<Order> future = service.submit(getOrderTask());

            // blocking
            Order order = future.get();

            Future<Order> future1 = service.submit(processOrderTask(order));

            // blocking
            Order processedOrder = future1.get();

            Future<Order> future2 = service.submit(dispatchOrderTask(processedOrder));

            // blocking
            future2.get();

            service.shutdown();
        }
        //flow1, flow2, ..., flowN

        /* We want: flow1, ...
                    flow2, ...
                    flow3, ...
                    flow4, ...
                    flow5, ...
                    flow6, ...
         */
    }
}
