import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;

/**
 * SpringBoot启动类
 */
@org.springframework.boot.autoconfigure.SpringBootApplication
@MapperScan(basePackages = "com.mapper")
public class SpringBootApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootApplication.class,args);
    }
}
