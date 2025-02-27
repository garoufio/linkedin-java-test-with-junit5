import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolver;
import org.junit.jupiter.api.extension.ExtensionContext;

public class BankAccountParameterResolver implements ParameterResolver {
  
  @Override
  public boolean supportsParameter(
      ParameterContext parameterContext,
      ExtensionContext extensionContext
  ) throws ParameterResolutionException {
    return parameterContext.getParameter().getType() == BankAccount.class;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  @Override
  public Object resolveParameter(
      ParameterContext parameterContext,
      ExtensionContext extensionContext
  ) throws ParameterResolutionException {
    return new BankAccount("John Smith", 0, 0);
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
}
