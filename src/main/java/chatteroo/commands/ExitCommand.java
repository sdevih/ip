package chatteroo.commands;

import javafx.application.Platform;

import chatteroo.ChatterooException;
import chatteroo.tasks.TaskList;
import chatteroo.ui.Ui;
import chatteroo.storage.Storage;

/**
 * Prints the exit message.
 */
public class ExitCommand extends Command {

    /**
     * Constructor for the ExitCommand class.
     */
    public ExitCommand() {
        super();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String execute(TaskList tasks, Ui ui, Storage storage) throws ChatterooException {
        Platform.exit();
        return ui.showByeResponse();
    }


}
