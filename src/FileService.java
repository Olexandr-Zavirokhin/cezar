import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileService {
    private Path path;
    private Boolean isExist;

    public FileService(Path path) {
        this.path = path;
        this.isExist = Files.exists(path);
    }

    public Path getPath() {
        return path;
    }

    public List<String> readFileToListString() {
        if (this.isExist) {
            try {
               return Files.readAllLines(path, StandardCharsets.UTF_8);
            } catch (IOException e) {

                throw new RuntimeException(e);
            }
        } else {
            return null;
        }
    }

    public void setPath(Path path) {
        this.path = path;
    }
    public void writeListStringToFile(List<String> afterActionListString, ConsoleCommand actionCommand){
        Path pathToNewFile=getNewPathToNewFileAfterAction(actionCommand);
        StringBuilder stringBuilder=new StringBuilder();
        for(var string :afterActionListString){
            stringBuilder.append(string).append("\n");
        }
        try {
            Files.writeString(pathToNewFile,stringBuilder);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public Path getNewPathToNewFileAfterAction (ConsoleCommand actionCommand, int key){
        Path fileName=this.getPath().getFileName() ;
        String fileNameAfterAction=fileName.toString().substring(0,fileName.toString().indexOf("."));
        fileNameAfterAction=fileNameAfterAction +"["+"Key="+key+"]"+".txt";
        return  this.path.getParent().resolve( fileNameAfterAction);
    }
    private Path getNewPathToNewFileAfterAction (ConsoleCommand actionCommand){
        Path fileName=this.path.getFileName() ;
        String fileNameAfterAction=fileName.toString().substring(0,fileName.toString().indexOf("."));
        fileNameAfterAction=fileNameAfterAction +"["+actionCommand+"]"+".txt";
        return  this.path.getParent().resolve( fileNameAfterAction);
    }
}
