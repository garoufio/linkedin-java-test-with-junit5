import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BankAccountOrderedExecutionTest {

  static BankAccount bankAccount = new BankAccount(0, 0);
  
  //-------------------------------------------------------------------------------------------------------------------
  
  @Test
  @DisplayName("Test withdraw $300 successfuly")
  @Order(2)
  public void testWithdraw() {
    bankAccount.withdraw(300);
    assertEquals(200, bankAccount.getBalance());
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  @Test
  @DisplayName("Test deposit $500 successfully")
  @Order(1)
  public void testDeposit() {
    bankAccount.deposit(500);
    assertEquals(500, bankAccount.getBalance());
  }
  
  //-------------------------------------------------------------------------------------------------------------------

}
