package com.eventbus;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class EventBusRegisterBeanPostProcessor implements BeanPostProcessor {

	@Autowired
	private EventBusWrapper eventBus;

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName)
			throws BeansException {
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName)
			throws BeansException {
		eventBus.register(bean);
		return bean;
	}
}
