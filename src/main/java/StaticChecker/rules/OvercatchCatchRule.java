package StaticChecker.rules;

import StaticChecker.Rule;
import StaticChecker.StaticChecker;
import StaticChecker.CheckerLogger;
import StaticChecker.TypeOfWarning;
import com.github.javaparser.ast.stmt.CatchClause;

public class OvercatchCatchRule implements Rule<CatchClause> {

    public void apply(CatchClause cc, String fileName) {
        //process code block
        String codeBlock = cc.getBody().toString().trim().replaceAll("\\s ", "");
        //evaluate rule
        if(codeBlock.contains("exit()") || codeBlock.contains("abort")) {
            CheckerLogger.log(TypeOfWarning.OVERCATCH,fileName,cc.getRange().toString());
        }
    }
}
