public class InformationForUserToRead {

    final private String START_INFORMATION = "\n\tWelcome to Cesar Code program!\n" +
            " \n\tYou can encrypt/decrypt or brut force your text file.  ";
    final private String CONSOLE_COMMAND_GUIDE = "\n\tfile Path + command +  key - this is the order in which you need " +
            "\n\tto write your  file path command and your encryption key" + "\n\tfilePath command  - if you write command  BRUT_FORCE.\n" +
            "\n" +
            "That is, launching the program itself from the console will look like java -jar myApp.jar filePath command key\n" +
            "\n" +
            "command - four available options: [ENCRYPT, DECRYPT, BRUTE_FORCE, EXIT]\n" +
            "\n" +
            "filepath - absolute (full) path to the file to be encoded.\n" +
            "\n" +
            "key - an integer, the key for shifting the alphabet.\n" +
            "\n" +
            "if program write brut force file with key=0 - programme can not brut force file.\n"+
            "\n" +
            "if program exit without write file - try start program without arguments and to do it step by step in console.\n";

    public void getSTART_INFORMATION() {
        printInformation(START_INFORMATION);
    }

    public void getCONSOLE_COMMAND_GUIDE() {
        printInformation(CONSOLE_COMMAND_GUIDE);
    }

    private void printInformation(String arg) {

        System.out.println(arg);

    }
}
