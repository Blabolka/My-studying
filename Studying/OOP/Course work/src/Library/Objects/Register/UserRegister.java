package Library.Objects.Register;

import Library.Objects.Persons.User;

import java.util.ArrayList;
import java.util.List;

public class UserRegister implements IRegister<User> {

    private final List<User> userRegister;

    public UserRegister(){
        userRegister = new ArrayList<>();
    }

    public void add(User user){
        userRegister.add(user);
    }

    public boolean remove(String id){
        return userRegister.removeIf(u -> (id.equals(u.getId()) && u.getTakenPublicationsId().size() == 0));
    }

    public boolean checkIfExist(User user){
        for (User u : userRegister) {
            if(user.getId().equals(u.getId())){
                return true;
            }
        }
        return false;
    }

    public List<User> getRegister(){
        return new ArrayList<>(userRegister);
    }

    public int indexOf(String userId){
        for (int i = 0; i < userRegister.size(); i++) {
            if(userRegister.get(i).getId().equals(userId)){
                return i;
            }
        }
        return -1;
    }
}
