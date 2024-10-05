package Entities;

import Observers.DocumentObserver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Document {
    private String content;
    List<User> collaborators;
    List<String> versionHistory;
    Map<User,Integer> cursorPosition;
    private List<DocumentObserver> observerList;

    public Document(){
        this.content = "";
        this.collaborators = new ArrayList<>();
        this.versionHistory = new ArrayList<>();
        this.cursorPosition = new HashMap<>();
        this.observerList = new ArrayList<>();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<User> getCollaborators() {
        return collaborators;
    }

    public void setCollaborators(List<User> collaborators) {
        this.collaborators = collaborators;
    }

    public List<String> getVersionHistory() {
        return versionHistory;
    }

    public void setVersionHistory(List<String> versionHistory) {
        this.versionHistory = versionHistory;
    }

    public Map<User, Integer> getCursorPosition() {
        return cursorPosition;
    }

    public void setCursorPosition(Map<User, Integer> cursorPosition) {
        this.cursorPosition = cursorPosition;
    }

    public List<DocumentObserver> getObserverList() {
        return observerList;
    }

    public void setObserverList(List<DocumentObserver> observerList) {
        this.observerList = observerList;
    }
}
