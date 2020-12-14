package Library.Objects.Register;

import Library.Objects.Persons.User;

import java.util.List;

public class UserRegisterPrinter {

    List<User> users;

    public UserRegisterPrinter(List<User> users){
        this.users = users;
    }

    public void print(){
        users.forEach(p -> System.out.println(p.getDescription()));
    }

}
