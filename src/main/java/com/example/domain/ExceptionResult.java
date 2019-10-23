package com.example.domain;


import com.sun.org.apache.bcel.internal.generic.RET;

import javax.security.auth.login.LoginContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import javax.xml.ws.http.HTTPException;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.*;

public class ExceptionResult {
    public ExceptionResult() {
    }

    public ExceptionResult(HttpServletRequest request,Exception e) {
        ExceptionResult vm =new ExceptionResult();
        errorId=UUID.randomUUID().toString();
        try {
            host= InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e1) {
            host= "Unknow";
        }
        type= e.getClass().getSimpleName();
        message = e.getMessage();
        source= e.getStackTrace().toString();
        user = request.getRemoteUser();
        timeUtc = new Date();
        if (e instanceof HTTPException){
            HTTPException httpException = (HTTPException)e;
            statusCode = httpException.getStatusCode();
        }

        serverVariables = new Hashtable<String, String>();
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()){
            String name =headerNames.nextElement();
            serverVariables.put(name,request.getHeader(name));
        }
    }

    private String errorId;
    private String application;
    private String host;
    private String type;
    private String source;
    private String message;
    private String user;
    private int statusCode;
    private Date timeUtc;
    private long sequence;
    private Map<String,String> serverVariables;
    private Map<String,String> queryString;
    private Map<String,String> form;
    private Map<String,String> cookies;


    public String getErrorId() {
        return errorId;
    }

    public void setErrorId(String errorId) {
        this.errorId = errorId;
    }

    public String getApplication() {
        return application;
    }

    public void setApplication(String application) {
        this.application = application;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public Date getTimeUtc() {
        return timeUtc;
    }

    public void setTimeUtc(Date timeUtc) {
        this.timeUtc = timeUtc;
    }

    public long getSequence() {
        return sequence;
    }

    public void setSequence(long sequence) {
        this.sequence = sequence;
    }

    public Map<String, String> getServerVariables() {
        return serverVariables;
    }

    public void setServerVariables(Map<String, String> serverVariables) {
        this.serverVariables = serverVariables;
    }

    public Map<String, String> getQueryString() {
        return queryString;
    }

    public void setQueryString(Map<String, String> queryString) {
        this.queryString = queryString;
    }

    public Map<String, String> getForm() {
        return form;
    }

    public void setForm(Map<String, String> form) {
        this.form = form;
    }

    public Map<String, String> getCookies() {
        return cookies;
    }

    public void setCookies(Map<String, String> cookies) {
        this.cookies = cookies;
    }

    private Map<String,String> copyCollection(){
        return new HashMap<String,String>();
    }
}
