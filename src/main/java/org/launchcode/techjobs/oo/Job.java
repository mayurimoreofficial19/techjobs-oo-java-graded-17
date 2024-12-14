package org.launchcode.techjobs.oo;

import java.util.Objects;

public class Job {

    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    // TODO: Add two constructors - one to initialize a unique ID and a second to initialize the
    //  other five fields. The second constructor should also call the first in order to initialize
    //  the 'id' field.
    public Job() {
        id = nextId;
        nextId++;
    }

    public Job(String name,Employer employer,Location location,PositionType positionType,CoreCompetency coreCompetency) {
        this();
        this.name = name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency = coreCompetency;
    }

    // TODO: Add custom equals and hashCode methods. Consider two Job objects "equal" when their id fields
    //  match.

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return id == job.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }


    // TODO: Add getters for each field EXCEPT nextId. Add setters for each field EXCEPT nextID
    //  and id.

    public String getName() {
        return name;
    }

    public Employer getEmployer() {
        return employer;
    }

    public Location getLocation() {
        return location;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
       // return System.lineSeparator() + System.lineSeparator();
        StringBuilder sb = new StringBuilder();

        sb.append(System.lineSeparator());

        if (id != 0 && (name == null || name.isEmpty()) && (employer == null) &&
                (location == null) && (positionType == null) &&
                (coreCompetency == null)) {
            sb.append("OOPS! This job does not seem to exist.");
        } else {
            sb.append("ID: ").append(id == 0 ? "Data not available" : id).append(System.lineSeparator());
            sb.append("Name: ").append(name == null || name.isEmpty() ? "Data not available" : name).append(System.lineSeparator());
            sb.append("Employer: ").append(employer == null || employer.toString().isEmpty() ? "Data not available" : employer).append(System.lineSeparator());
            sb.append("Location: ").append(location == null || location.toString().isEmpty() ? "Data not available" : location).append(System.lineSeparator());
            sb.append("Position Type: ").append(positionType == null || positionType.toString().isEmpty() ? "Data not available" : positionType).append(System.lineSeparator());
            sb.append("Core Competency: ").append(coreCompetency == null || coreCompetency.toString().isEmpty() ? "Data not available" : coreCompetency);
        }

        sb.append(System.lineSeparator());

        return sb.toString();
    }

}
