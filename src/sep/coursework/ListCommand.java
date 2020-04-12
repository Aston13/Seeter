package sep.coursework;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import sep.seeter.net.message.TopicsReply;
import sep.seeter.net.message.TopicsReq;

/**
 *
 * @author Aston Turner
 */
public class ListCommand implements Command{

    private final Model model;
    
    public ListCommand(Model newModel) {
        model = newModel;
    }
    
    @Override
    public void execute() {
        try {
            model.send(new TopicsReq());
        } catch (IOException ex) {
            Logger.getLogger(ListCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            TopicsReply t = (TopicsReply) model.receive();
            System.out.println("Topics: " + t.topics.toString());
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(ListCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    @Override
    public boolean undo() {
        return false;
        //System.out.println("Can't undo the previous list command.");
    }
    
    @Override
    public String getCommandString() {
        return "List";
    }

}