import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UserList {
    private List<User> userList = new ArrayList<>();

//    UserList(User user){
//        userList.add(user);
//    }

    public void addToList(User user){
        userList.add(user);
    }


    public User getUser(String id){
        for(int i = 0; i < userList.size(); i++){
            User user = userList.get(i);
            if(user.getUserId().equals(id)){
                return user;
            }
        }
        return null;
    }

}
