package org.code_house.osgi.combatant;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import java.io.IOException;

/**
 * @author dl02
 */
public class ServletCaller implements Filter {
    private final HttpServlet servlet;

    public ServletCaller(HttpServlet servlet) {
        this.servlet = servlet;
    }

    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        servlet.service(request, response);
    }

    public void destroy() {

    }

}
