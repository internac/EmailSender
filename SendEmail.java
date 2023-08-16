package email;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.*;

public class SendEmail {
    public static void main(String[] args) {
        // Your email address and application-specific password
        final String username = "melaniemauricechamoun@gmail.com"; // Your email
        final String password = "ojntrjiuaslvfgcc"; // Your email password

        // Set up email configuration properties
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true"); // Enable authentication
        props.put("mail.smtp.starttls.enable", "true"); // Enable STARTTLS for secure communication
        props.put("mail.smtp.host", "smtp.gmail.com"); // Using Gmail's SMTP server
        props.put("mail.smtp.port", "587"); // Corrected port for STARTTLS
        props.put("mail.smtp.ssl.trust", "smtp.gmail.com"); // Specify hostname for SSL certificate validation
        props.put("mail.smtp.ssl.protocols", "TLSv1.2"); // Specify SSL/TLS protocol version(s)

        // Create a session with configured properties and authentication
        Session session = Session.getInstance(props,
            new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, password);
                }
            });

        try {
            // Create the email message
        	Scanner scan= new Scanner(System.in);
        	System.out.println("Please enter the email that will receive the mail");
        	String email = scan.nextLine();
        	System.out.println("Please enter the subject of the mail");
        	String sub = scan.nextLine();
        	System.out.println("Please enter the body of the mail");
        	String body = scan.nextLine();
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("melaniemauricechamoun@gmail.com")); // Set sender's email address
            message.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse(email)); // Set recipient's email address
            message.setSubject(sub); // Set email subject
            message.setText(body); // Set email content

            // Send the email
            Transport.send(message);

            System.out.println("Email sent successfully.");
            scan.close();

        } catch (MessagingException e) {
            // Handle exceptions by throwing a runtime exception with the caught exception
            throw new RuntimeException(e);
        }
    }
}
