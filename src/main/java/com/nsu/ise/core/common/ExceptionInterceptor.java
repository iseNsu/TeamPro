package com.nsu.ise.core.common;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.nsu.ise.core.Constants;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class ExceptionInterceptor implements Interceptor {

	protected final Log log = LogFactory.getLog(getClass());

	public void destroy() {
	}

	public void init() {
	}

	public String intercept(ActionInvocation invocation) throws Exception {
		try {
			return invocation.invoke();
		} catch (Exception e) {	
			handleException(invocation, e);
			return Constants.EXCEPTION;
		}		
	}

	private void handleException(ActionInvocation invocation, Exception e) {
		String message = "在执行"+ invocation.getInvocationContext().getName()+".action时发生异常：";
		log.error(message, e);

		StringWriter sw = new StringWriter();
		e.printStackTrace(new PrintWriter(sw));
		invocation.getInvocationContext().put(Constants.CONTEXT_EXCEPTION,
				message+e.toString());
		invocation.getInvocationContext().put(Constants.CONTEXT_EXCEPTION_INFO,
				sw.toString());
	}

}
