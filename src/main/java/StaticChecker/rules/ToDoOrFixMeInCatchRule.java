package StaticChecker.rules;

import StaticChecker.Rule;
import StaticChecker.CheckerLogger;
import StaticChecker.TypeOfWarning;
import com.github.javaparser.ast.stmt.CatchClause;

public class ToDoOrFixMeInCatchRule implements Rule<CatchClause> {

    public void apply(CatchClause cc, String fileName){
        //process code block
        String codeBlock = cc.getBody().toString().trim().replaceAll("\\s ", "");
        //evaluate rule
        if((codeBlock.toLowerCase().contains("fixme") || codeBlock.toLowerCase().contains("todo"))) {
            String range = "Line " + cc.getRange().get().begin.line + " - Line " + cc.getRange().get().end.line;
            CheckerLogger.log(TypeOfWarning.USELESS,fileName,range);
        }
    }
}
