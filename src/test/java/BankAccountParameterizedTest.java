import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.DayOfWeek;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

@ExtendWith(BankAccountParameterResolver.class)
public class BankAccountParameterizedTest {
  
  @ParameterizedTest
  @ValueSource(doubles = { 100, 250, 540, 1600 })
  @DisplayName("Test deposit from array amount successfully")
  public void testDepositValueSource(double amount, BankAccount bankAccount) {
    bankAccount.deposit(amount);
    System.out.println("Account Balance: " + bankAccount.getBalance());
    assertEquals(amount, bankAccount.getBalance());
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  @ParameterizedTest
  @EnumSource(value = DayOfWeek.class, names = { "TUESDAY", "THURSDAY" })
  @DisplayName("Test day starts with T")
  public void testDayOfWeek(DayOfWeek day) {
    assertTrue(day.toString().startsWith("T"));
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  @ParameterizedTest
  @CsvSource({ "100, Mary", "250, Peter", "480, Joe", "800, Jeremy", "1340, Hary" })
  @DisplayName("Test deposit and name from CSV source successfully")
  public void testDepositAndNameFromCSV(double amount, String name, BankAccount bankAccount) {
    assumeTrue(bankAccount != null && bankAccount.isActive(), "Bank account is not active or null");
    bankAccount.deposit(amount);
    bankAccount.setHolderName(name);
    assertAll(
        () -> assertEquals(amount, bankAccount.getBalance()),
        () -> assertEquals(name, bankAccount.getHolderName())
    );
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  @ParameterizedTest
  @CsvFileSource(resources = "details.csv")
  @DisplayName("Test deposit and name from CSV file successfully")
  public void testDepositAndNameFromCSVFile(double amount, String name, BankAccount bankAccount) {
    assumeTrue(bankAccount != null && bankAccount.isActive(), "Bank account is not active or null");
    bankAccount.deposit(amount);
    bankAccount.setHolderName(name);
    assertAll(
        () -> assertEquals(amount, bankAccount.getBalance()),
        () -> assertEquals(name, bankAccount.getHolderName())
    );
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
}
