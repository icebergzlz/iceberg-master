package top.icebergs.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author iceberg
 * @create 2020-09-27 18:35
 */
@SpringBootApplication
@EnableEurekaServer
public class IcebergEurekaApplication {
    public static void main(String[] args) {
        SpringApplication.run(IcebergEurekaApplication.class,args);
    }
}
