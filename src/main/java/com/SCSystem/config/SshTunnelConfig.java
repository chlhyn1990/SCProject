package com.SCSystem.config;

import com.SCSystem.dto.Charger;
import com.jcraft.jsch.*;

import lombok.Data;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import javax.annotation.PreDestroy;

@Configuration
@ConfigurationProperties(prefix = "ssh")
@Profile("dev")  // 개발 환경에서만 활성화
@Data
public class SshTunnelConfig {

    // === 프로퍼티 (application.yml에서 주입) ===
    private boolean enabled;
    private String host;
    private int sshPort;
    private String username;
    private String password;
    private int localPort;
    private String remoteHost;
    private int remotePort;
    private Session session;

    @Bean
    public void startTunnel() throws JSchException {
	        JSch jsch = new JSch();
	        session = jsch.getSession(username, host, sshPort);
	        session.setPassword(password);
	        session.setConfig("StrictHostKeyChecking", "no");
	        session.connect();
	        session.setPortForwardingL(localPort, remoteHost, remotePort);
	        
	        if(session.isConnected())
	        	System.out.println("SSH tunnel connect success!! " + localPort + " -> " + host + ":" + remotePort);
	        else
	        	System.out.println("SSH tunnel connect fail!! " + host);
    }

    @PreDestroy
    public void stopTunnel() {
        if (session != null && session.isConnected()) {
            session.disconnect();
            System.out.println("SSH tunnel disconnect!!");
        }
    }
}