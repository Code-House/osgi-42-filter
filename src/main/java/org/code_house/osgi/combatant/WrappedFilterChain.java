package org.code_house.osgi.combatant;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author dl02
 */
public class WrappedFilterChain implements FilterChain {

    private final List<Filter> filters;

    public WrappedFilterChain(List<Filter> filters) {
        this.filters = filters;
    }

    public void doFilter(ServletRequest request, ServletResponse response) throws IOException, ServletException {
        for (Filter filter : filters) {
            filter.doFilter(request, response, this);
        }
    }
}
