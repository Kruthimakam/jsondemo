package com.jsondemo.controller;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.HTTP;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.jsondemo.pkg.user;
import com.jsondemo.service.UserService;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet(urlPatterns = {"/users"}, name= "UserServlet", description="returning the json value" )
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService service= new UserService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//List<user> u1= new ArrayList<>();
		//System.out.println(Integer.toHexString(System.identityHashCode(u1)));
		List<user> u1=service.getUser();
		System.out.println(Integer.toHexString(System.identityHashCode(u1)));
		Gson gson=new Gson();
		String jsonval=gson.toJson(u1);
		
		PrintWriter printwriter = response.getWriter();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		printwriter.write(jsonval);
		printwriter.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    
 	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
 	    Gson gs=new Gson();
 		String value =gs.fromJson(request.getParameter("id"), String.class);
 		//int value1 = Integer.parseInt(value);
 		//System.out.println(value);
 		
 		String test=request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
 		//System.out.println(test);
 		
 		JSONArray array = new JSONArray(test);  
 		for(int i=0; i < array.length(); i++)   
 		{  
 		JSONObject object = array.getJSONObject(i); 
 		System.out.println(object.toString());
 		System.out.println(object.getString("name"));

 		}  
 		for(int j=0;j<array.length();j++)
 		{
 			JSONObject object = array.getJSONObject(j); 
 			if(Integer.parseInt(value)==object.getInt("id"))
 			{
 				System.out.println(object.getString("name"));
 			}
 		}
// 		
 		
 	}

}
