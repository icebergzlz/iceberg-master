package top.icebergs.upload;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author iceberg
 * @create 2020-09-28 9:31
 */
@SpringBootApplication
@EnableDiscoveryClient
public class IcebergUploadApplication {
    public static void main(String[] args) {
        SpringApplication.run(IcebergUploadApplication.class,args);
    }
}
