import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Nested;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BankAccountNestedTest {
  
  //-------------------------------------------------------------------------------------------------------------------
  
  @Test
  @DisplayName("Test withdraw $500 successfully")
  public void testWithdraw() {
    BankAccount bankAccount = new BankAccount(500, -100);
    bankAccount.withdraw(300);
    assertEquals(200, bankAccount.getBalance());
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  @Test
  @DisplayName("Test deposit $400 successfully")
  public void testDeposit() {
    BankAccount bankAccount = new BankAccount(400, -100);
    bankAccount.deposit(400);
    assertEquals(800, bankAccount.getBalance());
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  @Nested
  class BankAccountInnerClass {
    
    @Test
    @DisplayName("Test withdraw below minimum balance: exception")
    public void testWithdrawBelowMinimumBalance() {
      BankAccount bankAccount = new BankAccount(200, 0);
      assertThrows(RuntimeException.class, () -> bankAccount.withdraw(300));
    }
    
    //-----------------------------------------------------------------------------------------------------------------
    
    @Test
    @DisplayName("Test withdraw and get a negative balance")
    public void testWithdrawMinimumBalanceNegative1000() {
      BankAccount bankAccount = new BankAccount(0, -1000);
      bankAccount.withdraw(300);
      assertEquals(-300, bankAccount.getBalance(), 0.01);
    }
    
    //-----------------------------------------------------------------------------------------------------------------
    
  }
  
  //-------------------------------------------------------------------------------------------------------------------

}
