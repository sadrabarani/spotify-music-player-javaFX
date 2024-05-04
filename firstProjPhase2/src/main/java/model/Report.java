package model;
import model.UserAccount.*;

public class Report {
    private User reportingUser;
    private Artist reportedArtist;
    private String description;

    public Report(User reportingUser, Artist reportedArtist, String description) {
        this.reportingUser = reportingUser;
        this.reportedArtist = reportedArtist;
        this.description = description;
    }
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder("reporter name : ");
        res.append(reportingUser.getFullName()).append(", artist reported : ").append(reportedArtist.getFullName()).append( " , exeplenation : ").append(description);
        return String.valueOf(res);
    }

    public User getReportingUser() {
        return reportingUser;
    }

    public Artist getReportedArtist() {
        return reportedArtist;
    }

    public String getDescription() {
        return description;
    }

    public void setReportingUser(User reportingUser) {
        this.reportingUser = reportingUser;
    }

    public void setReportedArtist(Artist reportedArtist) {
        this.reportedArtist = reportedArtist;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
