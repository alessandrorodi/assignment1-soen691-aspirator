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
        if((codeBlock.contains("FIXME") || codeBlock.contains("TODO"))) {
            CheckerLogger.log(TypeOfWarning.USELESS,fileName,cc.getRange().toString());
        }
    }
}
