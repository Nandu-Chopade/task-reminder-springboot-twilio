package com.taskmanager.controller;


import com.taskmanager.services.TwilioValidationService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/verify")
public class PhoneVerificationController {

    private final TwilioValidationService twilioValidationService;

    public PhoneVerificationController(TwilioValidationService twilioValidationService) {
        this.twilioValidationService = twilioValidationService;
    }

    /**
     * Example endpoint to verify a phone number using TwilioValidationService.
     *
     * Usage:
     *   POST /verify?phoneNumber=+918788779605
     *
     * @param phoneNumber The phone number in E.164 format (e.g., +91XXXXXXXXXX)
     * @return A confirmation message
     */
    @PostMapping
    public String verifyNumber(@RequestParam String phoneNumber) {
        twilioValidationService.verifyPhoneNumber(phoneNumber);
        return "Verification initiated for " + phoneNumber;
    }
}
