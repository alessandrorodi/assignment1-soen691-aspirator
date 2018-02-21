package StaticChecker;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.stmt.CatchClause;
import com.github.javaparser.printer.JsonPrinter;
import com.github.javaparser.printer.YamlPrinter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

public class FileParser {

    public static void parseFile(String fileName) throws FileNotFoundException
    {
        if(fileName == null)
            throw new IllegalArgumentException("Please provide a valid class file.");

        File file = new File(fileName);
        CompilationUnit unit = JavaParser.parse(file);
        getAllCatchBlocks(unit);
    }

    private static void getAllCatchBlocks(CompilationUnit cu){
        List<CatchClause> catches = cu.findAll(CatchClause.class);
        for (CatchClause cc: catches
                ) {
            System.out.println(cc.getParameter());
            System.out.println(cc.getBody());

            StaticChecker.overCatchChecker(cc.toString());

        }
    }

    private static void printAST(CompilationUnit unit)
    {
        //YamlPrinter printer = new YamlPrinter(true);
        JsonPrinter printer = new JsonPrinter(true);
        System.out.println(printer.output(unit));
    }

}