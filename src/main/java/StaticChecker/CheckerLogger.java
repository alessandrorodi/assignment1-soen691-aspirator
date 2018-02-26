package StaticChecker;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Comparator;

public class CheckerLogger {

    public static long totalCatchCount = 0;
    private static long emptyCount = 0;
    private static long overcatchCount = 0;
    private static long uselessCount = 0;

    public static void log(TypeOfWarning type, String fileName, String range){
        Warning warning = new Warning();
        switch(type){
            case EMPTY:{
                warning = new Warning("WARNING: Empty catch block",fileName,range,type, "logs/empty.txt");
                emptyCount++;
                break;
            }
            case OVERCATCH:{
                warning = new Warning("WARNING: Possible over-catch",fileName,range,type, "logs/overcatch.txt");
                overcatchCount++;
                break;
            }
            case USELESS:{
                warning = new Warning("WARNING: TODO or FIXME in catch",fileName,range,type, "logs/useless.txt");
                uselessCount++;
                break;
            }
            default:break;
        }
        logWarning(warning);
    }

    private static void logWarning(Warning warning){
        String line = warning.getText() + ", Range: " + warning.getRange() + ", File name: " + warning.getFileName()+"\r\n";
        System.out.print(line);
        Path logfile = Paths.get(warning.getLogFile());
        try {
            if (!Files.exists(logfile)) {
                Files.createDirectories(logfile.getParent());
                Files.createFile(logfile);
            }
            Files.write(logfile, line.getBytes(), StandardOpenOption.APPEND);
        }catch(Exception ie){
            ie.printStackTrace();
        }
    }

    public static void clearLogs(){
        Path logs = Paths.get("logs");
        if (Files.exists(logs)) {
            try {
                Files.walk(logs)
                        .sorted(Comparator.reverseOrder())
                        .map(Path::toFile)
                        .forEach(File::delete);
            } catch (IOException e) {
                System.out.println("Error deleting logs : " + e.getMessage());
            }
        }
    }

    public static void printReport(){
        System.out.println("(i) Number of empty catch blocks: "+emptyCount);
        System.out.println("(ii) Number of over-catches with aborts in catch blocks: "+overcatchCount);
        System.out.println("(iii) Number of TODO/FIXME in catch blocks: "+uselessCount);
        System.out.println("(iv) Total number of catch blocks: "+totalCatchCount);
    }
}
