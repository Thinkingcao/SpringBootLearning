/*
package com.thinkingcao.springboot.ehcache.controller;

import com.thinkingcao.springboot.ehcache.entity.UserEntity;
import com.thinkingcao.springboot.ehcache.repository.UserEntityRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

*/
/**
 * @desc: 用户Controller
 * @author: cao_wencao
 * @date: 2019-12-11 11:18
 *//*

@RestController
@Slf4j
public class UserEntityController {

    @Autowired
    private UserEntityRepository userEntityRepository;

    */
/**
     * @url: http://localhost:8080/saveUserEntity?id=1&userName=曹&passWord=111111
     * @desc: 保存用户
     * @auth: cao_wencao
     * @date: 2019/12/11 11:36
     *//*

    @GetMapping("/saveUserEntity")
    @CachePut(value = "userEntity", key = "#id")
    public UserEntity saveUserEntity(Integer id, String userName, String passWord) {
       // UserEntity userEntity = new UserEntity(id, userName, passWord);
       //  userEntityRepository.save(userEntity);
       //  log.info("新增缓存数据：{}", JSONObject.toJSONString(userEntity));
       //  return userEntity;
        return null;
    }

    */
/**
     * @url: http://localhost:8080/queryUserEntity?id=1
     * @desc: 根据id查询单个用户
     * @auth: cao_wencao
     * @date: 2019/12/11 11:36
     *//*

    @GetMapping("/queryUserEntity")
    @Cacheable(value = "userEntity", key = "#id")
    public UserEntity queryUserEntity(Integer id) {
        UserEntity userEntity = userEntityRepository.findById(id).get();
        log.info("查询了缓存数据，key为：{}", id);
        return userEntity;
    }

    */
/**
     * @url: http://localhost:8888/deleteHouse?id=1
     * @desc: 根据id删除单个用户
     * @auth: cao_wencao
     * @date: 2019/12/11 11:36
     *//*

    @GetMapping("/deleteuserEntity")
    @CacheEvict(value = "userEntity", key = "#id")
    public String deleteuserEntity(Integer id) {
        userEntityRepository.deleteById(id);
        log.info("删除了缓存数据，key为：{}", id);
        return "success";
    }

    */
/**
     * @url: http://localhost:8888/deleteCache
     * @desc: 删除缓存
     * @auth: cao_wencao
     * @date: 2019/12/11 11:36
     *//*

    @GetMapping("/deleteCache")
    @CacheEvict(value = "userEntity", allEntries = true)
    public void deleteCache() {

    }

}
*/
