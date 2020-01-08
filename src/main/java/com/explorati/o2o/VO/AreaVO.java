package com.explorati.o2o.VO;

import lombok.Data;

/**
 * @ Author : Weijian_Wang
 * @ Date : Created in 16:27 2020/1/7 0007
 * @ Description ：
 */
@Data
public class AreaVO<T> {

    private Integer code;

    private String msg;

    private T data;
}
