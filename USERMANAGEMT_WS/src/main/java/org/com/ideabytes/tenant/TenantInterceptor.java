package org.com.ideabytes.tenant;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class TenantInterceptor extends HandlerInterceptorAdapter {

  private static final String TENANT_HEADER = "tenantid";

  @Override
  public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler)
      throws Exception {

    boolean tenantSet = false;
    res.setHeader("Access-Control-Allow-Origin", "*");
    
    if(!req.getMethod().equalsIgnoreCase("options")) {
    	String tenateId = req.getHeader(TENANT_HEADER);
        if(!StringUtils.isEmpty(tenateId)) {
        	TenantContext.setCurrentTenant(tenateId);
        	tenantSet = true;

        }else {
        	
        	res.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        	res.setContentType(MediaType.APPLICATION_JSON_VALUE);
        	res.getWriter().write("{\"error\": \"No tenant supplied\"}");
        	res.getWriter().flush();
        }
    }else {
    	res.setHeader("Access-Control-Allow-Methods", "DELETE, GET, OPTIONS, PATCH, POST, PUT");
    	res.setHeader("Access-Control-Max-Age", "3600");
    	res.setHeader("Access-Control-Allow-Headers", "x-requested-with, content-type, tenantid, Authorization");
    	tenantSet = true;
    	res.setStatus(HttpServletResponse.SC_OK);
    }
    
    

    return tenantSet;
  }

  @Override
  public void postHandle(
      HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
          throws Exception {
    TenantContext.clear();
  }
}