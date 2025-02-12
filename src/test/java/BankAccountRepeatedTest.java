import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(BankAccountParameterResolver.class)
public class BankAccountRepeatedTest {
  
  public static double amount = 100;
  
  @RepeatedTest(5)
  @DisplayName("Test deposit repeatedly for 5 times")
  public void bankAccountRepeatedDepositTest(BankAccount bankAccount, RepetitionInfo repetitionInfo) {
    double deposit = amount * repetitionInfo.getCurrentRepetition();
    bankAccount.deposit(deposit);
    assertEquals(deposit, bankAccount.getBalance());
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
}
