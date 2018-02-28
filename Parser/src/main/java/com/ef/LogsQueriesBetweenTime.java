package com.ef;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;

import com.ef.dao.LogQueryDAO;
import com.ef.entity.LogQuery;
import com.ef.util.DateFormatterUtil;
import com.ef.util.JPAUtil;

public class LogsQueriesBetweenTime {
	
	public static void main(String[] args) {
		EntityManager  em = new JPAUtil().getEntityManager();
		
		//"yyyy-MM-DD.HH:mm:ss"
		em.getTransaction().begin();
		LocalDateTime startDate = 
				LocalDateTime.parse(args[0], 
			DateFormatterUtil.forInputByArgs());
		
		LocalDateTime endDate = 
				LocalDateTime.parse(args[1], 
			DateFormatterUtil.forInputByArgs());
		
		  List<LogQuery> listBetween = new LogQueryDAO(em).getListBetween(startDate, endDate);
		listBetween.forEach(System.out::println);
		em.getTransaction().commit();
		
		
	}
}
