package com.example.luckymoney;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
// @Service注解用于类上，标记当前类是一个service类，加上该注解会将当前类自动注入到spring容器中，不需要再在applicationContext.xml文件定义bean了
public class LuckymoneyService {
    @Autowired
    private LuckmoneyRepository repository;

    // 事务 指数据库事务 数据库引擎要更换成InnoDB才支持事务
    // 可以用于 扣库存 > 创建订单 的同时性
    @Transactional
    // 事务注解
    public void createTwo() {
        Luckymoney luckymoney1 = new Luckymoney();
        luckymoney1.setProduce("熊大");
        luckymoney1.setMoney(new BigDecimal(520));
        repository.save(luckymoney1);

        Luckymoney luckymoney2 = new Luckymoney();
        luckymoney2.setProduce("熊大");
        luckymoney2.setMoney(new BigDecimal(1314));
        repository.save(luckymoney2);
    }
}
