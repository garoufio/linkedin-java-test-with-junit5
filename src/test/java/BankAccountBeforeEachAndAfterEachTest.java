import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BankAccountBeforeEachAndAfterEachTest {
  
  BankAccount bankAccount;
  static int testCount = 0;
  
  //-------------------------------------------------------------------------------------------------------------------
  
  @BeforeEach
  public void init() {
    System.out.printf("Test%d initialization\n", ++testCount);
    bankAccount = new BankAccount(500, -500);
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  @AfterEach
  public void end() {
    System.out.printf("Test%d end\n", testCount);
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  @Test
  @DisplayName("Test deposit $100 successfully")
  public void testDeposit() {
    bankAccount.deposit(100);
    assertEquals(600, bankAccount.getBalance());
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  @Test
  @DisplayName("Test withdraw $500 successfully")
  public void testWithdraw() {
    bankAccount.withdraw(500);
    assertEquals(0, bankAccount.getBalance());
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  @Test
  @DisplayName("Test withdraw $1800 unsuccessfully: exception")
  public void testWithdrawWithException() {
    assertThrows(RuntimeException.class, () -> bankAccount.withdraw(1800));
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
}
