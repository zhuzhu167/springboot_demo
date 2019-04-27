package cn.ykthink.jewelry.core.config.mysql;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * Author: YK
 * Title: DruidConfig
 * Description: 连接池配置(单源数据库配置使用)
 * Date: 2018/12/24
 * Time: 18:20
 */
@Configuration  //标识该类被纳入spring容器中实例化并管理
@ServletComponentScan //用于扫描所有的Servlet、filter、listener
public class DruidConfig {

    @Bean
    @ConfigurationProperties(prefix="spring.datasource") //加载时读取指定的配置信息,前缀为spring.datasource
    public DataSource druidDataSource() {
        return new DruidDataSource();
    }
}
