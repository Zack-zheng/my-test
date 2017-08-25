package com.zzz.frames.netty;

import java.net.InetSocketAddress;  
import java.util.concurrent.Executors;  
  
import org.jboss.netty.bootstrap.ServerBootstrap;  
import org.jboss.netty.channel.ChannelPipeline;  
import org.jboss.netty.channel.ChannelPipelineFactory;  
import org.jboss.netty.channel.Channels;  
import org.jboss.netty.channel.socket.nio.NioServerSocketChannelFactory;  
  
/** 
 * Echoes back any received data from a client. 
 */  
public class TestServer {  
  
    private final int port;  
  
    public TestServer(int port) {  
        this.port = port;  
    }  
  
    public void run() {  
        // Configure the server.  
        ServerBootstrap bootstrap = new ServerBootstrap(  
                new NioServerSocketChannelFactory(  
                        Executors.newCachedThreadPool(),  
                        Executors.newCachedThreadPool()));  
  
        // Set up the pipeline factory.  
        bootstrap.setPipelineFactory(new ChannelPipelineFactory() {  
            public ChannelPipeline getPipeline() throws Exception {  
                return Channels.pipeline(new TestServerHandler());  
            }  
        });  
  
        // Bind and start to accept incoming connections.  
        bootstrap.bind(new InetSocketAddress(port));  
    }  
  
    public static void main(String[] args) throws Exception {  
        
        new TestServer(8080).run();  
    }  
}  