package seedu.chatteroo;

import seedu.chatteroo.commands.Command;
import seedu.chatteroo.parser.Parser;
import seedu.chatteroo.storage.Storage;
import seedu.chatteroo.tasks.TaskList;
import seedu.chatteroo.ui.Ui;

import java.util.Scanner;
import java.io.IOException;

public class Chatteroo {
    private Storage storage;
    private TaskList tasks;
    private Ui ui;

    public Chatteroo() throws IOException {
        ui = new Ui();
        storage = new Storage();
        tasks = new TaskList(storage.loadTasks());
    }

    public void run() throws IOException {
        ui.showWelcomeText();
        Scanner sc = new Scanner(System.in);
        boolean isExit = false;
        try {
            while (!isExit) {
                String input = sc.nextLine();
                Command c = Parser.parseInput(input);
                c.execute(tasks, ui, storage);
                if (input.equals("bye")) {
                    isExit = true;
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            storage.saveTasks(tasks);
            sc.close();
        }
    }

    public static void main(String[] args) throws IOException {
        new Chatteroo().run();
    }
}



