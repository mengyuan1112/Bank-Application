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

    public void WithDraw(String account, int money){
        if(account == "Saving Account") savingAccount -= money;
        else checkingAccount-=money;
    }
    public void Deposit(String account, int money){
        if(account == "Saving Account") savingAccount+=money;
        else checkingAccount+=money;
    }

}
