package com.chao.practice.facade.exception;

import com.chao.practice.common.exception.BaseBusinessException;

/**
 * Created by 15313 on 2019/12/4.
 */
public class CyBusinessException extends BaseBusinessException {
    public CyBusinessException(String msg, String code, Throwable ex, String jsonContent) {
        super(msg, code, ex, jsonContent);
    }

    public CyBusinessException(String msg, String code, String jsonContent) {
        super(msg, code, jsonContent);
    }

    public CyBusinessException(String msg, String code) {
        super(msg, code);
    }

}
