package Library.Objects.Register;

import Library.Objects.Publications.Publication;

import java.util.ArrayList;
import java.util.List;

public class Register {

    private final List<Publication> publications;

    public Register(){
        publications = new ArrayList<>();
    }

    public void addWithChecking(Publication publication){
        if(!isInLibrary(publication)){
            publications.add(publication);
        }else{
            System.out.println("This publication is already in the library!");
        }
    }

    public Publication deletePublication(String title){
        Publication publication = null;
        for (int i = 0; i < publications.size(); i++) {
            if(publications.get(i).getTitle().equals(title)){
                publication = publications.remove(i);
                break;
            }
        }
        return publication;
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
