package Observers;

import Entities.Document;
import Entities.User;

public class CursorPositionObserver implements DocumentObserver {
    private User user;

    public CursorPositionObserver(User user) {
        this.user = user;
    }

    @Override
    public void update(Document document) {
        System.out.println("User " + user.getName() + " has updated the cursor position in the document");
    }
}
