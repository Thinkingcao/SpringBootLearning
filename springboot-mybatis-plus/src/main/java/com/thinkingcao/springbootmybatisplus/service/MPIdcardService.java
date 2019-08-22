package com.thinkingcao.springbootmybatisplus.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.thinkingcao.springbootmybatisplus.entity.Idcard;

/**
 * <pre>
 * @desc:
 * @author: cao_wencao
 * @date: 2019-08-21 17:42
 * @version: 1.0
 * </pre>
 */
public interface MPIdcardService extends IService<Idcard> {

    boolean addIdCard(Idcard idcard);

    Idcard queryIdCardByCode(String code);

}
