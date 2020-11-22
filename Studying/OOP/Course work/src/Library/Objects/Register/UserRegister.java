package Library.Objects.Register;

import Library.Objects.Persons.User;

import java.util.ArrayList;
import java.util.List;

public class UserRegister {

    private final List<User> users;

    public UserRegister(){
        users = new ArrayList<>();
    }

    public boolean add(User user){
        boolean status;
        if(!isInRegister(user)){
            users.add(user);
            status = true;
        }else{
            status = false;
        }
        return status;
    }

    public User delete(String id){
        User user = null;
        for (int i = 0; i < users.size(); i++) {
            if(users.get(i).getId().equals(id)){
                user = users.remove(i);
            }
        }
        return user;
    }

    public List<User> getUsersList(){
        return new ArrayList<>(users);
    }

    private boolean isInRegister(User user){
        for (User u : users) {
            if(u.getId().equals(user.getId())){
                return true;
            }
        }
        return false;
    }
}
