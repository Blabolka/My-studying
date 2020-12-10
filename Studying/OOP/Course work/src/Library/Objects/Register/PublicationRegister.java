package Library.Objects.Register;

import Library.Objects.Publications.Publication;

import java.util.ArrayList;
import java.util.List;

public class PublicationRegister implements IRegister<Publication> {

    private final List<Publication> publicationRegister;

    public PublicationRegister() {
        this.publicationRegister = new ArrayList<>();
    }

    public void add(Publication publication){
        publicationRegister.add(publication);
    }

    public boolean remove(String id){
        return publicationRegister.removeIf(p -> (id.equals(p.getId()) && p.isInLibrary()));
    }

    public boolean checkIfExist(Publication publication){
        for (Publication p : publicationRegister) {
            if(publication.getId().equals(p.getId())){
                return true;
            }
        }
        return false;
    }

    public List<Publication> getRegister(){
        return new ArrayList<>(publicationRegister);
    }

    public int indexOf(String publicationId){
        for (int i = 0; i < publicationRegister.size(); i++) {
            if(publicationRegister.get(i).getId().equals(publicationId)){
                return i;
            }
        }
        return -1;
    }
}
