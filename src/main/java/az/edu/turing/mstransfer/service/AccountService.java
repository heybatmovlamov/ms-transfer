package az.edu.turing.mstransfer.service;

import az.edu.turing.mstransfer.client.AccountFeignClient;
import az.edu.turing.mstransfer.model.TransferRequest;
import az.edu.turing.mstransfer.model.dto.AccountDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AccountService {
    private final AccountFeignClient accountFeignClient;

    public Optional<AccountDto> findByCartNumber(String cartNumber) {
        return accountFeignClient.findByCartNumber(cartNumber);
    }

    public void updateAccountBalance(String  cartNumber , BigDecimal amount) {
        accountFeignClient.updateAccountBalance(transferRequest);
    }
}
