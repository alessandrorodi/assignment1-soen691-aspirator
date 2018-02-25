package StaticChecker;

public class StaticChecker {


    /**
     * Uses the parser to parse the code block and return true if the catch block of the exception is empty.
     * @param codeBlock the code to check
     * @return boolean true or false
     */
    public static boolean emptyErrorChecker(String codeBlock) {
        //if catch block is empty, return true
        codeBlock = clean(codeBlock);
        return (codeBlock.equals("{}") || codeBlock.equals("{\n}"));
    }

    private static String clean(String codeBlock){
        return codeBlock.trim().replaceAll("\\s ", "");
    }
    /**
     * Uses the parser to parse the code block and then checks if the code block over catches the exception (e.g. catches twice which is useless code)
     * @param codeBlock the code to check
     * @return boolean true or false
     */
    public static boolean overCatchChecker(String codeBlock) {
        codeBlock = clean(codeBlock);
        return (codeBlock.contains("exit()") || codeBlock.contains("abort"));
    }


    /**
     * Uses the parser to parse the code block and then checks if the code block contains "TODO" or "FIXME"
     * @param codeBlock the code to check
     * @return boolean true or false
     */
    public static boolean uselessPhrasesChecker(String codeBlock) {
        codeBlock = clean(codeBlock);
        return (codeBlock.contains("FIXME") || codeBlock.contains("TODO"));
    }

}
