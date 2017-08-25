package com.zzz.frames.netty;

import java.nio.charset.Charset;  

import org.jboss.netty.buffer.ChannelBuffer;  
import org.jboss.netty.buffer.ChannelBuffers;  
import org.jboss.netty.channel.ChannelHandlerContext;  
import org.jboss.netty.channel.ChannelStateEvent;  
import org.jboss.netty.channel.ExceptionEvent;  
import org.jboss.netty.channel.MessageEvent;  
import org.jboss.netty.channel.SimpleChannelUpstreamHandler;  

public class TestClientHandler extends SimpleChannelUpstreamHandler {  

  private final String firstMessage;  

  /** 
   * Creates a client-side handler. 
   */  
  public TestClientHandler(String firstMessageSize) {  
      firstMessage = firstMessageSize;  
  }  

  @Override  
  public void channelConnected(  
          ChannelHandlerContext ctx, ChannelStateEvent e) {  
      ChannelBuffer sendBuff = ChannelBuffers.dynamicBuffer();  
      sendBuff.writeBytes(firstMessage.getBytes());  
        
      e.getChannel().write(sendBuff);  
      System.out.println("_____客户端发送信息完成！");  
  }  

  @Override  
  public void messageReceived(  
          ChannelHandlerContext ctx, MessageEvent e) {  
      // Send back the received message to the remote peer.  
      ChannelBuffer acceptBuff = (ChannelBuffer) e.getMessage();  
      String info = acceptBuff.toString(Charset.defaultCharset());  
      System.out.println(info);  
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