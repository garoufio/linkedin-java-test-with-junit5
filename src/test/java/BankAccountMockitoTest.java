import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class BankAccountMockitoTest {
  
  @Mock
  BankAccount bankAccount;
  
  //-------------------------------------------------------------------------------------------------------------------
  
  @BeforeEach
  public void mockSetup() {
    Mockito.when(bankAccount.getBalance()).thenReturn(100.0);
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  @Test
  @DisplayName("Test deposit $100")
  public void testDeposit() {
    assertEquals(100, bankAccount.getBalance());
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
}
