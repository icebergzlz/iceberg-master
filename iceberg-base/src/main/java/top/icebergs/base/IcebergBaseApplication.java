package top.icebergs.base;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author iceberg
 * @create 2020-09-27 18:53
 */
@SpringBootApplication
@EnableDiscoveryClient
public class IcebergBaseApplication {
    public static void main(String[] args) {
        SpringApplication.run(IcebergBaseApplication.class,args);
    }
}
