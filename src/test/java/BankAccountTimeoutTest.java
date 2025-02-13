import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTimeout;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

// For all tests in class
//@Timeout(value = 500, unit = TimeUnit.MILLISECONDS)
@ExtendWith(BankAccountParameterResolver.class)
public class BankAccountTimeoutTest {
  
  @Test
  @Timeout(value = 500, unit = TimeUnit.MILLISECONDS)
  @DisplayName("Test deposit timeout with annotation")
  public void testDepositTimeoutAnnotation(BankAccount bankAccount) {
    try {
      Thread.sleep(200);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    
    bankAccount.deposit(100);
    assertEquals(100, bankAccount.getBalance());
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  @Test
  @DisplayName("Test deposit timeout with assertion")
  public void testDepositTimeoutAssertion(BankAccount bankAccount) {
    // check when class timeout is set
//    try {
//      Thread.sleep(2000);
//    } catch (InterruptedException e) {
//      e.printStackTrace();
//    }
    
    assertTimeout(
        Duration.ofMillis(500),
        () -> {
          Thread.sleep(400);
          bankAccount.deposit(100);
          //assertEquals(100, bankAccount.getBalance());
        });
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
}
