package com.fairytale.webserver.config;

import java.util.Properties;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

/**
 * @author Administrator
 *
 */
public class JdbcPropertyPlaceholderConfigurer extends
		PropertyPlaceholderConfigurer {

	public JdbcPropertyPlaceholderConfigurer() {
		System.out.println("JdbcPropertyPlaceHolderConfigurer");
	}
	
	@Override
	protected void processProperties(
			ConfigurableListableBeanFactory beanFactoryToProcess,
			Properties props) throws BeansException {
		//�������ļ��е���ݿ��������Ľ��н���
		String password=(String) props.getProperty("jdbc.password");
		if (password != null){
//				 	props.setProperty("jdbc.password" , SecurityUtils.getMD5(password));
		}
		super.processProperties(beanFactoryToProcess, props);
	}
}
