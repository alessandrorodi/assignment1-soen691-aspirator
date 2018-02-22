package StaticChecker;

import com.github.javaparser.JavaParser;

public class StaticChecker {


    /**
     * Uses the parser to parse the code block and return true if the catch block of the exception is empty.
     * @param codeBlock the code to check
     * @return boolean true or false
     */
    public static boolean emptyErrorChecker(String codeBlock) {
        boolean empty = false;

        //if catch block is empty, return true
        codeBlock = codeBlock.trim().replaceAll("\\s ", "");
        if(codeBlock.equals("{}") || codeBlock.equals("{\n}")) empty = true;


       // JavaParser.parse()
        return empty;
    }


    /**
     * Uses the parser to parse the code block and then checks if the code block over catches the exception (e.g. catches twice which is useless code)
     * @param codeblock the code to check
     * @return boolean true or false
     */
    public static boolean overCatchChecker(String codeblock) {

        return false;
    }


    /**
     * Uses the parser to parse the code block and then checks if the code block contains "TODO" or "FIXME"
     * @param codeblock the code to check
     * @return boolean true or false
     */
    public static boolean uselessPhrasesChecker(String codeblock) {
        if(codeblock.contains("FIXME") || codeblock.contains("TODO"))
            return true;

        return false;
    }

}
