package lk.sliit.hotelManagement.service.custom.impl;

import lk.sliit.hotelManagement.dao.reservationDAO.CustomerDAO;
import lk.sliit.hotelManagement.dao.restaurantDAO.OnlineCustomerDAO;
import lk.sliit.hotelManagement.dto.manager.EmployeeDTO;
import lk.sliit.hotelManagement.dto.manager.MailDTO;
import lk.sliit.hotelManagement.dto.restaurant.restaurantOnlineOrder.RestaurantOnlineOrderDTO;
import lk.sliit.hotelManagement.dto.restaurant.restaurantOnlineOrder.RestaurantOnlineOrderDetailsDTO;
import lk.sliit.hotelManagement.entity.reservation.Customer;
import lk.sliit.hotelManagement.entity.restaurant.OnlineCustomer;
import lk.sliit.hotelManagement.service.custom.MailSend;
import lk.sliit.hotelManagement.service.custom.OnlineCustomerBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;

@Service
public class MailSendImpl implements MailSend {
    @Autowired
    OnlineCustomerDAO onlineCustomerDAO;
    @Override
    public void sendMailToNewEmployee(EmployeeDTO employeeDTO) {
        String smsSender = "mailspringitp@gmail.com";

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
            msg.setSubject("Hotel Hareesha Employee Registration");
            msg.setSentDate(new Date());
            msg.setFrom(smsSender);
            msg.setText("Sender Name: " + employeeDTO.getName() + "\n\n" +
                    "Floor Number: " + employeeDTO.getEmail() + "\n\n" +
                    "dsdsa" + employeeDTO.getPassword()
            );
            msg.setHeader("XPriority", "1");
            Transport.send(msg);
            System.out.println("Mail has been sent successfully");

        } catch (MessagingException mex) {

            System.out.println("Unable to send an email" + mex);

        }

    }

    @Override
    public void sendMailToCustomer(MailDTO mailDTO) {
        String smsSender ="mailspringitp@gmail.com";

        String to =  "sendsender6@gmail.com";;

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


            msg.setSubject("Hotel Hareesha Online Mail");
            msg.setSentDate(new Date());
            msg.setFrom(smsSender);


            msg.setText("Sender Name: " + mailDTO.getName() + "\n\n" +
                    "Floor Number: " + mailDTO.getEmail() + "\n\n" +
                    "Floor Number: " + mailDTO.getCustomerName() + "\n\n" +
                    "dsdsa" + mailDTO.getMessage()
            );


            msg.setHeader("XPriority", "1");

            Transport.send(msg);

            System.out.println("Mail has been sent successfully");

        } catch (MessagingException mex) {

            System.out.println("Unable to send an email" + mex);

        }
    }

    @Override
    public void sendMailToOnlineCustomer(RestaurantOnlineOrderDTO onlineOrderDTO) {

         String smsSender = "mailspringitp@gmail.com";
        OnlineCustomer s = onlineCustomerDAO.findOne(onlineOrderDTO.getCustomer());
        String to = s.getEmail();




        java.util.List<RestaurantOnlineOrderDetailsDTO> list = new ArrayList<>();
        String arr = onlineOrderDTO.getOrderData();

        String yo[] = arr.split(" ");
        int count = 0;
        RestaurantOnlineOrderDetailsDTO itm = new RestaurantOnlineOrderDetailsDTO();
        for (String str : yo) {
            if (count == 0) {
                itm = new RestaurantOnlineOrderDetailsDTO();
                itm.setFoodItem(Integer.parseInt(str));
                count++;

            } else if (count == 1) {
                itm.setUnitePrice(Double.parseDouble(str));
                count++;

            } else if (count == 2) {
                itm.setQuantity(Double.parseDouble(str));
                list.add(itm);
                count = 0;
            }
        }


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
            MimeMessage msg = new MimeMessage(session);
            InternetAddress[] address = InternetAddress.parse(to, true);
            msg.setRecipients(Message.RecipientType.TO, address);
            msg.setSubject("Order Placed Successfully");
            msg.setSentDate(new Date());
            msg.setFrom(smsSender);
            msg.setText("Sender Name: " + s.getName() + "\n\n" +
                    "Your Number: " + s.getEmail() + "\n\n",
                    "Your Address: " + s.getAddress() + "\n\n"
            );
            msg.setHeader("XPriority", "1");
            Transport.send(msg);


        } catch (MessagingException mex) {

            System.out.println("Unable to send an email" + mex);

        }

    }
}