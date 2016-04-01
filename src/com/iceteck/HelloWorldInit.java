/**
 * 
 */
package com.iceteck;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author Larry_Lite
 * Using a BeanPostProcessor to handle callbacks 
 */
public class HelloWorldInit implements BeanPostProcessor {

	private List<String> mcurrency;
	private Set addressSet;
	private Map addressMap;
	private Properties addressProp;
	
	public void setCurrency(List<String> currency){
		mcurrency = currency;
	}
	
	public void getCurrency(){
		System.out.println("Currencies: "+mcurrency);
	}
	
	public void setAddressSet(Set aSet) {
		addressSet = aSet;
	}
	
	public Set getAddressSet() {
		System.out.println("Address Set: "+addressSet);
		return addressSet;
	}

	public Map getAddressMap() {
		return addressMap;
	}

	public void setAddressMap(Map addressMap) {
		this.addressMap = addressMap;
	}

	public Properties getAddressProp() {
		return addressProp;
	}

	public void setAddressProp(Properties addressProps) {
		this.addressProp = addressProps;
	}

	/* (non-Javadoc)
	 * @see org.springframework.beans.factory.config.BeanPostProcessor#postProcessAfterInitialization(java.lang.Object, java.lang.String)
	 */
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName)
			throws BeansException {
		// TODO Auto-generated method stub
		System.out.println("AfterInitialization : " + beanName);
		return bean;
	}

	/* (non-Javadoc)
	 * @see org.springframework.beans.factory.config.BeanPostProcessor#postProcessBeforeInitialization(java.lang.Object, java.lang.String)
	 */
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName)
			throws BeansException {
		// TODO Auto-generated method stub
		System.out.println("BeforeInitialization : " + beanName);
		return bean;
	}

	public void init(){
		return;
	}
	
	public void destroy(){
		return;
	}
}
