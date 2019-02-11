package com.ironass.currentlimiter.demo;

/**
 * @author lixin
 * @date 2019-02-11 18:02
 **/
public class LeackBucket {

    /**
     * 起始时间
     */
    private static long startTime = System.currentTimeMillis();
    /**
     * 流出速率 /ms
     */
    private static long speed = 20;
    /**
     * 桶的容量
     */
    private static long maxCount = 100;
    private static long nowCount = 0;

    public static boolean isAccess() {
        long nowTime = System.currentTimeMillis();
        long outCount = (nowTime - startTime) * speed;
        // 流出数量
        startTime = nowTime;
        // 更新
        nowCount = nowCount - outCount <= 0 ? 0 : nowCount - outCount;
        if (nowCount < maxCount) {
            nowCount++;
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 500; i++) {
            if (isAccess()) {
                System.out.println("业务顺利执行...");
            } else {
                System.out.println("业务被丢弃---");
            }
        }
    }

}
