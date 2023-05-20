import java.nio.file.Path;
import java.util.*;


public class BrutForce extends TextFileWithLanguageIdentification {
    private Map<TextLanguage, Path> mostUsedWordsFilePath;
    private final int howManyWordsMustFind;
    private List<String> mostUsedWordsListString;

    public BrutForce(TextFileWithLanguageIdentification textFileWithLanguageIdentification, int howManyWordsMustFind) {
        super(textFileWithLanguageIdentification.getTextArrayListString(), textFileWithLanguageIdentification.getTextLanguage());
        this.howManyWordsMustFind = howManyWordsMustFind;
        createMapMostUsedWordsFilePath();
        createListMostUsedWords();
    }

    private void createMapMostUsedWordsFilePath() {
        this.mostUsedWordsFilePath = new HashMap<>();
        mostUsedWordsFilePath.put(TextLanguage.ENGLISH, Path.of("src/PopularLanguagesWords/EnglishWords.txt"));
        mostUsedWordsFilePath.put(TextLanguage.UKRAINE, Path.of("src/PopularLanguagesWords/UkraineWords.txt"));
    }

    private void createListMostUsedWords() {
        FileService fileService = new FileService(mostUsedWordsFilePath.get(this.getTextLanguage()));
        mostUsedWordsListString = new ArrayList<>();
        mostUsedWordsListString.addAll(fileService.readFileToListString());

    }

    private boolean canRead(String string) {
        System.out.println("Enter [y] - if you can read string; Enter any key to continue brut force");
        System.out.println("String to read: " + string);
        Scanner console = new Scanner(System.in);
        String userAnswer = console.nextLine();
        return "y".equalsIgnoreCase(userAnswer);
    }

    public int getBrutForceKey() {
        int brutForceKey = 0;
        int countMaximumTryToBrutForceKey=20;
        int countOfTry=0;
        boolean isRightBrutForce = false;
        while (!isRightBrutForce) {
            brutForceKey =getBrutForceKey(brutForceKey);
            isRightBrutForce = canRead(this.getDecryptedList(brutForceKey).get(0));
            countOfTry++;
            if(countOfTry==countMaximumTryToBrutForceKey){
                brutForceKey = 0;
                isRightBrutForce=true;
            }
        }
        return brutForceKey;
    }


    private int getBrutForceKey(int key) {
        int howManyWordsMustFind;
        if(this.getTextLanguage()==TextLanguage.ENGLISH){howManyWordsMustFind=this.howManyWordsMustFind;}
        else {howManyWordsMustFind=1;}
        int brutForceMaxSizeDecryptedListToCheck = 10;
        char[] alphaBetThisText = new AlphaBetsList().getAlphabet(this.getTextLanguage());
        int keyBrutForceNext=0;
        if((key+1)<alphaBetThisText.length){keyBrutForceNext=key+1;}
        for (int keyBrutForce= keyBrutForceNext; keyBrutForce < alphaBetThisText.length; keyBrutForce++) {
            int countOfFoundWords = 0;
            List<String> brutForceTempArray = getDecryptedList(keyBrutForce);
            int brutForceListSize = brutForceTempArray.size();
            if (brutForceListSize > brutForceMaxSizeDecryptedListToCheck) {
                brutForceListSize = brutForceMaxSizeDecryptedListToCheck;
            }
            for (int i = 0; i < brutForceListSize; i++) {
                String tempStringToCheck = brutForceTempArray.get(i);
                for (int j = 0; j < this.mostUsedWordsListString.size(); j++) {
                    String exampleWord = mostUsedWordsListString.get(j);
                    if (tempStringToCheck != null) {
                        String[] brutForceWords = tempStringToCheck.split(" ");
                        for (var tempWordToCheck : brutForceWords) {
                            if (exampleWord.equals(tempWordToCheck)) {
                                countOfFoundWords++;
                                if (j < this.mostUsedWordsListString.size() - 1) {
                                    exampleWord = mostUsedWordsListString.get(j + 1);
                                }
                                if (countOfFoundWords == howManyWordsMustFind) {
                                    return keyBrutForce;
                                }
                            }
                        }
                    }
                }
            }
        }
        return 0;
    }
}
