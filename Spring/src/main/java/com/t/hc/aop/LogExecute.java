package com.t.hc.aop;

import org.aspectj.lang.JoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// AOP���� �ڵ������� ���� �Ǵ� Point�� ���� �޼ҵ�
//<aop:before			method="before"				pointcut-ref="serviceLogPoint"/>
//<aop:after-returning	method="afterReturning"		pointcut-ref="serviceLogPoint"/>
//<aop:after-throwing	method="DaoError"			pointcut-ref="serviceLogPoint"/>
public class LogExecute {
	
	// *Dao*�� �޼ҵ尡 ���� �ɶ�
	public void before(JoinPoint j){
		Logger logger = LoggerFactory.getLogger(j.getTarget()+"");
		logger.info("Logger ����");
		
		Object args[] = j.getArgs();
		if(args!=null){
			// �޼ҵ� Args�� �޾ƿ´�
			logger.info("Method:\t"+j.getSignature().getName());
			
			for (int i = 0; i < args.length; i++) {
				logger.info(i+":��°:\t"+args[i]);
			}
			
			logger.info("Method:\t"+j.getSignature().getName());
		}
	}//before
	
	public void afterReturning(JoinPoint j){
		Logger logger = LoggerFactory.getLogger(j.getTarget()+"");
		logger.info("=============��==============");
	}
	
	public void daoError(JoinPoint j){
		Logger logger = LoggerFactory.getLogger(j.getTarget()+"");
		logger.info("����:\t"+j.getArgs());
		logger.info("����:\t"+j.toString());
	}
	
}
