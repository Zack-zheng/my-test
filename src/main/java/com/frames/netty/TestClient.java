package com.frames.netty;

import java.net.InetSocketAddress;  
import java.util.concurrent.Executors;  
 
import org.jboss.netty.bootstrap.ClientBootstrap;  
import org.jboss.netty.channel.ChannelFuture;  
import org.jboss.netty.channel.ChannelPipeline;  
import org.jboss.netty.channel.ChannelPipelineFactory;  
import org.jboss.netty.channel.Channels;  
import org.jboss.netty.channel.socket.nio.NioClientSocketChannelFactory;  
 
public class TestClient {  
 
   private final String host;  
   private final int port;  
   private final String firstMessageSize;  
 
   public TestClient(String host, int port, String firstMessageSize) {  
       this.host = host;  
       this.port = port;  
       this.firstMessageSize = firstMessageSize;  
   }  
 
   public void run() {  
       // Configure the client.  
       ClientBootstrap bootstrap = new ClientBootstrap(  
               new NioClientSocketChannelFactory(  
                       Executors.newCachedThreadPool(),  
                       Executors.newCachedThreadPool()));  
 
       // Set up the pipeline factory.  
       bootstrap.setPipelineFactory(new ChannelPipelineFactory() {  
           public ChannelPipeline getPipeline() throws Exception {  
               return Channels.pipeline(  
                       new TestClientHandler(firstMessageSize));  
           }  
       });  
 
       // Start the connection attempt.  
       ChannelFuture future = bootstrap.connect(new InetSocketAddress(host, port));  
 
       // Wait until the connection is closed or the connection attempt fails.  
       future.getChannel().getCloseFuture().awaitUninterruptibly();  
 
       // Shut down thread pools to exit.  
       bootstrap.releaseExternalResources();  
   }  
 
   public static void main(String[] args) throws Exception {  
         
       new TestClient("127.0.0.1", 8080, "HelloWorld, Welcome to netty！").run();  
   }  
}  