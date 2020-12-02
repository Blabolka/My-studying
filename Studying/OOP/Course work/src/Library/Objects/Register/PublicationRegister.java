package Library.Objects.Register;

import Library.Objects.Publications.Publication;

import java.util.ArrayList;
import java.util.List;

public class PublicationRegister{

    private final List<Publication> publications;

    public PublicationRegister(){
        publications = new ArrayList<>();
    }

    public boolean add(Publication publication){
        boolean status;
        if(!isInRegister(publication)){
            publications.add(publication);
            status = true;
        }else{
            status = false;
        }
        return status;
    }

    public Publication delete(int index){
        return publications.remove(index);
    }

    public List<Publication> getList(){
        return new ArrayList<>(publications);
    }

    private boolean isInRegister(Publication publication){
        for (Publication p: publications) {
            if(p.getTitle().equals(publication.getTitle())){
                return true;
            }
        }
        return false;
    }
}
