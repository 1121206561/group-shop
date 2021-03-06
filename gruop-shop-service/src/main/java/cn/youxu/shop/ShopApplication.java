package cn.youxu.shop;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cn.youxu.shop.mapper")
@EnableDubbo 
public class ShopApplication {
    public static void main(String[] args) {
        SpringApplication.run(ShopApplication.class,args);
    }
}
