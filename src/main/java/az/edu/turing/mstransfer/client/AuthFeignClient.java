package az.edu.turing.mstransfer.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@Service
@FeignClient(name = "ms-auth", url = "http://localhost:8082")
public interface AuthFeignClient {

    @GetMapping("/finCode")
    String getFinCode(@RequestHeader("Authorization") String authToken);
}
