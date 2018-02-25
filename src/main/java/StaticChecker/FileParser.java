package StaticChecker;

import StaticChecker.rules.EmptyCatchRule;
import StaticChecker.rules.OvercatchCatchRule;
import StaticChecker.rules.ToDoOrFixMeInCatchRule;
import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.stmt.CatchClause;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

public class FileParser {

    public static void parseFile(String fileName) throws FileNotFoundException
    {
        if(fileName == null || fileName.trim().equals("")){
            throw new IllegalArgumentException("Please provide a valid list of java files to check.");
        }

        String path = FileParser.class.getClassLoader().getResource(fileName).getPath();
        CompilationUnit unit = JavaParser.parse(new File(path));
        processAllCatchBlocks(unit,fileName);
    }

    private static void processAllCatchBlocks(CompilationUnit cu, String fileName){
        List<CatchClause> catches = cu.findAll(CatchClause.class);
        RuleEvaluator<CatchClause> ruleEvaluator = new RuleEvaluator<>();
        ruleEvaluator.addRule(new EmptyCatchRule());
        ruleEvaluator.addRule(new ToDoOrFixMeInCatchRule());
        ruleEvaluator.addRule(new OvercatchCatchRule());
        for (CatchClause cc: catches) {
            ruleEvaluator.evaluateRules(cc,fileName);
        }
    }
}