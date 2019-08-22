package com.thinkingcao.springbootmybatisplus.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fengwenyi.javalib.util.ExceptionUtil;
import com.thinkingcao.springbootmybatisplus.dao.IdcardDao;
import com.thinkingcao.springbootmybatisplus.entity.Idcard;
import com.thinkingcao.springbootmybatisplus.service.MPIdcardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <pre>
 * @desc:
 * @author: cao_wencao
 * @date: 2019-08-21 17:32
 * @version: 1.0
 * </pre>
 */
@Service
@Slf4j
public class IdcardServiceImpl extends ServiceImpl<IdcardDao, Idcard> implements MPIdcardService {

    @Override
    public boolean addIdCard(Idcard idcard) {
        ExceptionUtil.notNull(idcard, "IdCard must not null");
        if (queryIdCardByCode(idcard.getCode()) == null) {
            return save(idcard);
        }
        return true;
    }

    @Override
    public Idcard queryIdCardByCode(String code) {
        ExceptionUtil.notNull(code, "IdCardCode must not null");
        QueryWrapper<Idcard> queryWrapper =
                new QueryWrapper<Idcard>()
                        .eq(Idcard.CODE, code);
        List<Idcard> idCardList = list(queryWrapper);

        if (idCardList == null || idCardList.size() == 0) {
            return null;
        }

        if (idCardList.size() > 1) {
            log.error("queryIdCardByCode有多个返回结果，code={}", code);
        }

        return idCardList.get(0);
    }
}
