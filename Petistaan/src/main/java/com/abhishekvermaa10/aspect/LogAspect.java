package com.abhishekvermaa10.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
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

	@Pointcut("execution(* com.abhishekvermaa10.service.impl.*.*(..))")
	public void serviceMethodExpression() {

	}

	@Before("serviceMethodExpression()")
	public void logBeforeAdvice(JoinPoint joinPoint) {
		LOGGER.info("Entered {} with arguments as {}", joinPoint.getSignature(), joinPoint.getArgs());
	}

	@AfterReturning(pointcut = "serviceMethodExpression()", returning = "result")
	public void logAfterReturningAdvice(JoinPoint joinPoint, Object result) {
		LOGGER.info("Completed {} with result as {}", joinPoint.getSignature(), result);
	}

	@AfterThrowing(pointcut = "serviceMethodExpression()", throwing = "exception")
	public void logAfterThrowingAdvice(JoinPoint joinPoint, Exception exception) {
		LOGGER.error("Completed {} with exception as {}", joinPoint.getSignature(), exception.getMessage());
	}
}
