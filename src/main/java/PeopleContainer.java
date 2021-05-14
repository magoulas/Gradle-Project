import java.sql.Timestamp;

public class PeopleContainer {

    private People people;
    private Timestamp timestamp;

    public PeopleContainer() {
    }

    public PeopleContainer(People people, Timestamp timestamp) {
        this.people = people;
        this.timestamp = timestamp;
    }

    public People getPeople() {
        return this.people;
    }

    public Timestamp getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public void setPeople(People people) {
        this.people = people;
    }

}
