package ussd.sample;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

/**
 * Servlet implementation class UssdHandler
 */
@WebServlet("/UssdHandler")
public class UssdHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
		// Set the output character encoding
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		// Set the output printer
		PrintWriter out = response.getWriter();

		try{
			// Variable holding the ussd response
			UssdResponse ussdResponse = new UssdResponse();
			
			// Receive the Ussd request raw data
			StringBuilder requestBuffer = new StringBuilder();
			String lineRead;
			while((lineRead = request.getReader().readLine()) != null){
			    requestBuffer.append(lineRead);
			}
			
			// Parse the request raw data into the UssdRequest Object for better manipulation
			// since the request raw data comes in a json format.
			Gson gson = new Gson();
			UssdRequest ussdRequest = gson.fromJson(requestBuffer.toString(), UssdRequest.class);
			
			// Process the Ussd request
			if(ussdRequest != null){
				
				System.out.println("Ussd Request " + ussdRequest.toString());
				// check the various request type
				if(ussdRequest.getType().equals("Initiation")){
					// Set the ussd response
					ussdResponse.setType("Response");
					ussdResponse.setMessage("Welcome to Freebie Service.\n 1. Free Food\n2. Free Drink\n3. Free Airtime");
				}
				else if(ussdRequest.getType().equals("Response")){
					// response case studies
					if(!ussdRequest.getMessage().isEmpty()){
						
						// check whether the lcient state is sent
						if(ussdRequest.getClientState() == null){
							
							// Free food is chosen
							if(ussdRequest.getMessage().equals("1")){
								ussdResponse.setMessage("Are you sure you want free food?\n1. Yes\n2. No");
								ussdResponse.setType("Response");
								ussdResponse.setClientState("FF");						
							}
							
							// Free drink is chosen
							else if(ussdRequest.getMessage().equals("2")){
								ussdResponse.setMessage("Are you sure you want free drink?\n1. Yes\n2. No");
								ussdResponse.setType("Response");
								ussdResponse.setClientState("FD");						
							}
							
							// Free airtime is chosen
							else if(ussdRequest.getMessage().equals("3")){
								ussdResponse.setMessage("Are you sure you want free airtime?\n1. Yes\n2. No");
								ussdResponse.setType("Response");
								ussdResponse.setClientState("FA");						
							}
							else{
								ussdResponse.setMessage("Invalid Option");
								ussdResponse.setType("Release");
							}
						}
						else{
							// The client state is resent back to us
							if(ussdRequest.getClientState().equals("FF") && ussdRequest.getMessage().equals("1")){
								ussdResponse.setMessage("Thank you. You will receive your free food shortly.");
								ussdResponse.setType("Release");
							}
							else if(ussdRequest.getClientState().equals("FD") && ussdRequest.getMessage().equals("1")){
								ussdResponse.setMessage("Thank you. You will receive your free drink shortly.");
								ussdResponse.setType("Release");							
							}
							else if(ussdRequest.getClientState().equals("FA") && ussdRequest.getMessage().equals("1")){
								ussdResponse.setMessage("Thank you. You will receive your free airtime shortly.");
								ussdResponse.setType("Release");							
							}						
							else if(ussdRequest.getMessage().equals("2")){
								ussdResponse.setMessage("Order Cancelled.");
								ussdResponse.setType("Release");
							}
							else{
								ussdResponse.setMessage("Unexpected Response.");
								ussdResponse.setType("Release");							
							}						
						}
					}
					else{
						ussdResponse.setMessage("Invalid option.");
						ussdResponse.setType("Release");					
					}
				}
			}else{
				ussdResponse.setMessage("Duh.");
				ussdResponse.setType("Release");								
			}
			
			System.out.println("Ussd response : " +ussdResponse.toString());
			String responseJson = gson.toJson(ussdResponse);
			out.print(responseJson);
		}
		catch(Exception e){
			// Send at least a message to the user in case of errors
			try{
				Gson gson = new Gson();
				UssdResponse ussdResponse = new UssdResponse();
				ussdResponse.setMessage("Invalid request");
				ussdResponse.setType("Release");
				String responseJson = gson.toJson(ussdResponse);
				out.print(responseJson);							
			}
			catch(Exception ex){
				ex.printStackTrace();
			}
			e.printStackTrace();
		}
		finally{
			out.close();
		}		
	}

}
