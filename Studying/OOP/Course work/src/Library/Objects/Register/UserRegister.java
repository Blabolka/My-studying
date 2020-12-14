package Library.Objects.Register;

import Library.Objects.Persons.User;

import java.util.ArrayList;
import java.util.List;

public class UserRegister {

    private final List<User> list;

    public UserRegister(){
        list = new ArrayList<>();
    }

    public void add(User user){
        list.add(user);
    }

    public boolean remove(String id){
        return list.removeIf(u -> (id.equals(u.getId()) && u.getTakenPublicationsId().size() == 0));
    }

    public boolean checkIfExist(User user){
        for (User u : list) {
            if(user.getId().equals(u.getId())){
                return true;
            }
        }
        return false;
    }

    public List<User> getRegister(){
        return new ArrayList<>(list);
    }

    public int indexOf(String userId){
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getId().equals(userId)){
                return i;
            }
        }
        return -1;
    }

}
