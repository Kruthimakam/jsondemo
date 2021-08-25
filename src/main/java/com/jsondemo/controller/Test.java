package com.jsondemo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

@Path("/test")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class Test {
	
	
	 @Context
	    private HttpServletRequest httpServletReq;

	    @Context
	    private HttpServletResponse httpServletRes;
	    
	    
	    @GET
	    @Path("/email")
	    public String getRegisteredOrganizations()  {
	        String str = "test";
	       
	        System.out.println("str" + str);
	       
	        return str;
	       
	        }
	

}
