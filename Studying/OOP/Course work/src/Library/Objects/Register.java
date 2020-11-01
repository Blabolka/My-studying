package Library.Objects;

import Library.Objects.Publications.Publication;

import java.util.ArrayList;
import java.util.List;

public class Register {
    private List<Publication> list;

    public Register(){
        list = new ArrayList<>();
    }

    public void addWithChecking(Publication publication){
        if(!isInLibrary(publication)){
            list.add(publication);
        }else{
            System.out.println("Такое издание уже есть в библиотеке!");
        }
    }

    private boolean isInLibrary(Publication publication){
        for (Publication p: list) {
            if(p.getTitle().equals(publication.getTitle())){
                return true;
            }
        }
        return false;
    }

    public int size(){
        return list.size();
    }

    public void print(){
        for (Publication publication: list) {
            System.out.println("Название: " + publication.getTitle());
        }
    }
}
