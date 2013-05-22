package ca.filtres;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AccesFilter implements Filter {

	FilterConfig fc;

	public AccesFilter() {
		super();
	}

	/*
	 * (non-Java-doc)
	 * 
	 * @see javax.servlet.Filter#init(FilterConfig arg0)
	 */
	public void init(FilterConfig filterConfig) throws ServletException {
		this.fc = filterConfig;

	}

	/*
	 * (non-Java-doc)
	 * 
	 * @see javax.servlet.Filter#doFilter(ServletRequest arg0, ServletResponse
	 *      arg1, FilterChain arg2)
	 */
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
	
	
		try{
		
			if(request.getSession().getAttribute("admin")!=null){
				
			}else{
			response.sendRedirect("/PPJJ/Private.do?error=noAdmin");
			}
		
		}catch (Exception e){
			System.out.println("Fallo accesFilter");
			System.out.println(stack2string(e));
		}
		// pass the request/response on
		chain.doFilter(req, response);
	}

	/*
	 * (non-Java-doc)
	 * 
	 * @see javax.servlet.Filter#destroy()
	 */
	public void destroy() {
		this.fc = null;
	}
	
	 public static String stack2string(Exception e) {
		  try {
		    StringWriter sw = new StringWriter();
		    PrintWriter pw = new PrintWriter(sw);
		    e.printStackTrace(pw);
		    return "------\r\n" + sw.toString() + "------\r\n";
		  }
		  catch(Exception e2) {
		    return "bad stack2string";
		  }

	 }
}