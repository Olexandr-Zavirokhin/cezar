public  class LanguageIdentification {
  public   TextLanguage textLanguages = TextLanguage.UNKNOWN;
    private   int precisionIdentificationLanguage = 2;


    public TextLanguage identificationTextLanguage(TextFileWithLanguageIdentification textFileWithKey) {
        AlphaBetsList alphaBetsList=new AlphaBetsList();
        char[] alphaBetToCheck=alphaBetsList.getAlphabet(TextLanguage.ENGLISH);
        for (String string : textFileWithKey.getTextArrayListString()) {
            char[] charArrayToCheck = string.toCharArray();
         if(textCharCompareToAlphaBet(charArrayToCheck,alphaBetToCheck)){
             this.textLanguages=TextLanguage.ENGLISH;
             return TextLanguage.ENGLISH;
         }
            alphaBetToCheck=new AlphaBetsList().getAlphabet(TextLanguage.UKRAINE);
            if(textCharCompareToAlphaBet(charArrayToCheck,alphaBetToCheck)){
                this.textLanguages=TextLanguage.UKRAINE;
                return TextLanguage.UKRAINE;
            }
        }
        return TextLanguage.UNKNOWN;
    }
    private boolean textCharCompareToAlphaBet(char[] textCharsArray, char[] alphabet) {
        int howManyCharsIdentity = 2;
        for (int i = 0; i < textCharsArray.length; i++) {
            for (int j = 0; j < alphabet.length; j++) {
                if (textCharsArray[i] == alphabet[j]) {
                    howManyCharsIdentity--;
                    if (howManyCharsIdentity == 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}