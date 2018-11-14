package com.asiainfo.dao.factory;

import com.asiainfo.dao.ITaskDAO;
import com.asiainfo.dao.impl.TaskDAOImpl;

/**
 * DAO工厂类
 * @author Administrator
 *
 */
public class DAOFactory {


	public static ITaskDAO getTaskDAO() {
		return new TaskDAOImpl();
	}
	
}
