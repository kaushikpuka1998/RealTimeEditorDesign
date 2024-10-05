package Entities;

import services.DocumentService;

public class Collaboratorditor {

    private DocumentService document;

    public Collaboratorditor(DocumentService document){
        this.document = document;
    }

    public void addCollaborator(User user){
        this.document.addCollaboartor(user);
    }

    public void removeCollaborator(User user){
        this.document.removeCollaborator(user);
    }

    public void editDocument(String editString){
        document.editDocument(editString);
    }

}
