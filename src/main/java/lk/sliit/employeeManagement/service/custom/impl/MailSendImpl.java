package lk.sliit.employeeManagement.service.custom.impl;

import lk.sliit.employeeManagement.dto.manager.EmployeeDTO;
import lk.sliit.employeeManagement.service.custom.MailSend;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

@Service
public class MailSendImpl implements MailSend {
    @Override
    public void sendMailToNewEmployee(EmployeeDTO employeeDTO) {
        String smsSender = "mailspringitp@gmail.com";

        //Using the Java Mail Api to send the email
        //Storing the mail address of the user which we need to send the mail
        String to = employeeDTO.getEmail();

        Properties props = new Properties();

        props.put("mail.smtp.host", "true");

        props.put("mail.smtp.starttls.enable", "true");

        props.put("mail.smtp.host", "smtp.gmail.com");

        props.put("mail.smtp.port", "587");

        props.put("mail.smtp.auth", "true");

        //Establishing a session with required user details

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {

                return new PasswordAuthentication(smsSender, "springmailitp");

            }

        });

        try {

            //Creating a Message object to set the email content

            MimeMessage msg = new MimeMessage(session);


            InternetAddress[] address = InternetAddress.parse(to, true);


            msg.setRecipients(Message.RecipientType.TO, address);


            msg.setSubject("Hotel Hareesha Emplloyee Registration");
            msg.setSentDate(new Date());
            msg.setFrom(smsSender);


            System.out.println("++Important++" + employeeDTO);

            msg.setText("Sensor Name: " + employeeDTO.getName() +"\n\n"+
                    "Floor Number: " + employeeDTO.getEmail() +"\n\n"+
                    "dsdsa" + employeeDTO.getPassword()
            );


            msg.setHeader("XPriority", "1");

            Transport.send(msg);

            System.out.println("Mail has been sent successfully");

        } catch (MessagingException mex) {

            System.out.println("Unable to send an email" + mex);

        }

    }
}