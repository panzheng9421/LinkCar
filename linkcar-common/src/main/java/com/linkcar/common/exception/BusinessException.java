package com.linkcar.common.exception;

import com.linkcar.common.enums.ResponsCode;
import lombok.Getter;

/**
 * @author panzheng
 * @description 异常处理
 * @date 2019/8/20 11:17
 */
@Getter
public class BusinessException extends RuntimeException {

    private static final long serialVersionUID = 7569171483205676813L;

    private ResponsCode code;

    /**
     * 仅包含code, 没有cause, 也不记录栈异常, 性能最高
     *
     * @param code
     */
    public BusinessException(ResponsCode code) {
        this(code, false);
    }

    /**
     * 包含message, 可指定是否记录异常
     *
     * @param code
     * @param recordStackTrace
     */
    public BusinessException(ResponsCode code, boolean recordStackTrace) {
        super(code.desc(), null, false, recordStackTrace);
        this.code = code;
    }

    /**
     * 包含message和cause, 会记录栈异常
     *
     * @param code
     * @param cause
     */
    public BusinessException(ResponsCode code, Throwable cause) {
        super(code.desc(), cause, false, true);
    }
}
