public class BankAccount {
  
  public static final int ACCOUNT_NUMBER_LENGTH = 6;
  
  private double balance;
  private double minimumBalance;
  private boolean isActive;
  private String accountNumber;
  private String holderName;
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public BankAccount(double balance, double minimumBalance) {
    this.balance = balance;
    this.minimumBalance = minimumBalance;
    this.isActive = true;
    this.accountNumber = createAccountNumber();
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public BankAccount(String holderName, double balance, double minimumBalance) {
    this(balance, minimumBalance);
    this.holderName = holderName;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public double getBalance() {
    return balance;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public void setBalance(double balance) {
    this.balance = balance;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public double getMinimumBalance() {
    return minimumBalance;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public void setMinimumBalance(double minimumBalance) {
    this.minimumBalance = minimumBalance;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public boolean isActive() {
    return isActive;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public void setActive(boolean active) {
    isActive = active;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public String getAccountNumber() {
    return accountNumber;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public void setAccountNumber(String accountNumber) {
    this.accountNumber = accountNumber;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public String getHolderName() {
    return holderName;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public void setHolderName(String holderName) {
    this.holderName = holderName;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  private String createAccountNumber() {
    StringBuilder accountNumber = new StringBuilder(ACCOUNT_NUMBER_LENGTH);
    for (int i = 0; i < ACCOUNT_NUMBER_LENGTH; i++) {
      accountNumber.append((int)(Math.random() * (9 - 0 + 1)));
    }
    return accountNumber.toString();
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  @Override
  public String toString() {
    return "BankAccount {" +
        "balance = " + balance + "\n" +
        "minimumBalance = " + minimumBalance + "\n" +
        "isActive = " + isActive + "\n" +
        "accountNumber = " + accountNumber + "\n" +
        "holderName = " + holderName + "\n" +
        "}";
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public double deposit(double amount) {
//    // only for test with assertTimeout
//    try {
//      Thread.sleep(2000);
//    }
//    catch (InterruptedException e) {
//      e.printStackTrace();
//    }
    return balance += amount;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public double withdraw(double amount) {
    if (balance - amount > minimumBalance) {
      return balance -= amount;
    }
    else {
      throw new RuntimeException("Insufficient balance");
    }
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
}
