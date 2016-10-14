package com.handsome.admin.siteuser.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.handsome.admin.common.bean.ResponseObject;
import com.handsome.product.api.bean.Product;
import com.handsome.product.api.service.ProductService;
import com.handsome.siteuser.api.bean.SiteUser;
import com.handsome.siteuser.api.service.SiteUserService;

/**
 * 
 * @author dell
 *
 */
@Api("权限管理接口")
@RestController
@RequestMapping("/siteuser/api")
public class SiteUserApiController
{

	@Autowired
	@Qualifier(value = "siteUserServiceImpl")
	private SiteUserService siteUserService;

	@ApiOperation("新用户注册接口")
	@RequestMapping(value = "/querysiteusers.do", method = RequestMethod.POST)
	public @ResponseBody String signup(
			@ApiParam(value = "用户名", required = true) @RequestParam("username") String userName,
			@ApiParam(value = "密码", required = true) @RequestParam("password") String password)
	{
		ResponseObject res = new ResponseObject();
		try
		{
			//TODO:添加企业
			siteUserService.createSiteUser(userName, password, "");
		}
		catch (Exception e)
		{
			res.setCode(1);
			res.setError(e.getMessage());
		}
		return JSON.toJSONString(res);
	}
	
	
}