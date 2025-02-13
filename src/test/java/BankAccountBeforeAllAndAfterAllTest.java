import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

// To be used if we want not to declare static methods
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BankAccountBeforeAllAndAfterAllTest {
  
  static BankAccount bankAccount;
  
  //-------------------------------------------------------------------------------------------------------------------

  @BeforeAll
  public void init() { // to be used with @TestInstance
  //public static void init() {
    System.out.println("Test initialization");
    bankAccount = new BankAccount(500, -500);
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  @AfterAll
  public void end() { // to be used with @TestInstance
  //public static void end() {
    System.out.println("Test end");
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  @Test
  @DisplayName("Test deposit $100 successfully")
  @Order(1)
  public void testDeposit() {
    bankAccount.deposit(100);
    assertEquals(600, bankAccount.getBalance());
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  @Test
  @DisplayName("Test withdraw $500 successfully")
  @Order(2)
  public void testWithdraw() {
    bankAccount.withdraw(500);
    assertEquals(100, bankAccount.getBalance());
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  @Test
  @DisplayName("Test withdraw $800 unsuccessfully: exception")
  @Order(3)
  public void testWithdrawWithException() {
    assertThrows(RuntimeException.class, () -> bankAccount.withdraw(800));
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
}
