package az.edu.turing.mstransfer.listener;

import az.edu.turing.mstransfer.service.OtpService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TransferListener {
    private final OtpService otpService;

    @RabbitListener(queues = "otpQueue")
    public void processTransfer(String message) {
        String[] parts = message.split(":");
        String finCode = parts[0];
        Integer rabbitOtp = Integer.parseInt(parts[1]);

        if (otpService.validateOtp(finCode, rabbitOtp)) {
            System.out.println("Transfer uğurla tamamlandı.");
        } else {
            System.out.println("OTP təsdiqlənmədi. Transfer dayandırıldı.");
        }
    }
}