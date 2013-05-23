package ca.servlets;

import java.io.*;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;





public class Envia extends HttpServlet {




	public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException
    {

		 String explorer=null;
		 request.setAttribute ("servletName", "servletToJsp");
		 String cos = request.getParameter("message").toString();
		 cos = cos.trim();
		 if(request.getSession().getAttribute("explorer")!=null){
		 explorer = request.getSession().getAttribute("explorer").toString();
		 }
       //envia el mail
		
		 final String username = "joaquim.orra@gmail.com";
			final String password = "sumatra82";

			Properties props = new Properties();
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.host", "smtp.gmail.com");
			props.put("mail.smtp.port", "587");



			Session session = Session.getInstance(props,
					  new javax.mail.Authenticator() {
						protected PasswordAuthentication getPasswordAuthentication() {
							return new PasswordAuthentication(username, password);
						}
					  });

			try {

				Message message = new MimeMessage(session);
				message.setFrom(new InternetAddress("hola@portamu.com"));
				message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("jordiorra@hotmail.com"));
				message.setSubject("WEB");
				message.setContent("<h1>EMAIL d'un client:</h1><br>"+cos, "text/html");
	 
				Transport.send(message);

				System.out.println("Done");

			} catch (MessagingException e) {
				e.printStackTrace();
			}
		 
		 
//		 Properties props = new Properties();
//
//		// Nombre del host de correo, es smtp.gmail.com
//		props.setProperty("mail.smtp.host", "smtp.gmail.com");
//
//		// TLS si está disponible
//		props.setProperty("mail.smtp.starttls.enable", "true");
//
//		// Puerto de gmail para envio de correos
//		props.setProperty("mail.smtp.port","587");
//
//		// Nombre del usuario
//		props.setProperty("mail.smtp.user", "joaquim.orra@gmail.com");
//
//		// Si requiere o no usuario y password para conectarse.
//		props.setProperty("mail.smtp.auth", "true");
//		 
//		Session session = Session.getDefaultInstance(props);
//		session.setDebug(true);
//		
//		MimeMessage message = new MimeMessage(session);
//		 
//		try{
//		// Quien envia el correo
//		message.setFrom(new InternetAddress("joaquim.orra@gmail.com"));
//
//		// A quien va dirigido
//		message.addRecipient(Message.RecipientType.TO, new InternetAddress("jordiorra@hotmail.com"));
//		
//		message.setSubject("Missatge de la Web");
//		
//		message.setText(
//				cos ,				
//				"html");
//		Transport t = session.getTransport("smtp");
//		t.connect();
//		t.sendMessage(message,message.getAllRecipients());
//		t.close();
//	   //fi de envia el mail
//        
//		 
//		
//    	} catch (MessagingException e) {
//    		System.out.println("error:"+e.getMessage());
//			
//		}
		 
      
        	

      
    }
	
	public void doPost(HttpServletRequest request,
            HttpServletResponse response)
throws IOException, ServletException
{
		
doGet(request, response);
}

}