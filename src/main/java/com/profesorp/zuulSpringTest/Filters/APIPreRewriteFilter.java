package com.profesorp.zuulSpringTest.Filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.web.util.UriComponentsBuilder;
import java.io.IOException;
import java.net.URL;

public class APIPreRewriteFilter extends ZuulFilter {
	Logger log = LoggerFactory.getLogger(APIPreRewriteFilter.class);
	@Override
	public Object run() {		
		 RequestContext ctx = RequestContext.getCurrentContext();	    
	     StringBuffer strLog=new StringBuffer();
	     strLog.append("\n------ FILTRANDO REQUISICAO API  ------\n");
	     try {
			 String routerPrivate = "http://10.252.135.118";
			 String url=UriComponentsBuilder.fromHttpUrl(routerPrivate).path("/api").build().toUriString();
			 ctx.setRouteHost(new URL(url));
		} catch ( IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	     log.info(strLog.toString());
	     return null;
	}

	@Override
	public boolean shouldFilter() {				
		return RequestContext.getCurrentContext().getRequest().getRequestURI().startsWith("/api");
	}

	@Override
	public int filterOrder() {
		
		return FilterConstants.PRE_DECORATION_FILTER_ORDER+1; 
	}

	@Override
	public String filterType() {
		return FilterConstants.PRE_TYPE;
	}

}
