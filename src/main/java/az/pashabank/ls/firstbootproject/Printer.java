package az.pashabank.ls.firstbootproject;

public class Printer {
    private Paper paper;

    public Printer(Paper paper) {
        this.paper = paper;
    }

    public Paper getPaper() {
        return paper;
    }

    public void setPaper(Paper paper) {
        this.paper = paper;
    }
}
