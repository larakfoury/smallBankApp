package com.banks.controller;

import java.io.IOException;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.banks.manager.impl.AccountImpl;
import com.banks.manager.impl.CustomerImpl;
import com.banks.manager.impl.TransactionImpl;
import com.banks.manager.interfaces.AccountIF;
import com.banks.manager.interfaces.CustomerIF;
import com.banks.manager.interfaces.TransactionIF;
import com.banks.model.Customer;
import com.banks.model.Transaction;
import com.banks.types.AccountType;
import com.banks.types.TransactionType;

/**
 * Servlet implementation class PersonServlet
 */
@WebServlet("/CustomerServlet")
public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public CustomerServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		

		
		String requestUrl = request.getRequestURI();
		String name = requestUrl.substring("/customer".length()) != null && !requestUrl.substring("/customer".length()).isEmpty()?requestUrl.substring("/customer/".length()):request.getParameter("name") ;
		
		CustomerIF c = new CustomerImpl();
		
		Customer person = c.getCustomer(name);
		
		AccountIF acc = new AccountImpl();
		if(request.getParameter("name") != null && person != null){
			request.setAttribute("customerName", person.getCustomerName());
			request.setAttribute("birthYear", person.getBirthYear());
			request.setAttribute("balance", acc.getBalance(person.getCustomerID()) );
			request.setAttribute("Transactions", acc.getListTransactionsByCustomer(person.getCustomerID()));
			
			List<Transaction> transByCustomer = acc.getListTransactionsByCustomer(person.getCustomerID());
			response.setCharacterEncoding("UTF-8"); 
			
					
					String output = "<h3> Person information: </h3>"
					+		"<table>\r\n"
					+ "         <tr>\r\n"
					+ "         <td>Name: </td>\r\n"
					+ "         <td>"+ person.getCustomerName() +"</td>\r\n"
					+ "         </tr>\r\n"
					+ "         <tr>\r\n"
					+ "         <td>Birth Year: </td>\r\n"
					+ "         <td>"+ person.getBirthYear() +"</td>\r\n"
					+ "         </tr>\r\n"
					+ "			<tr>\r\n"
					+ "         <td>Balance: </td>\r\n"
					+ "         <td>"+ acc.getBalance(person.getCustomerID()) +"</td>\r\n"
					+ "         </tr>\r\n"
					+ "         \r\n"
					+ "         </table>"		
					+ "         \r\n";
	 
					if(transByCustomer != null && !transByCustomer.isEmpty()) {
						output += "			<table>\r\n";
						
						for (Transaction t : transByCustomer) {
							output += "         <tr>\r\n"
									+ "         <td>Account No: </td>\r\n"
									+ "         <td>"+ t.getAccountNumber()+"</td>\r\n"
									+ "         </tr>\r\n"
									+ "         <tr>\r\n"
									+ "         <td>Amount: </td>\r\n"
									+ "         <td>"+ t.getAmount() +"</td>\r\n"
									+ "         </tr>\r\n"
									+ "			<tr>\r\n"
									+ "         <td>Transaction Type: </td>\r\n"
									+ "         <td>"+ t.getTransactionType() +"</td>\r\n"
									+ "         </tr>\r\n";
						}

						output += "         </table>";
					}
			response.getWriter().print(output);
		}else if (person != null) {
			String json = "{\n";
			json += "\"name\": " + JSONObject.quote(person.getCustomerName()) + ",\n";
			json += "\"Balance\": " + JSONObject.quote(String.valueOf(acc.getBalance(person.getCustomerID()))) + ",\n";
			json += "\"birthYear\": " + person.getBirthYear() + "\n";
			
			List<Transaction> transByCustomer = acc.getListTransactionsByCustomer(person.getCustomerID());
			
			if(transByCustomer != null && !transByCustomer.isEmpty()) {	
				for (int i = 0; i < transByCustomer.size(); i++) {
					Transaction t = transByCustomer.get(i);
					json += "{\"Account No\": " + JSONObject.quote(String.valueOf(t.getAccountNumber())) + ","
							+ "\"Amount\": " + JSONObject.quote(String.valueOf(t.getAmount())) + ","
							+ "\"Transaction Type\": " + JSONObject.quote(String.valueOf(t.getTransactionType())) + "}";
					
					if(i !=transByCustomer.size() - 1) {
						json += ",\n";
					}else {
						json += "\n";
					}
				}
			}
			json += "}";
			response.getOutputStream().println(json);
		}
	}
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		// String requestUrl = request.getRequestURI();
		String name = "";
		String initialCredit ="";
		// String name = requestUrl.substring("/customer".length()) != null && !requestUrl.substring("/customer".length()).isEmpty()?requestUrl.substring("/customer".length()):request.getParameter("name") ;
		// String initialCredit = requestUrl.substring("/customer/".length()) != null?requestUrl.substring(requestUrl.indexOf("/customer/"), requestUrl.indexOf("&")):request.getParameter("initialCredit") ;
		
		Enumeration<String> parameterNames = request.getParameterNames();
		 
        while (parameterNames.hasMoreElements()) {
 
            String paramName = parameterNames.nextElement();
 
            if(paramName.equalsIgnoreCase("name")) {
            	name = request.getParameter(paramName) ;
            }else if (paramName.equalsIgnoreCase("initialCredit")) {
            	initialCredit = request.getParameter("initialCredit");
            }
 
        }
		
		CustomerIF c = new CustomerImpl();
		
		Customer person = c.getCustomer(name);
		
		AccountIF acc = new AccountImpl();
		
		// Double balance = acc.getBalance(person.getCustomerID());
		acc.addAccount(Double.valueOf(initialCredit), AccountType.CURRENT, null, person.getCustomerID());
		if(Double.valueOf(initialCredit) != 0) {
			TransactionIF trans = new TransactionImpl();
			trans.addTransaction(TransactionType.DEBIT, 10, acc.getAccountNo(), person.getCustomerID());
		}
		response.getOutputStream().println("Account added successfully");
	}


}
