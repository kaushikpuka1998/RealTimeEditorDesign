import Entities.Collaboratorditor;
import Entities.Document;
import Entities.User;
import services.DocumentService;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        User user1 = new User("user1");
        User user2 = new User("user2");

        // Create a document
        DocumentService document = new DocumentService();

        // Create a collaborative editor
        Collaboratorditor collaborativeEditor = new Collaboratorditor(document);

        // Add collaborators to the document
        collaborativeEditor.addCollaborator(user1);
        collaborativeEditor.addCollaborator(user2);

        // Edit the document
        collaborativeEditor.editDocument("This is the edited document content.");

        // Update cursor position for user1
        document.updateCollaboartor(user1, 10);

        // Update cursor position for user2
        document.updateCollaboartor(user2, 15);
        document.removeCollaborator(user2);
        document.removeCollaborator(user1);
        document.addCollaboartor(user2);
        document.updateCollaboartor(user1, 50);
    }
}