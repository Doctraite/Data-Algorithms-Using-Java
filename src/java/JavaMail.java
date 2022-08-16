import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class JavaMail {
    
    public static void sendMail(String recepient) throws MessagingException{
        System.out.println("Preparing to send email");
        Properties properties = new Properties(); 
    
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        
        String myAccountEmail = "example@gmail.com";
        String password = "adminpass";
        
        Session session = Session.getInstance(properties, new Authenticator() {
            
           
                    
                protected PasswordAuthentication getPasswordAuthentication(){
                
                    return new PasswordAuthentication(myAccountEmail, password);
                }
                                       
                    });
        
                    Message message = prepareMessage(session, myAccountEmail, recepient);
                    Transport.send(message);
                    System.out.println("Message sent successfully");
    }

    private static Message prepareMessage(Session session, String myAccountEmail, String recepient) {
    try{
        
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(myAccountEmail));
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
        message.setSubject("Password Reset");
        message.setText("Password reset utility!!");
        return message;
        
        
    }catch (Exception e){
        
        e.printStackTrace();
    
    }
        return null;
    }

}
