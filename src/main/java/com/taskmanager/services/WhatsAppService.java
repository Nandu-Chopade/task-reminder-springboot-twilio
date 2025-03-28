package com.taskmanager.services;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class WhatsAppService {

    @Value("${twilio.account.sid}")
    private String accountSid;

    @Value("${twilio.auth.token}")
    private String authToken;

    @Value("${twilio.whatsapp.number}")
    private String twilioWhatsAppNumber;

    public void sendWhatsAppMessage(String to, String messageBody) {
        Twilio.init(accountSid, authToken);
        Message message = Message.creator(
                new com.twilio.type.PhoneNumber("whatsapp:" + to),
                new com.twilio.type.PhoneNumber("whatsapp:" + twilioWhatsAppNumber),
                messageBody
        ).create();

        System.out.println("WhatsApp Message Sent: " + message.getSid());
    }
}
