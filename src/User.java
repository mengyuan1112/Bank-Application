public class User {
    private String userId;
    private int checkingAccount;
    private int savingAccount;
    private String message = "";

    User(String UserId, int checkingAccount, int savingAccount){
        this.userId = UserId;
        this.checkingAccount = checkingAccount;
        this.savingAccount = checkingAccount;
    }

    public String getUserId(){
        return this.userId;
    }

    public int getSavingAccount(){
      return this.savingAccount;
    }

    public int getCheckingAccount(){
        return this.checkingAccount;
    }

    public void checkingAccountWithDraw(int money){
        checkingAccount-=money;
    }
    public void checkingAccountDeposit(int money){
        checkingAccount+=money;
    }

    public void savingAccountWithDraw(int money){
        savingAccount-=money;
    }
    public void savingAccountDeposit(int money){
        savingAccount+=money;
    }
}
