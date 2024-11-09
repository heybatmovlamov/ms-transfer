package az.edu.turing.mstransfer.client;

import az.edu.turing.mstransfer.model.TransferRequest;
import az.edu.turing.mstransfer.model.dto.AccountDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.math.BigDecimal;
import java.util.Optional;

@Service
@FeignClient(name = "ms-account", url ="http://ms-account")
public interface AccountFeignClient {
    @GetMapping("/")
     Optional<AccountDto> findByCartNumber(String cartNumber);

    @PatchMapping("/update")
    void updateAccountBalance(@ TransferRequest transferRequest, BigDecimal amount);

}
