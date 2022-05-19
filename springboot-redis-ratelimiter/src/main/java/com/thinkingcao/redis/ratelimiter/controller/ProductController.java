package com.thinkingcao.redis.ratelimiter.controller;

import com.google.common.collect.Lists;
import com.thinkingcao.redis.ratelimiter.annotation.RateLimiter;
import com.thinkingcao.redis.ratelimiter.enums.RateLimiterEnum;
import com.thinkingcao.redis.ratelimiter.response.HealthResponse;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @desc: 以商品库存为例子做测试,3分钟内最大访问次数为3次,但在实际商品项目应用场景并不会做限流操作，请以实际应用场景为准
 * @author: cao_wencao
 * @date: 2022-05-18 21:40
 */
@Slf4j
@RestController
@RequestMapping(value = "/product",produces = "application/json;charset=UTF-8")
public class ProductController implements InitializingBean {

    private static final List<ProductEntity> productLists = Lists.newArrayList();

    /**
     * 健康检查
     * @return
     */
    @GetMapping("hs")
    public HealthResponse hs() {
        HealthResponse response = new HealthResponse();
        response.setStatus(HealthResponse.HEALTHY_STATUS);
        return response;
    }

    /**
     * 查询商品库存数据
     * @param productCode
     * @return
     */
    @GetMapping("/queryProducts")
    @RateLimiter(lockTime = 5, maxCount = 3,limitType = RateLimiterEnum.DEFAULT)
    public ResponseEntity<List<ProductEntity>> queryProducts(@RequestParam("productCode") Integer productCode,@RequestParam("userId") Integer userId){
        Assert.notNull(userId,"args userId can not be empty please check request");
        Assert.notNull(productCode,"args productCode can not be empty please check request");
        //贷款金额
        BigDecimal loanAmount = new BigDecimal("15000.48");
        log.info("贷款金额货币格式化测试: {}", NumberFormat.getCurrencyInstance().format(loanAmount));
        List<ProductEntity> matchProducts = productLists.stream()
                .filter(item -> productCode.longValue() == item.productCode)
                .collect(Collectors.toList());
        System.out.println("匹配到符合相应productCode的商品信息为 =" + matchProducts);
        return ResponseEntity.ok(productLists.stream()
                .filter(item -> productCode.longValue() == item.productCode)
                .collect(Collectors.toList()));
    }


    /**
     * 方式1：
     */
    //static {
    //    log.info("static代码块开始初始化商品库存数据productLists.............");
    //    for (int i = 0; i < 5; i++) {
    //        productLists.add(ProductEntity.builder()
    //                .productCode(10000L+i)
    //                .productName("杨枝甘露" + i)
    //                .productPrice(NumberFormat.getCurrencyInstance().format(new BigDecimal("15").add(new BigDecimal(i))))
    //                .productNum(100+i)
    //                .build());
    //    }
    //}

    /**
     * 方式2：
     */
    //@PostConstruct
    //private void initProductStock(){
    //    log.info("PostConstruct开始初始化商品库存数据productLists......................");
    //    for (int i = 0; i < 5; i++) {
    //        productLists.add(ProductEntity.builder()
    //                .productCode(10000L+i)
    //                .productName("杨枝甘露")
    //                .productPrice(NumberFormat.getCurrencyInstance().format(new BigDecimal("15").add(new BigDecimal(i))))
    //                .productNum(100+i)
    //                .build());
    //    }
    //}


    /**
     * 方式3：
     */
    @Override
    @SneakyThrows
    public void afterPropertiesSet(){
        log.info("InitializingBean.afterPropertiesSet开始初始化商品库存数据productLists.............");
        for (int i = 0; i < 5; i++) {
            productLists.add(ProductEntity.builder()
                    .productCode(10000L+ i)
                    .productName("杨枝甘露" + i)
                    .productPrice(NumberFormat.getCurrencyInstance().format(new BigDecimal("15").add(new BigDecimal(i))))
                    .productNum(100+i)
                    .build());
        }
    }

    @Getter
    @Setter
    @Builder
    public static class ProductEntity{
        private Long productCode;
        private String productName;
        private String productPrice;
        private Integer productNum;
    }

}
