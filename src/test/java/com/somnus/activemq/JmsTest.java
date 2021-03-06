package com.somnus.activemq;

import java.io.Serializable;
import java.math.BigDecimal;

import org.junit.Test;

import com.somnus.AbstractTestSupport;
import com.somnus.ApplicationContextHolder;

public class JmsTest extends AbstractTestSupport {
	
    @Test
    public void sendStringQueueMessage() {
        JmsService jms = (JmsService) ApplicationContextHolder.getBean(JmsServiceImpl.class);  
        jms.sendStringQueueMessage("你好，生产者！这是消息");
        try {
			//防止Spring容器过早的关闭
			Thread.sleep(Integer.MAX_VALUE);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    @Test
    public void sendStringTopicMessage() {
        JmsService jms = (JmsService) ApplicationContextHolder.getBean(JmsServiceImpl.class);  
        jms.sendStringTopicMessage("你好，生产者！这是消息");
        try {
			//防止Spring容器过早的关闭
			Thread.sleep(Integer.MAX_VALUE);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    
    //////////////////////////////////////////////////////////////////////////
    
    @Test
    public void sendObjectQueueMessage() {
        JmsService jms = (JmsService) ApplicationContextHolder.getBean(JmsServiceImpl.class);  
        jms.sendObjectTopicMessage(new Account("10000",BigDecimal.ZERO));
        try {
			//防止Spring容器过早的关闭
			Thread.sleep(Integer.MAX_VALUE);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    @Test
    public void sendObjectTopicMessage() {
        JmsService jms = (JmsService) ApplicationContextHolder.getBean(JmsServiceImpl.class);  
        jms.sendObjectTopicMessage(new Account("10086",BigDecimal.ONE));
        try {
			//防止Spring容器过早的关闭
			Thread.sleep(Integer.MAX_VALUE);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
}

class Account implements Serializable{
	private static final long serialVersionUID = 1L;

	public String acctCode;
	
	public BigDecimal balance;
	
	public Account(String acctCode, BigDecimal balance) {
		super();
		this.acctCode = acctCode;
		this.balance = balance;
	}

	public String getAcctCode() {
		return acctCode;
	}

	public void setAcctCode(String acctCode) {
		this.acctCode = acctCode;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	
}
