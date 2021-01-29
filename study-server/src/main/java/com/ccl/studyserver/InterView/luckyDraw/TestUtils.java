package com.ccl.studyserver.InterView.luckyDraw;


import java.util.function.Supplier;

public class TestUtils {

    private TestUtils(){}

    /**
     * 正常执行 Runnable 函数, 打印 执行 Runnable 函数的执行时长信息
     *
     * @param tag 标记
     * @param runnable 执行函数
     */
    public static void callTime(String tag, Runnable runnable) {
        callTime(tag, () -> {
            runnable.run();
            return true;
        });
    }

    /**
     * 正常执行 supplier 函数, 打印 执行 supplier 函数的执行时长信息
     *
     * @param tag 标记
     * @param supplier 执行函数
     * @param <R> 执行函数返回值类型
     * @return 执行函数的返回值
     */
    public static <R> R callTime(String tag, Supplier<R> supplier) {
        long start = System.nanoTime();
        R r = supplier.get();
        long inVal = System.nanoTime() - start;
        return r;
    }
}
