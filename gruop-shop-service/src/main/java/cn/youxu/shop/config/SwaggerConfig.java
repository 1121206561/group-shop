package cn.youxu.shop.config;

import org.springframework.context.annotation.Bean;
import springfox.documentation.service.Contact;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    //配置swagger2 swagger2是一个接口文档,更好地帮助前后端分离,和调用接口得到数据
    @Bean
    public Docket webApiConfig() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("webApi")
                .apiInfo(webApiInfo())
                .select()
                .build();
    }

    private ApiInfo webApiInfo() {
        return new ApiInfoBuilder()
                .title("网站-社区团购API文档")
                .description("本文档描述了社区团购服务接口定义")
                .version("1.0")
                .contact(new Contact("YuHaoJun", "www.yuhaojun.xyz", "1121206561@qq.com"))
                .build();
    }
}
