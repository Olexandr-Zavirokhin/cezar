import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class CLI {
    private Path consolePath;
    private ConsoleCommand consoleCommand;

    private int consoleKey;

    public CLI() {
        this.consolePath = null;
        this.consoleCommand = ConsoleCommand.EXIT;
        this.consoleKey = 0;
    }

    public void setCLI() {
        setConsolePath();
        setConsoleCommand();
        if (this.consoleCommand == ConsoleCommand.BRUTE_FORCE) {
            this.consoleKey = 0;
        } else {
            setConsoleKey();
        }
    }

    public Path getConsolePath() {
        return consolePath;
    }

    public void setConsolePath(Path consolePath) {
        this.consolePath = consolePath;
    }

    private void setConsolePath(String consolePath) {
        this.consolePath = Path.of(consolePath);
    }

    private void setConsolePath() {
        boolean rightPath = false;
        int numberOfAttemptsToEnterRightPath = 3;
        Scanner console = new Scanner(System.in);
        while (!rightPath) {
            System.out.println("\n\tEnter absolute path to your file");
            String consolePathString = console.nextLine();
            Path consolePath = Path.of(consolePathString);
            if (Files.exists(consolePath)) {
                System.out.println("You enter right Path");
                this.setConsolePath(consolePath);
                rightPath = true;
            } else {
                if (numberOfAttemptsToEnterRightPath > 0) {
                    System.out.println("\n\tYou enter wrong path, try again" +
                            " \n\t You have  " + numberOfAttemptsToEnterRightPath + " attempts");
                    numberOfAttemptsToEnterRightPath--;
                } else {
                    rightPath = true;
                }
            }
        }
    }

    public ConsoleCommand getConsoleCommand() {
        return consoleCommand;
    }

    public int getConsoleKey() {
        return consoleKey;
    }

    public void setConsoleKey(int consoleKey) {
        this.consoleKey = consoleKey;
    }

    public void setConsoleKey(String consoleKey) {
        this.consoleKey = Integer.parseInt(consoleKey);
    }

    public void setConsoleKey() {
        boolean rightKey = false;
        int numberOfAttemptsToEnterRightKey = 3;
        while (!rightKey) {
            try (Scanner console = new Scanner(System.in)) {
                System.out.println("\n\tEnter your key number ");
                if (console.hasNextInt()) {
                    int consoleKey = console.nextInt();

                    System.out.println("You enter right key");
                    this.setConsoleKey(consoleKey);
                    rightKey = true;
                } else {

                    if (numberOfAttemptsToEnterRightKey > 0) {
                        System.out.println("\n\tYou enter wrong key, try again " +
                                "\n\t You have  " + numberOfAttemptsToEnterRightKey + " attempts");
                        numberOfAttemptsToEnterRightKey--;
                    } else {
                        rightKey = true;
                        this.setConsoleKey(0);
                    }
                }
            }
        }
    }

    public void setCLiString(String consolePath, String consoleCommand, String consoleKey) {
        setConsolePath(consolePath);
        setConsoleCommand(consoleCommand);
        if (this.consoleCommand == ConsoleCommand.BRUTE_FORCE) {
            this.consoleKey = 0;
        } else {
            setConsoleKey(consoleKey);
        }
    }

    private void setConsoleCommand(String consoleCommand) {
        this.consoleCommand = setStringToConsoleCommand(consoleCommand);
    }

    private ConsoleCommand setStringToConsoleCommand(String consoleCommand) {
        switch (consoleCommand) {
            case "ENCRYPT", "e", "E" -> {
                return ConsoleCommand.ENCRYPT;
            }
            case "DECRYPT", "d", "D" -> {
                return ConsoleCommand.DECRYPT;
            }
            case "BRUTE_FORCE", "b", "B" -> {
                return ConsoleCommand.BRUTE_FORCE;
            }
            case "EXIT", "x", "X" -> {
                return ConsoleCommand.EXIT;
            }
        }
        return ConsoleCommand.EXIT;
    }

    private void setConsoleCommand() {
        boolean rightCommand = false;
        int numberOfAttemptsToEnterRightCommand = 3;
        Scanner console = new Scanner(System.in);
        while (!rightCommand) {
            System.out.println("\n\tEnter your action command [[e]ENCRYPT, [d]DECRYPT,[b]BRUTE_FORCE,[x]EXIT]");
            String consoleCommand = console.nextLine();
            this.consoleCommand = setStringToConsoleCommand(consoleCommand);
            if (this.consoleCommand != ConsoleCommand.EXIT) {
                rightCommand = true;
            } else {
                if (numberOfAttemptsToEnterRightCommand > 0) {
                    System.out.println("\n\tYou enter wrong command, try again " +
                            "\n\t You have  " + numberOfAttemptsToEnterRightCommand + " attempts");
                    numberOfAttemptsToEnterRightCommand--;
                } else {
                    rightCommand = true;
                    this.consoleCommand = ConsoleCommand.EXIT;
                }
            }
        }
    }

}
