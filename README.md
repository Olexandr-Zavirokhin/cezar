# cezar
Programm for encrypt decrypt and brud force your text file.

You can enter the path, command, and key at the start of the program, or you can enter it gradually in dialog mode;

The program is multilingual, with easy addition of languages; 

The encryption algorithm resides in the interface for easy modification without changing the implementation;

Brut Force during execution needs additional confirmation in decryption otherwise it will continue;

file Path + command + key - this is the order in which you need to write your file path command and your encryption key ;

FilePath command - if you write command BRUT_FORCE;

Launching the program itself from the console will look like java -jar myApp.jar filePath command key;

AlphaBetsList - conteins all alphabet arrays ;

InformationForUserToRead - information; CLI - dialog console with Path Console command and console key;

Enum Console command: [ENCRYPT, DECRYPT, BRUTE_FORCE, EXIT] - all console command;

Enum TextLanguage - all programm language;

FileServise - read and write rezult to file;

CesarCode - interfeice with Encrypt Algo;

TextFileWithLanguageIdentification - contains Text File and Language Identification;
