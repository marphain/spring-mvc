package com.marphain.demo.springmvc.dao;

import java.util.List;

import com.marphain.demo.springmvc.entity.po.HelloPo;

public interface IHelloDao
{
	List<HelloPo> selectPos(HelloPo po);
}
