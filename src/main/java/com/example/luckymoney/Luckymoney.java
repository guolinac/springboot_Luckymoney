package com.example.luckymoney;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;

// 表明这是一个实体类，要与数据库做orm映射，默认表的名字就是类名，表中的字段就是类中的属性
@Entity
public class Luckymoney {
    // 标注用于声明一个实体类的属性映射为数据库的主键列
    @Id
    // 表示自增
    @GeneratedValue
    private Integer id;
    private BigDecimal money;
    // 发送方
    private String produce;
    // 接收方
    private String consumer;

    public Luckymoney() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public String getProduce() {
        return produce;
    }

    public void setProduce(String produce) {
        this.produce = produce;
    }

    public String getConsumer() {
        return consumer;
    }

    public void setConsumer(String consumer) {
        this.consumer = consumer;
    }
}
