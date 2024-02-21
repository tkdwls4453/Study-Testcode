package sample.cafekiosk.spring.api.service.mail;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sample.cafekiosk.spring.client.mail.MailSendClient;
import sample.cafekiosk.spring.domain.history.mail.MailHistory;
import sample.cafekiosk.spring.domain.history.mail.MailSendHistoryRepository;

@RequiredArgsConstructor
@Service
public class MailService {

    private final MailSendClient mailSendClient;
    private final MailSendHistoryRepository mailSendHistoryRepository;
    public boolean sendMail(String fromEmail, String email, String subject, String content) {

        boolean result = mailSendClient.sendMail(fromEmail, email, subject, content);

        if(result){
            mailSendHistoryRepository.save(MailHistory.builder()
                    .fromEmail(fromEmail)
                    .email(email)
                    .subject(subject)
                    .content(content)
                    .build());
            return true;
        }
        return false;
    }
}
