package cs544.exercise13_1;

import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.util.StopWatch;

@Aspect
public class MailAdvice {

	@After("execution(* cs544.exercise13_1.EmailSender.sendEmail(..))")
	public void mailsendmethod(JoinPoint joinpoint){
		Object[] ob = joinpoint.getArgs();
		Date d = new Date();
		EmailSender e = (EmailSender)joinpoint.getTarget();
		MailAdvice a = new MailAdvice();
		
		StopWatch clock = new StopWatch("");
		clock.start(joinpoint.toShortString());
		
		
		System.out.println( d.toString() + " Method = " + joinpoint.getSignature().getName() + 
				"Address= " + ob[0].toString() + 
				"\nmessage= " + ob[1].toString() +
				"\noutgoing mail server= " + e.outgoingMailServer);
	}
	
	@Around("execution(* cs544.exercise13_1.CustomerDAO.save(..))")
	public Object invoke(ProceedingJoinPoint call ) throws Throwable {
		 StopWatch sw = new StopWatch();
		 sw.start(call.getSignature().getName());
		 Object retVal = call.proceed();
		 sw.stop();

		long totaltime = sw.getLastTaskTimeMillis();
		// print the time to the console
		System.out.println("Time to execute save= " + totaltime + " ms");

		return retVal;
		}

	
	
}
