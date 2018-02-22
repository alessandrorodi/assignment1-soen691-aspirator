package StaticChecker;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.stmt.CatchClause;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Paths;
import java.util.List;

public class FileParser {

    public static void parseFile(String fileName) throws FileNotFoundException
    {
        if(fileName == null || fileName.trim().equals("")){
            throw new IllegalArgumentException("Please provide a valid list of java files to check.");
        }

        String path = FileParser.class.getClassLoader().getResource(fileName).getPath();
        CompilationUnit unit = JavaParser.parse(new File(path));
        getAllCatchBlocks(unit,fileName);
    }

    private static void getAllCatchBlocks(CompilationUnit cu, String fileName){
        List<CatchClause> catches = cu.findAll(CatchClause.class);

        for (CatchClause cc: catches) {
            System.out.println(cc.getBody());

            boolean empty = StaticChecker.emptyErrorChecker(cc.getBody().toString());
            System.out.println("Is the catch empty ? : " + empty);
            if(empty) CheckerLogger.log(TypeOfWarning.EMPTY,fileName,cc.getRange().toString());
            // if empty, we warn where exactly in file and which file. checkerLogs/empty.txt

            boolean uselessTODOFIXME = StaticChecker.uselessPhrasesChecker(cc.getBody().toString());
            System.out.println("Does this catch claus contain a TODO or FIXME? : " + uselessTODOFIXME);
            if(uselessTODOFIXME) CheckerLogger.log(TypeOfWarning.USELESS,fileName,cc.getRange().toString());
            // if useless , we warn where exactly in file and which file. checkerLogs/useless.txt

            boolean overCatchWarning = StaticChecker.overCatchChecker(cc.getBody().toString());
            System.out.println("Does this catch clause possibly contain an over catch and abort case?: " + overCatchWarning);
            if(overCatchWarning) CheckerLogger.log(TypeOfWarning.OVERCATCH,fileName,cc.getRange().toString());
            // if over catch, we warn exactly in file and which file. checkerLogs/overcatch.txt
        }
    }


}