package net.hb.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class BankCheck {
	
	
	//"execution(public *net.hb.order..*.*(..))"
	@Before("execution(public * net.hb.order.GuestDAO.dbDetail(..))")
	public void open() {
		System.out.println("open함수 기록파일생성");
		System.out.println("ActiveX설치\n");
		
	}
	
	@After("execution(public * net.hb.order.GuestDAO.dbDetail(..))")
	public void close() {
		System.out.println("close함수 알림메시지");
		System.out.println("거래내역서 전송\n");
	}
}
