import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

public class BankAccountAssumptionsTest {

  @Test
  @DisplayName("Test activation of account after its creation")
  public void testActiveAccountAfterCreation0() {
    BankAccount bankAccount = new BankAccount(500, -100);
    assumeTrue(bankAccount != null);
    assertTrue(bankAccount.isActive());
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  @Test
  @DisplayName("Test activation of account after its creation")
  public void testActiveAccountAfterCreation1() {
    BankAccount bankAccount = new BankAccount(500, -100);
    assumeTrue(bankAccount == null);
    assertTrue(bankAccount.isActive());
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  @Test
  @DisplayName("Test activation of account after its creation")
  public void testActiveAccountAfterCreation2() {
    BankAccount bankAccount = null;
    assumingThat(bankAccount != null, () -> assertTrue(bankAccount.isActive()));
  }
  
  //-------------------------------------------------------------------------------------------------------------------

}
