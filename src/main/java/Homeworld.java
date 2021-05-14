public class Homeworld {
    private String name;
    private String pop;
    private String orb_period;
    private String rot_period;

    public Homeworld() {
    }

    public Homeworld(String name, String pop, String orb_period, String rot_period) {
        this.name = name;
        this.pop = pop;
        this.orb_period = orb_period;
        this.rot_period = rot_period;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPop() {
        return this.pop;
    }

    public void setPop(String pop) {
        this.pop = pop;
    }

    public String getOrb_period() {
        return this.orb_period;
    }

    public void setOrb_period(String orb_period) {
        this.orb_period = orb_period;
    }

    public String getRot_period() {
        return this.rot_period;
    }

    public void setRot_period(String rot_period) {
        this.rot_period = rot_period;
    }

}
