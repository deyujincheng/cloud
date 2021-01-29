package com.ccl.studyserver.InterView.luckyDraw;


import java.nio.charset.Charset;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class Test {

    public static void main(String[] args) {
        System.out.println(Charset.defaultCharset().name());
        AbstractLotteryMachine lotteryMachine = new AtomicLotteryMachine();
        System.out.println("未抽奖之前奖池情况" + lotteryMachine.toString());

        AtomicInteger t1 = new AtomicInteger();
        AtomicInteger t2 = new AtomicInteger();
        AtomicInteger t5 = new AtomicInteger();
        AtomicInteger tM = new AtomicInteger();

        TestUtils.callTime("抽奖测试", () -> {
            // 30000 次并发可以抽空奖池
            IntStream.range(1, 30000).parallel().forEach(it -> {
                final int lottery = lotteryMachine.lottery();
                switch (lottery) {
                    case 1:
                        t1.addAndGet(1);
                        tM.addAndGet(1);
                        break;
                    case 2:
                        t2.addAndGet(1);
                        tM.addAndGet(2);
                        break;
                    case 5:
                        t5.addAndGet(1);
                        tM.addAndGet(5);
                        break;
                    case 0:
                        break;
                    default:
                        throw new RuntimeException("default");
                }
            });
        });

        System.out.println("抽奖之后奖池情况" + lotteryMachine.toString());
        System.out.println("1元奖券出现次数 " + t1);
        System.out.println("2元奖券出现次数 " + t2);
        System.out.println("5元奖券出现次数 " + t5);
        System.out.println("抽奖金额 " + tM);
    }
}
