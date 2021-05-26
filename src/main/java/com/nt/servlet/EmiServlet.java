package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EmiServlet extends HttpServlet{
	@Override
public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException
{
	PrintWriter pw=res.getWriter();
	res.setContentType("text/html");
	float principal=Float.parseFloat(req.getParameter("p"));
	float rate=Float.parseFloat(req.getParameter("r"));
	float time=Float.parseFloat(req.getParameter("t"));
	rate=rate/(12*100);
	time=time*12;
	float emi=  (principal * rate * (float)Math.pow(1 + rate, time))
            / (float)(Math.pow(1 + rate, time) - 1);
pw.println("<h1 style=color:red;text-align:center>YOUR EMI CALCULATED IS"+emi+"</h1>");
emi=(emi*time)/12;
pw.println("<br><h1 style=color:green;text-align:center>TOTAL INTEREST PAYABLE IS "+emi+"</h1>");
emi=emi+principal;
pw.println("<br><h1 style=color:violet;text-align:center>TOTAL AMOUNT(P+I) IS"+emi+"</h1");
pw.close();
}
}
