package com.ccl.studyserver.InterView.luckyDraw;

import java.util.Random;

public abstract class AbstractLotteryMachine {

    private final Random random = new Random();
    // 抽奖概率, 1元, 2元, 5元的概率比重为 22:44:4
    private final int[] probability = new int[]{22, 44, 4};

    /**
     * 抽奖方法
     *
     * @return 抽奖金额(1: 1元, 2: 2元, 5: 5元, 0: 没奖了)
     */
    public int lottery() {
        boolean et1 = false;
        boolean et2 = false;
        boolean et5 = false;
        int occupyMoney = 0;
        int money = 0;
        try {
            occupyMoney = occupyMoneyTotal();
            if (occupyMoney == 0) {
                return money;
            }
            assert occupyMoney > 0;
            et1 = occupyMoney1();
            et2 = occupyMoney2();
            et5 = occupyMoney5();
            money = randomMoney(et1, et2, et5, occupyMoney);
            assert money <= occupyMoney;
            return money;
        } catch (RuntimeException e){
            throw e;
        } finally {
            if (et1 && money != 1) {
                releaseMoney1();
            }
            if (et2 && money != 2) {
                releaseMoney2();
            }
            if (et5 && money != 5) {
                releaseMoney5();
            }
            assert occupyMoney >= money;
            if (occupyMoney > 0) {
                final int releaseMoney = occupyMoney - money;
                releaseMoneyTotal(releaseMoney);
            }
        }
    }

    /**
     * 10000张1元 + 20000张2元 刚好等于 50000, 也就是说最优的情况是刚好抽奖抽了10000张1元 和 20000张2元,
     * 5元的奖券抽中的次数越少越节约成本, 1元, 2元的券之间概率调整没什么意义
     *
     * @param et1         1元奖券是否存在
     * @param et2         2元奖券是否存在
     * @param et5         5元奖券是否存在
     * @param occupyMoney 占据金额
     * @return 抽取的奖券 0:没有合适的奖券了, 1: 1元, 2: 2元, 5: 5元
     */
    protected int randomMoney(boolean et1, boolean et2, boolean et5, int occupyMoney) {
        int number = 0;
        if (et1 && occupyMoney >= 1) {
            number += probability[0];
        }
        if (et2 && occupyMoney >= 2) {
            number += probability[1];
        }
        if (et5 && occupyMoney >= 5) {
            number += probability[2];
        }
        if (number == 0) {
            return 0;
        }
        int rdm = random.nextInt(number);
        if (et1 && occupyMoney >= 1) {
            if (rdm < probability[0]) {
                return 1;
            }
            rdm -= probability[0];
        }
        if (et2 && occupyMoney >= 2) {
            if (rdm < probability[1]) {
                return 2;
            }
            rdm -= probability[1];
        }
        if (et5 && occupyMoney >= 5 && rdm < probability[2]) {
            return 5;
        }
        throw new RuntimeException("计算异常");
    }

    /**
     * 占据一张奖票(1元)
     *
     * @return 是否占用成功
     */
    protected abstract boolean occupyMoney1();

    /**
     * 占据一张奖票(2元)
     *
     * @return 是否占用成功
     */
    protected abstract boolean occupyMoney2();

    /**
     * 占据一张奖票(5元)
     *
     * @return 是否占用成功
     */
    protected abstract boolean occupyMoney5();

    /**
     * 占据金额(若余额高于5元, 优先则占据5元, 否则若高于2元, 优先占据2元, 否则若高于1元, 则占据1元, 否则不占据任何金额, 返回0)
     *
     * @return 占据金额
     */
    protected abstract int occupyMoneyTotal();

    /**
     * 释放一张奖票(1元)
     */
    protected abstract void releaseMoney1();

    /**
     * 释放一张奖票(2元)
     */
    protected abstract void releaseMoney2();

    /**
     * 释放一张奖票(5元)
     */
    protected abstract void releaseMoney5();

    /**
     * 释放金额
     * @param money 释放金额
     */
    protected abstract void releaseMoneyTotal(int money);


}
