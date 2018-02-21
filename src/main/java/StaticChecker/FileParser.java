package StaticChecker;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.comments.Comment;
import com.github.javaparser.ast.stmt.CatchClause;
import com.github.javaparser.printer.JsonPrinter;
import com.github.javaparser.printer.YamlPrinter;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Paths;
import java.util.List;

public class FileParser {

    public static void parseFile(String fileName) throws FileNotFoundException
    {
        if(fileName == null)
            throw new IllegalArgumentException("Please provide a valid class file.");


        String path = FileParser.class.getClassLoader().getResource(fileName).getPath();
        File file = new File(path);
        CompilationUnit unit = JavaParser.parse(file);
        getAllCatchBlocks(unit);
    }

    private static void getAllCatchBlocks(CompilationUnit cu){
        List<CatchClause> catches = cu.findAll(CatchClause.class);
        for (CatchClause cc: catches
                ) {
            System.out.println(cc.getBody());


            boolean empty = StaticChecker.emptyErrorChecker(cc.getBody().toString());
            System.out.println("Is the catch empty ? : " + empty);
            // if empty, we log where exactly in file and which file. checkerLogs/emptycatch.txt



        }

        List<Comment> comments = cu.findAll(Comment.class);
        for (Comment comm: comments
                ) {
            System.out.println(comm.getContent());


            boolean empty = StaticChecker.uselessPhrasesChecker(comm.getContent());
            System.out.println("Does comment contain TODO or FIXME? : " + empty);
            // if yes, we log where exactly in file and which file. --> checkerLogs/uselessTODOFIXME.txt



        }
    }

    private static void printAST(CompilationUnit unit)
    {
        //YamlPrinter printer = new YamlPrinter(true);
        JsonPrinter printer = new JsonPrinter(true);
        System.out.println(printer.output(unit));
    }

}