package net.hb.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class BankCheck {
	
	
	//"execution(public *net.hb.order..*.*(..))"
	@Before("execution(public * net.hb.order.GuestDAO.dbDetail(..))")
	public void open() {
		System.out.println("open�Լ� ������ϻ���");
		System.out.println("ActiveX��ġ\n");
		
	}
	
	@After("execution(public * net.hb.order.GuestDAO.dbDetail(..))")
	public void close() {
		System.out.println("close�Լ� �˸��޽���");
		System.out.println("�ŷ������� ����\n");
	}
}
