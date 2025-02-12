import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

@ExtendWith(BankAccountParameterResolver.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BankAccountDITest {
  
  @Test
  @DisplayName("Test withdraw below minimum balance")
  @Order(2)
  public void testWithdraw(BankAccount bankAccount) {
    assumeTrue(bankAccount != null);
    assertThrows(RuntimeException.class, () -> bankAccount.withdraw(500));
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  @Test
  @DisplayName("Test deposit $600 successfully")
  @Order(1)
  public void testDeposit(BankAccount bankAccount) {
    assumeTrue(bankAccount != null);
    bankAccount.deposit(600);
    assertEquals(600, bankAccount.getBalance());
  }
  
  //-------------------------------------------------------------------------------------------------------------------

}
