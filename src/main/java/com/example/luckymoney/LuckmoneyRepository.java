package com.example.luckymoney;

        import org.springframework.data.jpa.repository.JpaRepository;

// JpaRepository<Luckymoney, Integer> 第一个参数代表数据库的实体类，第二个参数是ID的类型
public interface LuckmoneyRepository extends JpaRepository<Luckymoney, Integer> {
}