public interface CesarCode {


    default char getEncryptedChar(char argument, int key, char[] alphabetCharArray) {
        for (int i = 0; i < alphabetCharArray.length; i++) {
            if (argument == alphabetCharArray[i]) {
                int indexEncryptedChar = i + key;
                if (indexEncryptedChar >= alphabetCharArray.length) {
                    while (indexEncryptedChar >= alphabetCharArray.length) {
                        indexEncryptedChar = indexEncryptedChar - alphabetCharArray.length;
                    }
                    return alphabetCharArray[indexEncryptedChar];
                }
                if (indexEncryptedChar < 0) {
                    while (indexEncryptedChar < 0) {
                        indexEncryptedChar = indexEncryptedChar + alphabetCharArray.length;
                    }
                }
                return alphabetCharArray[indexEncryptedChar];
            }
        }
        return argument;
    }


}

