package cn.youxu.wepy.shop;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cn.youxu.wepy.shop.mapper")
public class WepyShopApplication {
    public static void main(String[] args) {
        SpringApplication.run(WepyShopApplication.class,args);
    }
}
