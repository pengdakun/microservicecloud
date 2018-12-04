package com.peng.demo.filter;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

@Component
public class MyZuulFilter extends ZuulFilter{

	@Override
	public boolean shouldFilter() {//是否要过滤
		return true;
	}

	@Override
	public Object run() {//过滤逻辑
		RequestContext currentContext = RequestContext.getCurrentContext();
		HttpServletRequest request = currentContext.getRequest();
		String accessToken = request.getParameter("access-token");
		if (StringUtils.isBlank(accessToken)) {
			currentContext.setSendZuulResponse(false);//没有access-token，拦截请求   true放行    false拦截
			currentContext.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());// 返回401状态码。也可以考虑重定向到登录页。
		}
		// 校验通过，可以考虑把用户信息放入上下文，继续向后执行
		return null;
	}

	@Override
	public String filterType() {//过滤器类型    pre：请求在被路由之前执行   routing：在路由请求时调用   post：在routing和errror过滤器之后调用    error：处理请求时发生错误调用
		return FilterConstants.PRE_TYPE;
	}

	@Override
	public int filterOrder() {//过滤器优先级
		return FilterConstants.PRE_DECORATION_FILTER_ORDER-1;//在处理请求头的拦截器之前拦截
	}

}
