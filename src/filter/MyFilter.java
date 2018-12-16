package filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MyFilter implements Filter {

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		
		res.setContentType("text/html");  //set response content type 
		PrintWriter out = res.getWriter();

		String password = req.getParameter("password");
		if (password.equals("admin")) {
			// sends request to next resource
			chain.doFilter(req, res);
		} else {
			out.println("Wrong username or password!");
			RequestDispatcher rd = req.getRequestDispatcher("index.html");
			rd.include(req, res);
		}
		out.close();
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}

}
