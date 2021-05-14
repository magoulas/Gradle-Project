import java.sql.Timestamp;

public class WorldContainer {
    private Homeworld homeworld;
    private Timestamp timestamp;

    public WorldContainer() {
    }

    public WorldContainer(Homeworld homeworld, Timestamp timestamp) {
        this.homeworld = homeworld;
        this.timestamp = timestamp;
    }

    public Homeworld getHomeworld() {
        return this.homeworld;
    }

    public void setHomeworld(Homeworld homeworld) {
        this.homeworld = homeworld;
    }

    public Timestamp getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

}
