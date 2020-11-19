package Library.Objects.Register;

import Library.Objects.Publications.Publication;

import java.util.ArrayList;
import java.util.List;

public class Register {

    private List<Publication> publications;

    public Register(){
        publications = new ArrayList<>();
    }

    public void addWithChecking(Publication publication){
        if(!isInLibrary(publication)){
            publications.add(publication);
        }else{
            System.out.println("Такое издание уже есть в библиотеке!");
        }
    }

    public int size(){
        return publications.size();
    }

    public List<Publication> getPublicationsList(){
        return new ArrayList<>(publications);
    }

    private boolean isInLibrary(Publication publication){
        for (Publication p: publications) {
            if(p.getTitle().equals(publication.getTitle())){
                return true;
            }
        }
        return false;
    }
}
