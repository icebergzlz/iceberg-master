package top.icebergs.sbadmin;


import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author iceberg
 * @create 2020-09-27 19:04
 */
@SpringBootApplication
@EnableAdminServer   // Spring Boot Admin
public class IcebergSbadminApplication {
    public static void main(String[] args) {
        SpringApplication.run(IcebergSbadminApplication.class,args);
    }
}
