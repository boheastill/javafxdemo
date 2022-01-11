package cn.i623.alpha.javafxdemo.db;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan
@SpringBootApplication
public class TjSqlBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(TjSqlBootApplication.class, args);
    }

}
