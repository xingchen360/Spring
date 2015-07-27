package com.somnus.activemq;

import javax.jms.Destination;

/** 
 * @Title: ProducerService.java 
 * @Package com.somnus.activemq 
 * @Description: TODO
 * @author yh.liu
 * @date 2015年7月27日 上午10:44:45 
 * @version V1.0 
 */
public interface ProducerService {
    public void sendMessage(Destination destination, final String message);
}
