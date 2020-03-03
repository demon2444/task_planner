package pl.coderslab.springbootproject.mail;

import org.springframework.mail.MailSender;
import pl.coderslab.springbootproject.model.Email;

public interface EmailService {

    public void sendMessage(Email email);
    public void sendPlan(Email email);

}
