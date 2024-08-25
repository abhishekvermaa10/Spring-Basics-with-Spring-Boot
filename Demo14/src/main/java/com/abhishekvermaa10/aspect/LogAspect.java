package com.abhishekvermaa10.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author abhishekvermaa10
 *
 */
@Aspect
@Component
public class LogAspect {
	private static final Logger LOGGER = LoggerFactory.getLogger(LogAspect.class);

	@Pointcut("execution(String com.abhishekvermaa10.service.impl.OwnerServiceImpl.findOwner())")
	public void findOwnerExpression() {
		
	}
	
	@Before("findOwnerExpression()")
	public void logBeforeAdvice(JoinPoint joinPoint) {
		LOGGER.info("Entered {} with arguments as {}", joinPoint.getSignature(), joinPoint.getArgs());
	}

	@After("findOwnerExpression()")
	public void logAfterAdvice(JoinPoint joinPoint) {
		LOGGER.info("Completed {}", joinPoint.getSignature());
	}

	@AfterReturning(pointcut="findOwnerExpression()", returning="result")
	public void logAfterReturningAdvice(JoinPoint joinPoint, String result) {
		LOGGER.info("Completed {} with result as {}", joinPoint.getSignature(), result);
	}

	@AfterThrowing(pointcut="findOwnerExpression()", throwing="exception")
	public void logAfterThrowingAdvice(JoinPoint joinPoint, Exception exception) {
		LOGGER.error("Completed {} with exception as {}", joinPoint.getSignature(), exception.getMessage());
	}

	@Around("findOwnerExpression()")
	public Object logAroundAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		LOGGER.info("Around {} with arguments as {}", proceedingJoinPoint.getSignature(), proceedingJoinPoint.getArgs());
		LOGGER.info("Before invoking proceed()");
		Object object = proceedingJoinPoint.proceed();
		LOGGER.info("After invoking proceed()");
		return object;
	}
}
