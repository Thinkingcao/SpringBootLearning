package com.thinkingcao.springbootmapstruct.mapper;

import com.thinkingcao.springbootmapstruct.entity.Good;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <pre>
 * @desc: GoodsRepository
 * @author: cao_wencao
 * @date: 2019-11-04 22:58
 * @version: 1.0
 * </pre>
 */
public interface GoodsRepository extends JpaRepository<Good,Integer> {
}
