package com.kirago.redis.command.client;

import com.kirago.redis.command.client.util.Command;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

@SpringBootApplication
public class RedisCommandClientApplication {

    public static void main(String[] args) throws IOException {
        ApplicationContext context =  SpringApplication.run(RedisCommandClientApplication.class, args);
        
        Command command = context.getBean(Command.class);
        System.out.println("【请输入正确的命令】: \r\n");
        
        Scanner scanner = new Scanner(System.in);
        
        while (scanner.hasNextLine()){
            String str = scanner.nextLine();
            
            // 构造协议
            String comclient = command.buildCommand(str);
            System.out.println("【发送命令为】：\r\n " + comclient);
            
            String result = command.sendCommand(comclient);
            System.out.println("【响应命令为】：\r\n " + result);
        }
        scanner.close();
    }
    

}
