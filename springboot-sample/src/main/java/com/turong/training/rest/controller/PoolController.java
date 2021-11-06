package com.turong.training.rest.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.stream.IntStream;

@RestController
@RequestMapping("/pool")
@Slf4j
public class PoolController {

    private static final int TIMES = 100;

    @Autowired
    @Qualifier("poolExecutor")
    private ThreadPoolTaskExecutor poolExecutor;

    @PostMapping("/api/{id}")
    public ResponseEntity<String> sync(@PathVariable final String id) {
        log.debug("Sync user with id={}", id);

        long start = System.currentTimeMillis();
        IntStream.range(0, TIMES).forEach(i -> {
            try {
                Thread.sleep(500L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        long totalCost = System.currentTimeMillis() - start;
        log.info("finished sync cost: {}ms", totalCost);

        return ResponseEntity.ok(String.format("OK, cost: %s(ms)", totalCost));

    }

    @PostMapping("/api/async/{id}")
    public ResponseEntity<String> getUser(@PathVariable final String id) throws ExecutionException, InterruptedException {
        log.debug("Do async user with id={}", id);

        long start = System.currentTimeMillis();
        List<Future<Boolean>> res = new ArrayList<>();
        IntStream.range(0, TIMES).forEach(i -> {

            res.add(poolExecutor.submit(() -> {
                try {
                    Thread.sleep(500L);
                    return true;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return false;
            }));

        });
        for (Future<Boolean> future : res) {
            future.get(); // get will block until the future is done
        }

        boolean allDone = res.stream().allMatch(Future::isDone);

        long totalCost = System.currentTimeMillis() - start;
        log.info("finished async allDone={}, cost: {}ms", allDone, totalCost);

        return ResponseEntity.ok(String.format("OK, cost: %s(ms)", totalCost));
    }

}
