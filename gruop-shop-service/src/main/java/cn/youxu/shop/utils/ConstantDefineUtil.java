package cn.youxu.shop.utils;

import lombok.Data;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "tengxun")
@Data
public class ConstantDefineUtil implements InitializingBean {
    //读取配置文件中的数据
    private String cos_secretid;
    private String cos_secretkey;
    private String cos_region;
    private String bucket_name;

    //定义常量
    public static String COS_SECRETID;
    public static String COS_SECRETKEY;
    public static String COS_REGION;
    public static String BUCKETNAME;


    @Override
    public void afterPropertiesSet() throws Exception {
        //给常量赋值
        COS_SECRETID = cos_secretid;
        COS_SECRETKEY = cos_secretkey;
        COS_REGION = cos_region;
        BUCKETNAME = bucket_name;
    }
}
