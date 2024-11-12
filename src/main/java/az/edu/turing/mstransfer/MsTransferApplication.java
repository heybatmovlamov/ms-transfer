package az.edu.turing.mstransfer;

import az.edu.turing.mstransfer.service.OtpService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class MsTransferApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsTransferApplication.class, args);
    }
}
