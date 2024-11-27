package az.edu.turing.mstransfer.model.dto;

import az.edu.turing.mstransfer.model.TransferRequest;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TransferMessage {
    private String finCode;
    private Integer otp;
    private TransferRequest transferRequest;
}
