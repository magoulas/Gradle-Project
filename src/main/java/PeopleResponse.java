public class PeopleResponse {

    private boolean found;
    private String planetUid;

    public PeopleResponse(boolean found, String planetUid) {
        this.found = found;
        this.planetUid = planetUid;
    }

    public PeopleResponse() {
    }

    public boolean isFound() {
        return this.found;
    }

    public boolean getFound() {
        return this.found;
    }

    public void setFound(boolean found) {
        this.found = found;
    }

    public String getPlanetUid() {
        return this.planetUid;
    }

    public void setPlanetUid(String planetUid) {
        this.planetUid = planetUid;
    }
    
}
