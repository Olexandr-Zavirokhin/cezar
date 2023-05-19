import java.util.ArrayList;
import java.util.List;

public class TextFileWithLanguageIdentification implements CesarCode {
    private List<String> textArrayListString;
    TextLanguage textLanguage=TextLanguage.UNKNOWN;


    public TextFileWithLanguageIdentification(List<String> message) {
        this.textArrayListString = message;
    }
    public TextFileWithLanguageIdentification(List<String> message, TextLanguage textLanguage) {
        this.textArrayListString = message;
        this.textLanguage=textLanguage;
    }


    public TextLanguage getTextLanguage() {
        return textLanguage;
    }

    public void setTextLanguage(TextLanguage textLanguage) {
        this.textLanguage = textLanguage;
    }

    public List<String> getTextArrayListString() {
        return textArrayListString;
    }


   public List<String> getEncryptedList(int key){
         ArrayList<String> encryptedArrayList=new ArrayList<>();

        for(int i = 0; i<getTextArrayListString().size(); i++)
        {
            char [] tempCharArray=getTextArrayListString().get(i).toCharArray();
            StringBuilder encryptedString=new StringBuilder();
            for(int j=0;j<tempCharArray.length;j++){
                encryptedString.append(getEncryptedChar(tempCharArray[j],key,(new AlphaBetsList()).getAlphabet(getTextLanguage())));
            }
            encryptedArrayList.add(encryptedString.toString());
        }
        return encryptedArrayList;

    }
    public List<String> getDecryptedList(int key){
        return getEncryptedList( -1*key);
    }


}
