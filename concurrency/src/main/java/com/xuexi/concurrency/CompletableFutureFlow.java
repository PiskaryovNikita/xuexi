package com.xuexi.concurrency;

import com.xuexi.concurrency.util.TaskUtil;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureFlow {

    public static void main(String[] args) {
        // Each flow executed in parallel and doesn't depend on each other
        for (int i = 0; i < 100; i++) {
            CompletableFuture.supplyAsync(TaskUtil::getOrder)
                    .thenApply(TaskUtil::processOrder)
                    .thenApply(TaskUtil::dispatchOrder);
        }
    }

    // ForkJoinPool is default threadPool
}
