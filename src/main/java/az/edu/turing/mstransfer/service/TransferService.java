package az.edu.turing.mstransfer.service;

import az.edu.turing.mstransfer.model.TransferRequest;
import az.edu.turing.mstransfer.model.dto.AccountDto;
import az.edu.turing.mstransfer.model.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TransferService {
   private final UserService userService;
   private final AccountService accountService;

    @Transactional
    public TransferRequest transfer(String finCode, TransferRequest accountTransferRequest) {
        UserDto user = userService.getUser(finCode);
        List<AccountDto> accounts = user.getAccounts();

        accounts.stream()
                .filter(a -> a.getCartNumber().equals(accountTransferRequest.getMyCartNumber()))
                .findFirst().orElseThrow(() -> new RuntimeException("Invalid cart number"));

        AccountDto myAccount = accountService
                .findByCartNumber(accountTransferRequest.getMyCartNumber())
                .orElseThrow(() -> new RuntimeException("Cart number not found"));

        AccountDto transferAccount = accountService
                .findByCartNumber(accountTransferRequest.getTransferCartNumber())
                .orElseThrow(() -> new RuntimeException("Cart number not found"));

        if (myAccount.getBalance().compareTo(accountTransferRequest.getAmount()) >= 0) {

            BigDecimal myCartNumberNewBalance = myAccount.getBalance().subtract(accountTransferRequest.getAmount());
            BigDecimal transferCartNumberNewBalance = transferAccount.getBalance().add(accountTransferRequest.getAmount());

            accountService.updateAccountBalance(myAccount.getCartNumber(), myCartNumberNewBalance);
            accountService.updateAccountBalance(transferAccount.getCartNumber(), transferCartNumberNewBalance);
        }
        return accountTransferRequest;
    }
}
