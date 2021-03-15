package com.dnk.swa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dnk.swa.dao.SwaDao;

@Service
public class SwaServiceImpl implements SwaService{
	
	@Autowired
	SwaDao dao;

}
