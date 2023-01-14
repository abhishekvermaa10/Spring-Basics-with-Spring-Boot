package com.scaleupindia.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
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
	private static Logger logger = LoggerFactory.getLogger(LogAspect.class);

	@Before("execution(* com.scaleupindia.service.OwnerService.findOwner(..))")
	public void logBeforeAdvice(JoinPoint joinPoint) {
		logger.info("Entered {} with arguments as {}", joinPoint.getSignature(), joinPoint.getArgs());
	}

	@After("execution(* com.scaleupindia.service.OwnerService.findOwner(..))")
	public void logAfterAdvice(JoinPoint joinPoint) {
		logger.info("Completed {}", joinPoint.getSignature());
	}

	@AfterReturning(pointcut = "execution(* com.scaleupindia.service.OwnerService.findOwner(..))", returning = "result")
	public void logAfterReturningAdvice(JoinPoint joinPoint, String result) {
		logger.info("Completed {} with result as {}", joinPoint.getSignature(), result);
	}

	@AfterThrowing(pointcut = "execution(* com.scaleupindia.service.OwnerService.findOwner(..))", throwing = "exception")
	public void logAfterThrowingAdvice(JoinPoint joinPoint, Exception exception) {
		logger.error("Completed {} with exception as {}", joinPoint.getSignature(), exception.getMessage());
	}

	@Around("execution(* com.scaleupindia.service.OwnerService.findOwner(..))")
	public Object logAroundAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		logger.info("In Around Advice, Joinpoint signature: {}", proceedingJoinPoint.getSignature());
		logger.info("Before proceeding part of the Around advice.");
		Object object = proceedingJoinPoint.proceed();
		logger.info("After proceeding part of the Around advice.");
		return object;
	}
}
