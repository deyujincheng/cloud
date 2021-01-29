package com.ccl.studyserver.InterView.luckyDraw;


import java.util.concurrent.atomic.AtomicInteger;

public class AtomicLotteryMachine extends AbstractLotteryMachine {

    /**
     * 1元奖票数量
     */
    private final AtomicInteger ticketNumber1 = new AtomicInteger(10000);
    private final AtomicInteger ticketNumber2 = new AtomicInteger(20000);
    private final AtomicInteger ticketNumber5 = new AtomicInteger(2000);

    /**
     * 奖金池
     */
    private final AtomicInteger ticketMoneyTotal = new AtomicInteger(50000);

    /**
     * 占据一张奖票(1元)
     *
     * @return 是否占用成功
     */
    @Override
    protected boolean occupyMoney1() {
        final int andDecrement = ticketNumber1.getAndDecrement();
        if (andDecrement > 0) {
            return true;
        }
        releaseMoney1();
        return false;
    }

    /**
     * 占据一张奖票(2元)
     *
     * @return 是否占用成功
     */
    @Override
    protected boolean occupyMoney2() {
        final int andDecrement = ticketNumber2.getAndDecrement();
        if (andDecrement > 0) {
            return true;
        }
        releaseMoney2();
        return false;
    }

    /**
     * 占据一张奖票(5元)
     *
     * @return 是否占用成功
     */
    @Override
    protected boolean occupyMoney5() {
        final int andDecrement = ticketNumber5.getAndDecrement();
        if (andDecrement > 0) {
            return true;
        }
        releaseMoney5();
        return false;
    }


    /**
     * 占据金额(若余额高于5元, 优先则占据5元, 否则若高于2元, 优先占据2元, 否则若高于1元, 则占据1元, 否则不占据任何金额, 返回0)
     *
     * @return 占据金额
     */
    @Override
    protected int occupyMoneyTotal() {
        final int i = ticketMoneyTotal.get();
        if (i <= 0) {
            return 0;
        }
        final int andAdd = ticketMoneyTotal.addAndGet(-5);
        if (andAdd >= 0) {
            return 5;
        }
        if (andAdd >= -3) {
            releaseMoneyTotal(3);
            return 2;
        }
        if (andAdd >= -4) {
            releaseMoneyTotal(4);
            return 1;
        }
        releaseMoneyTotal(5);
        return 0;
    }

    /**
     * 释放一张奖票(1元)
     */
    @Override
    protected void releaseMoney1() {
        ticketNumber1.getAndIncrement();
    }

    /**
     * 释放一张奖票(2元)
     */
    @Override
    protected void releaseMoney2() {
        ticketNumber2.getAndIncrement();
    }

    /**
     * 释放一张奖票(5元)
     */
    @Override
    protected void releaseMoney5() {
        ticketNumber5.getAndIncrement();
    }

    /**
     * 释放金额
     *
     * @param money 释放金额
     */
    @Override
    protected void releaseMoneyTotal(int money) {
        ticketMoneyTotal.getAndAdd(money);
    }
}
