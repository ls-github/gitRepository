package cn.ctgu.javaweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class JavawebApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavawebApplication.class, args);
    }

}
