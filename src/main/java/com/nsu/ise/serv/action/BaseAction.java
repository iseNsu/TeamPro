package com.nsu.ise.serv.action;

import java.util.Map;

import com.nsu.ise.core.Constants;
import com.nsu.ise.core.common.CommonBaseAction;
import com.nsu.ise.serv.service.ServiceManager;

import javadev.core.bean.BeanManager;

public class BaseAction extends CommonBaseAction {

	/* ServiceManager */
	public ServiceManager getServMgr() {
		return (ServiceManager) BeanManager.getBean("serviceManager");
	}

	/* 获取登录用户对象 */
	public Map getLoginUser() {
		return (Map) getSession().get(Constants.LOGIN_USER);
	}


}
