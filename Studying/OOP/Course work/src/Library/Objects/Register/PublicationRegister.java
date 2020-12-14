package Library.Objects.Register;

import Library.Objects.Publications.Publication;

import java.util.ArrayList;
import java.util.List;

public class PublicationRegister {

    private final List<Publication> list;

    public PublicationRegister() {
        this.list = new ArrayList<>();
    }

    public void add(Publication publication){
        list.add(publication);
    }

    public boolean remove(String id){
        return list.removeIf(p -> (id.equals(p.getId()) && p.isInLibrary()));
    }

    public boolean checkIfExist(Publication publication){
        for (Publication p : list) {
            if(publication.getId().equals(p.getId())){
                return true;
            }
        }
        return false;
    }

    public List<Publication> getRegister(){
        return new ArrayList<>(list);
    }

    public int indexOf(String publicationId){
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getId().equals(publicationId)){
                return i;
            }
        }
        return -1;
    }
}
