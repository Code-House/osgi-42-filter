package org.code_house.osgi.combatant;

import javax.servlet.Filter;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author dl02
 */
public class WrapperServlet extends HttpServlet {

    private final List<Filter> filters = new ArrayList<Filter>();
    private final Map<String, Servlet> servlets = new HashMap<String, Servlet>();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Filter> calledFilters = new ArrayList<Filter>(getMatchingFilters(req));
        calledFilters.add(new ServletCaller(getMatchingServlet(req)));
        new WrappedFilterChain(calledFilters).doFilter(req, resp);
    }

    private HttpServlet getMatchingServlet(HttpServletRequest req) {
        String requestedURI = req.getRequestURI();
        return new DefaultServlet();
    }

    private List<Filter> getMatchingFilters(HttpServletRequest req) {
        return Collections.emptyList();
    }
}
