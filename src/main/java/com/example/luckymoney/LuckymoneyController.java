package com.example.luckymoney;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
}
