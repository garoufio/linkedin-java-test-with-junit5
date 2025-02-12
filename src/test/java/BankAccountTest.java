import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.time.Duration;

//import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTimeout;

public class BankAccountTest {

  @Test
  @DisplayName("Withdraw $300 successfully")
  public void testWithDraw300WithSuccess() {
    BankAccount bankAccount = new BankAccount(500, 0);
    bankAccount.withdraw(300);
    assertEquals(200, bankAccount.getBalance());
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  @Test
  @DisplayName("Cannot withdraw below minimum balance")
  public void testWithDraw500WithoutSuccess() {
    BankAccount bankAccount = new BankAccount(200, -100);
    assertThrows(
        RuntimeException.class,
        () -> bankAccount.withdraw(500),
        "Withdraw $500 successfully. Check balance."
    );
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  @Test
  @DisplayName("Withdraw will become negative")
  public void testWithdrawNotStuckAtZero() {
    BankAccount bankAccount = new BankAccount(500, -500);
    bankAccount.withdraw(800);
    assertNotEquals(0, bankAccount.getBalance());
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  @Test
  @DisplayName("Deposit $800 successfully")
  public void testDeposit800() {
    BankAccount bankAccount = new BankAccount(200, -200);
    bankAccount.deposit(800);
    assertEquals(1000, bankAccount.getBalance(), "Insufficient balance");
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  @Test
  @DisplayName("Test activation of account after its creation")
  public void testActiveAccountAfterCreation() {
    BankAccount bankAccount = new BankAccount(500, -200);
    assertTrue(bankAccount.isActive());
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  @Test
  @DisplayName("Test inactivation of account")
  public void testInactiveAccount() {
    BankAccount bankAccount = new BankAccount(500, -200);
    bankAccount.setActive(false);
    assertFalse(bankAccount.isActive());
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  @Test
  @DisplayName("Test not null holder name")
  public void testHolderNameNotNull() {
    BankAccount bankAccount = new BankAccount("John Smith", 500, -200);
    assertNotNull(bankAccount.getHolderName());
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  @Test
  @DisplayName("Test holder name with set method")
  public void testSetHolderName() {
    BankAccount bankAccount = new BankAccount(500, -200);
    bankAccount.setHolderName("John Smith");
    assertEquals("John Smith", bankAccount.getHolderName());
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  @Test
  @DisplayName("Test no exceptions for withdraw and deposit")
  public void testWithdrawAndDepositWithoutExceptions() {
    BankAccount bankAccount = new BankAccount(500, -1000);
    //fail("Must not enter this exception");
    assertAll(() -> bankAccount.deposit(200), () -> bankAccount.withdraw(450));
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  @Test
  @DisplayName("Test speed deposit")
  public void testDepositTimeout() {
    BankAccount bankAccount = new BankAccount(400, 0);
    // should sleep the deposit method
    assertTimeout(Duration.ofNanos(10), () -> bankAccount.deposit(200));
  }
  
  //-------------------------------------------------------------------------------------------------------------------

}
