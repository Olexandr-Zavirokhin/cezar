public class LanguageIdentification {
    public TextLanguage textLanguages = TextLanguage.UNKNOWN;


    public TextLanguage identificationTextLanguage(TextFileWithLanguageIdentification textFileWithKey) {
        if (textFileWithKey == null || textFileWithKey.getTextArrayListString() == null) {
            return TextLanguage.UNKNOWN;
        } else {
            AlphaBetsList alphaBetsList = new AlphaBetsList();
            char[] alphaBetToCheck = alphaBetsList.getAlphabet(TextLanguage.ENGLISH);
            for (String string : textFileWithKey.getTextArrayListString()) {
                char[] charArrayToCheck = string.toCharArray();
                if (textCharCompareToAlphaBet(charArrayToCheck, alphaBetToCheck)) {
                    this.textLanguages = TextLanguage.ENGLISH;
                    return TextLanguage.ENGLISH;
                }
                alphaBetToCheck = new AlphaBetsList().getAlphabet(TextLanguage.UKRAINE);
                if (textCharCompareToAlphaBet(charArrayToCheck, alphaBetToCheck)) {
                    this.textLanguages = TextLanguage.UKRAINE;
                    return TextLanguage.UKRAINE;
                }
            }
        }
        return TextLanguage.UNKNOWN;
    }

    private boolean textCharCompareToAlphaBet(char[] textCharsArray, char[] alphabet) {
        int howManyCharsIdentity = 0;
        for (char c : textCharsArray) {
            for (char value : alphabet) {
                if (c == value) {
                    howManyCharsIdentity++;
                    int PRECISION_IDENTIFICATION_LANGUAGE = 2;
                    if (howManyCharsIdentity == PRECISION_IDENTIFICATION_LANGUAGE) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}