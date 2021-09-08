package com.ytg2097.springbootdockerdemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;

@RestController
@SpringBootApplication
public class SpringbootDockerDemoApplication {

    public static void main(String[] args) {

        String path = System.getProperty("user.dir");
        System.out.println("---------- workdir: " + path + " ----------");
        boolean externalProfile = new File(path + File.separator + "application.yml").exists();
        boolean configDirProfile = new File(path + File.separator + "config" + File.separator + "application.yml").exists();
        if (configDirProfile){
            System.out.println("---- 将使用config/下的application.yml");
        }else if (externalProfile){
            System.out.println("---- 将使用jar的同级目录中的application.yml");
        }else {
            System.out.println("---- 将使用jar中的application.yml");
        }
        SpringApplication.run(SpringbootDockerDemoApplication.class, args);
    }

    @Value("${yourName}")
    private String yourName;

    @Value("${meName}")
    private String meName;

    @GetMapping
    public String sayHello(){

        return meName.concat("hello hello ").concat(yourName);
    }

}
