package com.kirago.redis.command.client.util;

import com.kirago.redis.command.client.config.RedisConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

@Component
public class Command {
    
    @Autowired
    private RedisConfig redisConfig;

    private Socket socket;
    
    private  OutputStream write;
    
    private  InputStream read;
    
    public  String sendCommand(String command) throws IOException{
        write.write(command.toString().getBytes());
        byte[] bytes = new byte[10240000];
        read.read(bytes);
        
        return new String(bytes,"utf-8");
    }
    
    public  String buildCommand(String str){
        if (str != null && !"".equals(str)) {
            String[] strs = str.split(" ");

            StringBuilder builder = new StringBuilder();
            builder.append("*").append(strs.length).append("\r\n");
            for (String str1 : strs) {
                builder.append("$").append(str1.length()).append("\r\n");
                builder.append(str1).append("\r\n");
            }

            return builder.toString();
        }

        return null;
    }
    
    public String getAddress(){
        return redisConfig.address;
    }
    
    public int getPort(){
        return redisConfig.port;
    }
    
    public void setSocket() throws IOException{
        this.socket = new Socket(getAddress(), getPort());
    }
    public Socket getSocket() throws IOException{
        return socket;
    }
    
    public void setWrite() throws IOException{
        this.write = socket.getOutputStream();
    }
    
    public OutputStream getWrite(){
        return write;
    }
    
    public void setRead() throws IOException{
        this.read = socket.getInputStream();
    }
    
    public InputStream getRead(){
        return read;
    }
    
}
