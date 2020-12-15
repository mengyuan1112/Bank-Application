import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Class contains all user Information
 */
public class BankAccount {
    static List<User> userList = new ArrayList<>();

    static private User user;

    public void addToList(User user){
        userList.add(user);
    }

    public User getUser(String id){
        for(int i = 0; i < userList.size(); i++){
            User userId = userList.get(i);
            if(userId.getUserId().equals(id)){
                user = userId;
                return user;
            }
        }
        return null;
    }

    public User getUser(){
        return user;
    }



}
