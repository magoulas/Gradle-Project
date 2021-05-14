public class People {

    public People() {
    }

    public People(String name, String height, String mass, String birth, String homeworld) {
        this.name = name;
        this.height = height;
        this.mass = mass;
        this.birth = birth;
        this.homeworld = homeworld;
    }

    private String name;
    private String height;
    private String mass;
    private String birth;
    private String homeworld;

    public String getName() {
        return this.name;
    }

    public String getHomeworld() {
        return this.homeworld;
    }

    public void setHomeworld(String homeworld) {
        this.homeworld = homeworld;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHeight() {
        return this.height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getMass() {
        return this.mass;
    }

    public void setMass(String mass) {
        this.mass = mass;
    }

    public String getBirth() {
        return this.birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

}
