package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ws.ProductWsStub;
import ws.ProductWsStub.FindAll;
import ws.ProductWsStub.ProductEntity;

/**
 * Servlet implementation class ProdController
 */

public class ProdController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProdController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		
			try {
				ProductWsStub pss = new ProductWsStub();
				 ProductEntity[] result = pss.findAll(new FindAll()).get_return();
				out.println(result.length);
				out.println("<br/>");
				for(ProductEntity p : result) {
					out.println("<br/>  Id Of Product is " + p.getId() );
					out.println("<br/> Name Of Product is " + p.getProdname() );
					out.println(" <br/> Price Of Product is " + p.getPrice());
					out.println("<br/><hr/><hr/>");
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
