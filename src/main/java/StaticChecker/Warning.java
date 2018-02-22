package StaticChecker;


public class Warning {

    private String text;
    private String fileName;
    private TypeOfWarning type;
    private String range;
    private String logFile;

    public Warning(){}

    public Warning(String text, String fileName, String range, TypeOfWarning type, String logFile){
        this.text = text;
        this.fileName = fileName;
        this.type = type;
        this.range = range;
        this.logFile = logFile;
    }

    public TypeOfWarning getType() {
        return type;
    }

    public void setType(TypeOfWarning type) {
        this.type = type;
    }

    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range;
    }

    public String getLogFile() {
        return logFile;
    }

    public void setLogFile(String logFile) {
        this.logFile = logFile;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String filename) {
        this.fileName = filename;
    }
}
