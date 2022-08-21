package com.example.luckymoney;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
public class LuckymoneyController {
    @Autowired
    private LuckmoneyRepository repository;

    // 获取红包列表
    @GetMapping("/luckymoneys")
    public List<Luckymoney> list() {
        // findAll()查询所有Luckymoney列表
        return repository.findAll();
    }

    // 创建红包(发红包)
    @PostMapping("/luckymoney")
    // @RequestParam("producer") String producer请求参数，谁创建的红包，发了多少钱
    public Luckymoney create(@RequestParam("produce") String produce,
                             @RequestParam("money") BigDecimal money) {
        Luckymoney luckymoney = new Luckymoney();
        luckymoney.setProduce(produce);
        luckymoney.setMoney(money);
        return repository.save(luckymoney);
    }

    // 通过ID查询红包
    @GetMapping("/luckymoneys/{id}")
    public Luckymoney findById(@PathVariable("id") Integer id) {
        // orElse(null) 如果查不到，就返回null
        return repository.findById(id).orElse(null);
    }

    // 更新红包(领红包)
    @PutMapping("/luckymoneys/{id}")
    // 更新的是comsumer，谁领了红包，传入id是因为id是主键，要通过主键定位
    public Luckymoney update(@PathVariable("id") Integer id,
                             @RequestParam("consumer") String consumer) {
        // 先把要更新的数据查询出来
        Optional<Luckymoney> optional= repository.findById(id);
        // 如果有内容，再执行更新的操作
        if (optional.isPresent()) {
            Luckymoney luckymoney = optional.get();
            // 查出来以后再更新
            luckymoney.setConsumer(consumer);
            return repository.save(luckymoney);
        }

        return null;
    }
}
