package com.xuexi.concurrency;

import com.xuexi.concurrency.model.Order;
import static com.xuexi.concurrency.util.TaskUtil.*;

public class BlockingFlow {

    public static void main(String[] args) throws Exception {
        // users/another services send req to perform defined flow
        for (int i = 0; i < 100; i++) {
            // sync
            Order order = getOrderTask().call();
            Order processedOrder = processOrderTask(order).call();
            dispatchOrderTask(processedOrder).call();
        }
    }
}
