package com.ay.uf;

/**
 * @author ay
 * @create 2020-01-08 15:44
 */
public interface UF {

    int getSize();
    boolean isConnected(int p, int q);
    void unionElements(int p, int q);
}