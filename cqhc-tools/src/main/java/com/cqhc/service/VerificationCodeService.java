package com.cqhc.service;

import com.cqhc.domain.VerificationCode;
import com.cqhc.domain.vo.EmailVo;

/**
 * @author jie
 * @date 2018-12-26
 */
public interface VerificationCodeService {

    /**
     * 发送邮件验证码
     * @param code
     */
    EmailVo sendEmail(VerificationCode code);

    /**
     * 验证
     * @param code
     */
    void validated(VerificationCode code);
}
