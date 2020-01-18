package com.explorati.o2o.exceptions;

/**
 * @ Author : Weijian_Wang
 * @ Date : Created in 21:16 2020/1/14 0014
 * @ Description ：意义在于(可以知道异常是和店铺相关的)
 */
public class ShopOperationException extends RuntimeException{

    public ShopOperationException(String message) {
        super(message);
    }
}
