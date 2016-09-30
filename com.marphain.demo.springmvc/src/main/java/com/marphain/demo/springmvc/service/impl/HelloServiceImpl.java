package com.marphain.demo.springmvc.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.marphain.demo.springmvc.dao.IHelloDao;
import com.marphain.demo.springmvc.entity.po.HelloPo;
import com.marphain.demo.springmvc.service.IHelloService;

@Service
public class HelloServiceImpl implements IHelloService
{
	@Resource
	private IHelloDao helloDao;
	
	@Override
	public String hello()
	{
		HelloPo po = new HelloPo();
		po.setId(1);
		List<HelloPo> pos = helloDao.selectPos(po);
		if (CollectionUtils.isEmpty(pos))
		{
			return "error";
		}
		
		return pos.get(0).getDescription();
	}

}
