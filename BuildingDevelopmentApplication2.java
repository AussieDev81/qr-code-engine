import java.time.LocalDate;

public class BuildingDevelopmentApplication2 {

    public static void main(String[] args) {

        Plot plot = new Plot(65, 40.5);
        Building building = new Building(63.5, 38);
        BuildingDevelopmentApplication application = new BuildingDevelopmentApplication(plot, building, LocalDate.now());
        //get the approval status
        boolean approved = application.approved;
        //Or just print the approval
        application.displayApproval();

    }
}

class BuildingDevelopmentApplication {

    private Plot plot;
    private Building building;
    private LocalDate dateOfApplication;
    private boolean approved;
    private String failure;

    public BuildingDevelopmentApplication(Plot plot, Building building, LocalDate dateOfApplication) {
        this.plot = plot;
        this.building = building;
        this.dateOfApplication = dateOfApplication;
        this.approved = new Verification().check();
        this.failure = new Verification().getFailure();
    }

    public void displayApproval() {
         System.out.printf( "Building plan %s", new Verification().check() ? "Approved" : "Rejected");
    }

}


class Plot{
    private double length;
    private double width;
    public Plot(double l, double w){
        length = l;
        width = w;
    }
    public double getLength() {
        return length;
    }
    public double getWidth() {
        return width;
    }
}


class Building{
    private double length;
    private double width;
    public Building(double l, double w){
        length = l;
        width = w;
    }
    public double getLength() {
        return length;
    }
    public double getWidth() {
        return width;
    }
}


interface Verifier {
    final double MINIMUM_REQUIRED = 2;
    void displayApproval();
    boolean check();
    boolean checkWidth();
    boolean checkLength();
    String getFailure(){
}


class Verification implements Verifier {
    public static final double MINIMUM_REQUIRED = 2;

    boolean check() {
        return checkWidth() && checkLength();
    }

    boolean checkWidth() {
        return plot.getWidth() - building.getWidth() >= MINIMUM_REQUIRED;
    }

    boolean checkLength() {
        return plot.getLength() - building.getLength() >= MINIMUM_REQUIRED;
    }

    String getFailure(){
        if(! checkWidth() ) return String.format("Insufficient width clearance of %.2f meters", plot.getWidth() - building.getWidth());
        else if(! checkLength() ) return  String.format("Insufficient length clearance of %.2f meters", plot.getLength() - building.getLength());
        else return "There is no failure";
    }

}



