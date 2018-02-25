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
        String exceptionType = cc.getParameter().getType().toString();
        //evaluate rule
        if((exceptionType.equals("Exception") || exceptionType.equals("Throwable") || exceptionType.equals("Error"))
                && (codeBlock.contains("exit()") || codeBlock.contains("abort"))) {
            CheckerLogger.log(TypeOfWarning.OVERCATCH,fileName,cc.getRange().toString());
        }
    }
}
