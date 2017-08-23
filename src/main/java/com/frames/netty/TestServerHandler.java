package com.frames.netty;


import java.nio.charset.Charset;  
 
import org.jboss.netty.buffer.ChannelBuffer;  
import org.jboss.netty.buffer.ChannelBuffers;  
import org.jboss.netty.channel.ChannelHandlerContext;  
import org.jboss.netty.channel.ExceptionEvent;  
import org.jboss.netty.channel.MessageEvent;  
import org.jboss.netty.channel.SimpleChannelUpstreamHandler;  
 
 
/** 
* Handler implementation for the echo server. 
*/  
public class TestServerHandler extends SimpleChannelUpstreamHandler {  
 
   @Override  
   public void messageReceived(  
           ChannelHandlerContext ctx, MessageEvent e) {  
       // Send back the received message to the remote peer.  
       ChannelBuffer acceptBuff = (ChannelBuffer) e.getMessage();  
       String info = acceptBuff.toString(Charset.defaultCharset());  
       if(info != null && !"".equals(info)) {  
           System.out.println("_______服务端接收到>>>>>"+info);  
           ChannelBuffer sendBuff = ChannelBuffers.dynamicBuffer();  
           sendBuff.writeBytes("_______服务端已接收到信息！".getBytes());  
           e.getChannel().write(sendBuff);  
       } else {  
           e.getChannel().write("_______服务端没有接收到信息！");  
       }  
       e.getChannel().close();  
   }  
 
   @Override  
   public void exceptionCaught(  
           ChannelHandlerContext ctx, ExceptionEvent e) {  
       // Close the connection when an exception is raised.  
       e.getCause();  
       e.getChannel().close();  
   }  
}  