

public class Main {
    public static void main(String[] args) {
        InformationForUserToRead informationForUserToRead = new InformationForUserToRead();
        informationForUserToRead.getSTART_INFORMATION();
        informationForUserToRead.getCONSOLE_COMMAND_GUIDE();
        CLI console = new CLI();
        if (args.length > 2) {
            console.setCLiString(args[0], args[1], args[2]);
        } else if (args.length == 2) {
            console.setCLiString(args[0], args[1], String.valueOf(0));
        } else {
            console.setCLI();
        }
        FileService fileService = new FileService(console.getConsolePath());
        var textFileWithLanguageIdentification = new TextFileWithLanguageIdentification(fileService.readFileToListString());
        var languageIdentification = new LanguageIdentification();
        textFileWithLanguageIdentification
                .setTextLanguage(languageIdentification.identificationTextLanguage(textFileWithLanguageIdentification));
        if (textFileWithLanguageIdentification.textLanguage == TextLanguage.UNKNOWN) {
            console.setConsoleCommand(ConsoleCommand.EXIT);
        }
        switch (console.getConsoleCommand()) {
            case ENCRYPT -> {
                fileService.writeListStringToFile
                        (textFileWithLanguageIdentification.getEncryptedList(console.getConsoleKey()), console.getConsoleCommand());
            }
            case DECRYPT -> {
                fileService.writeListStringToFile
                        (textFileWithLanguageIdentification.getDecryptedList(console.getConsoleKey()), console.getConsoleCommand());
            }
            case BRUTE_FORCE -> {
                BrutForce brutForce = new BrutForce(textFileWithLanguageIdentification, 8);
                console.setConsoleKey(brutForce.getBrutForceKey());
                fileService.setPath(fileService.getNewPathToNewFileAfterAction(console.getConsoleCommand(), console.getConsoleKey()));
                fileService.writeListStringToFile
                        (textFileWithLanguageIdentification.getDecryptedList(console.getConsoleKey()), console.getConsoleCommand());
            }
            case EXIT -> {
                System.out.println("EXIT ");
            }
        }
    }
}

