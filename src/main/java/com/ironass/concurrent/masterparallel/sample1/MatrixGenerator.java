package com.ironass.concurrent.masterparallel.sample1;

import java.util.Random;

/**
 * 生成随机矩阵类
 * @author lixin
 * @date 2019-04-25 15:43
 **/
public class MatrixGenerator {

    public static double[][] generate (int rows, int columns) {
        double[][] ret=new double[rows][columns];
        Random random=new Random();
        for (int i=0; i<rows; i++) {
            for (int j=0; j<columns; j++) {
                ret[i][j]=random.nextDouble()*10;
            }
        }
        return ret;
    }
}
