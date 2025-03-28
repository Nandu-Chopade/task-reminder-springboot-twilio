package com.taskmanager.services;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.ValidationRequest;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class TwilioValidationService {

    @Value("${twilio.account.sid}")
    private String accountSid;

    @Value("${twilio.auth.token}")
    private String authToken;

    /**
     * Verifies a phone number for outbound calls/SMS in Twilio.
     * If you want to verify a WhatsApp number in the Sandbox,
     * you still need to join via the Twilio-provided Sandbox number.
     *
     * @param phoneNumber E.164 format (e.g., +918788779605)
     */
    public void verifyPhoneNumber(String phoneNumber) {
        // Initialize Twilio with your credentials
        Twilio.init(accountSid, authToken);

        // Create a validation request for the given phone number
        ValidationRequest validationRequest = ValidationRequest
                .creator(new PhoneNumber(phoneNumber))
                .setFriendlyName("My Personal Number")
                .create();

        // Print the Account SID or other info for debugging
        System.out.println("Validation Request created. Account SID: " + validationRequest.getAccountSid());
    }
}
