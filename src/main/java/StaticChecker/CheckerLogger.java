package StaticChecker;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class CheckerLogger {

    public static void log(TypeOfWarning type,String fileName, String range){
        Warning warning = new Warning();
        switch(type){
            case EMPTY:{
                warning = new Warning("WARNING: This catch block is empty.",fileName,range,type,"logs/empty.txt");
                break;
            }
            case OVERCATCH:{
                warning = new Warning("WARNING: Possible over-catch in this block.",fileName,range,type,"logs/overcatch.txt");
                break;
            }
            case USELESS:{
                warning = new Warning("WARNING: TODO or FIXME in this block.",fileName,range,type,"logs/useless.txt");
                break;
            }
            default:break;
        }
        System.out.println(warning.getText() + " in " + warning.getFileName());
        logWarning(warning);
    }

    private static void logWarning(Warning warning){
        String line = warning.getText() + " Range: " + warning.getRange() + " File name: " + warning.getFileName();

        try {
            Files.write(Paths.get(warning.getLogFile()),line.getBytes(), StandardOpenOption.CREATE);
        }catch(Exception ie){
            ie.printStackTrace();
        }



    }
}
