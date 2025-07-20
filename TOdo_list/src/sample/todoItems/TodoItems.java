package sample.todoItems;

import java.time.LocalDate;

public class TodoItems {
    private String details;
    private String extendedDetails;
    private LocalDate deadline;

    public TodoItems(String details, String extendedDetails, LocalDate deadline) {
        this.details = details;
        this.extendedDetails = extendedDetails;
        this.deadline = deadline;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getExtendedDetails() {
        return extendedDetails;
    }

    public void setExtendedDetails(String extendedDetails) {
        this.extendedDetails = extendedDetails;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    @Override
    public String toString() {
        return this.details;
    }
}
