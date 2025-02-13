import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

@ExtendWith(BankAccountParameterResolver.class)
public class BankAccountDisabledTest {
  
  @Test
  @DisplayName("Test deposit $400 successfully")
  @Disabled("Temporarily disabled")
  public void testDeposit(BankAccount bankAccount) {
    //bankAccount.setActive(false);
    assumeTrue(bankAccount.isActive(), "Bank account is not active");
    bankAccount.deposit(400);
    assertEquals(400, bankAccount.getBalance(), 0.01);
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
}
