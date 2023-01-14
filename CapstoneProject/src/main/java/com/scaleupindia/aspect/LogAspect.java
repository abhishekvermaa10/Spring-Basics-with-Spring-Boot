package com.scaleupindia.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
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

	@Before("execution(* com.scaleupindia.service.OwnerService.*(..))")
	public void logBeforeAdvice(JoinPoint joinPoint) {
		logger.info("Entered {} with arguments as {}", joinPoint.getSignature(), joinPoint.getArgs());
	}

	@AfterReturning(pointcut = "execution(* com.scaleupindia.service.OwnerService.*(..))", returning = "result")
	public void logAfterReturningAdvice(JoinPoint joinPoint, Object result) {
		logger.info("Completed {} with result as {}", joinPoint.getSignature(), result);
	}

	@AfterThrowing(pointcut = "execution(* com.scaleupindia.service.OwnerService.*(..))", throwing = "exception")
	public void logAfterThrowingAdvice(JoinPoint joinPoint, Exception exception) {
		logger.error("Completed {} with exception as {}", joinPoint.getSignature(), exception.getMessage());
	}
}
