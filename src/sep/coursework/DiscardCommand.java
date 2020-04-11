package sep.coursework;

/**
 *
 * @author Aston Turner
 */
public class DiscardCommand implements Command {

    private final Model model;

    public DiscardCommand(Model newModel) {
        model = newModel;
    }
    
    @Override
    public void execute() {
        model.changeState();
    }
    
    @Override
    public void undo() {
        System.out.println("Can't undo the previous discard command.");
    }

}
