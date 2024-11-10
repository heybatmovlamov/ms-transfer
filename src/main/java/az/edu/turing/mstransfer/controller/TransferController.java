package az.edu.turing.mstransfer.controller;

import az.edu.turing.mstransfer.model.TransferRequest;
import az.edu.turing.mstransfer.service.AccountService;
import az.edu.turing.mstransfer.service.AuthService;
import az.edu.turing.mstransfer.service.TransferService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor

public class TransferController {
    private final AuthService authService;
    private final TransferService transferService;

    @PostMapping("/transfer")
    public ResponseEntity<TransferRequest> transferMoney(
            @RequestHeader("Authorization") String auth,
            @Valid @RequestBody TransferRequest requestDto
    ) {
        String finCode = authService.getFinCodeFromAuth(auth);  // ms-auth ilə finCode əldə olunur
        return ResponseEntity.ok(transferService.transfer(finCode, requestDto));
    }

}
