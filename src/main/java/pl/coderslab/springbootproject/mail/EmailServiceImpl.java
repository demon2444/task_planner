package pl.coderslab.springbootproject.mail;

import org.springframework.mail.SimpleMailMessage;
import pl.coderslab.springbootproject.model.Email;

public class EmailServiceImpl implements EmailService {

    @Override
    public void sendMessage(Email email) {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email.getTo());
        message.setSubject(email.getTitle());
        message.setReplyTo(email.getReply());
        message.setText(email.getText());

    }

    @Override
    public void sendPlan(Email email) {

    }
}
