import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertAll;

@Execution(ExecutionMode.CONCURRENT)
@ExtendWith(BankAccountParameterResolver.class)
public class BankAccountParallelExecutionTest {
  
  @ParameterizedTest
  @CsvSource({ "400, Mary", "550, Jonathan", "1100, Margot", "2000, Peter" })
  @DisplayName("Test deposit and set holder name successfully from a CSV source")
  public void testDepositFromCSVSource(double amount, String name, BankAccount bankAccount) {
    try {
      Thread.sleep(500);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    
    Executable execSetHolderName = () -> {
      bankAccount.setHolderName(name);
      assertEquals(name, bankAccount.getHolderName());
    };
    Executable execDepositAmount = () -> {
      bankAccount.deposit(amount);
      assertEquals(name, bankAccount.getHolderName());
    };
    assertAll(execSetHolderName, execDepositAmount);
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  @ParameterizedTest
  @CsvFileSource(resources = "details.csv")
  @DisplayName("Test deposit and set holder name successfully from a CSV file")
  public void testDepositFromCSVFile(double amount, String name, BankAccount bankAccount) {
    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    
    Executable execSetHolderName = () -> {
      bankAccount.setHolderName(name);
      assertEquals(name, bankAccount.getHolderName());
    };
    Executable execDepositAmount = () -> {
      bankAccount.deposit(amount);
      assertEquals(name, bankAccount.getHolderName());
    };
    assertAll(execSetHolderName, execDepositAmount);
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  @ParameterizedTest
  @ValueSource(doubles = { 150, 430, 760, 390 })
  @DisplayName("Test withdraw amount from array successfully")
  public void testWithdrawFromArray(double amount, BankAccount bankAccount) {
    try {
      Thread.sleep(1500);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    
    bankAccount.deposit(1000);
    bankAccount.withdraw(amount);
    assertEquals(1000 - amount, bankAccount.getBalance(), 0.01);
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
}
