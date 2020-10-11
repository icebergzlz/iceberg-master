package top.icebergs.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author iceberg
 * @create 2020-09-28 13:05
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
public class IcebergGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(IcebergGatewayApplication.class,args);
    }
}
