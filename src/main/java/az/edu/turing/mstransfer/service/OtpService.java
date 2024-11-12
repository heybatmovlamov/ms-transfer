package az.edu.turing.mstransfer.service;

import lombok.RequiredArgsConstructor;

import java.util.Random;
import java.util.random.RandomGenerator;
@RequiredArgsConstructor

public class OtpService {
    private final RandomGenerator randomGenerator = new Random();

    public Integer otpGenerator(){
       return  1000 + randomGenerator.nextInt(9000);
    }


}
