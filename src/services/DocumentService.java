package services;

import Observers.CursorPositionObserver;
import Entities.Document;
import Observers.DocumentObserver;
import Entities.User;

import java.util.ArrayList;
import java.util.HashMap;

public class DocumentService {


    Document document;

    public DocumentService(){
        document =new Document();
        document.setContent("");
        document.setCollaborators(new ArrayList<>());
        document.setVersionHistory(new ArrayList<>());
        document.setCursorPosition( new HashMap<>());
        document.setObserverList( new ArrayList<>());
    }

    public void editDocument(String newText){
        this.document.setContent(newText);
        notifyObserver();

    }

    public void addCollaboartor(User user){
        this.document.getCollaborators().add(user);
        this.document.getCursorPosition().put(user,0);
        System.out.println("User " + user.getName() + " has been added to the collaborators list");
        DocumentObserver cursorPositionObserver = new CursorPositionObserver(user);
        this.document.getObserverList().add(cursorPositionObserver);
    }

    public void removeCollaborator(User user){
        this.document.getCollaborators().remove(user);
        this.document.getCursorPosition().remove(user);
        System.out.println("User " + user.getName() + " has been removed from the collaborators list");
        DocumentObserver cursorPositionObserver = new CursorPositionObserver(user);
        this.document.getObserverList().remove(cursorPositionObserver);

    }

    public void updateCollaboartor(User user, int newPosition){
        if(!this.document.getCollaborators().contains(user)){
            System.out.println("User " + user.getName() + " is not a collaborator");
            return;
        }
        this.document.getCursorPosition().put(user,newPosition);
        System.out.println("User " + user.getName() + " :CursorPosition:"+newPosition);
        notifyObserver();
    }

    public int getUserLocation(User user){
        return this.document.getCursorPosition().getOrDefault(user,0);
    }

    public void subscribeObserver(DocumentObserver observer){
        this.document.getObserverList().add(observer);
    }

    public void unsubscribeObserver(DocumentObserver observer){
        this.document.getObserverList().remove(observer);
    }

    private void notifyObserver(){
        for(DocumentObserver observer:this.document.getObserverList()){
            observer.update(this.document);
        }
    }
}
