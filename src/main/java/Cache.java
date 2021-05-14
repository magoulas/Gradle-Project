import java.io.File;
import java.io.FileNotFoundException;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.util.Map;
import java.util.TreeMap;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.json.simple.parser.ParseException;

public class Cache {

    public void storePeople(People people) throws FileNotFoundException, IOException, ParseException {
        File theDir = new File("app\\src\\main\\resources\\cache");
        if (!theDir.exists()) {
            theDir.mkdirs();
        }
        ObjectMapper mapper = new ObjectMapper();

        Map<String, PeopleContainer> peopleMap = new TreeMap<String, PeopleContainer>(String.CASE_INSENSITIVE_ORDER);
        TypeReference<Map<String, PeopleContainer>> typeRef = new TypeReference<Map<String, PeopleContainer>>() {
        };
        try {
            peopleMap = mapper.readValue(new File("app\\src\\main\\resources\\cache\\people.json"), typeRef);
        } catch (Exception e1) {

        }
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        PeopleContainer pc = new PeopleContainer(people, timestamp);
        peopleMap.put(people.getName().toLowerCase(), pc);

        mapper.writeValue(new File("app\\src\\main\\resources\\cache\\people.json"), peopleMap);

    }

    public PeopleResponse readPeople(String query) throws JsonParseException, JsonMappingException, IOException {
        PeopleResponse response = new PeopleResponse(false, null);

        ObjectMapper mapper = new ObjectMapper();

        Map<String, PeopleContainer> peopleMap = new TreeMap<String, PeopleContainer>(String.CASE_INSENSITIVE_ORDER);
        TypeReference<Map<String, PeopleContainer>> typeRef = new TypeReference<Map<String, PeopleContainer>>() {
        };
        try {
            peopleMap = mapper.readValue(new File("app\\src\\main\\resources\\cache\\people.json"), typeRef);
        } catch (Exception e1) {
            return response;
        }
        PeopleContainer peopleCon = new PeopleContainer();
        peopleCon = peopleMap.get(query.toLowerCase());
        if (peopleCon != null) {
            System.out.println("");
            System.out.println("Name: " + peopleCon.getPeople().getName());
            System.out.println("Height: " + peopleCon.getPeople().getHeight());
            System.out.println("Mass: " + peopleCon.getPeople().getMass());
            System.out.println("Birth Year: " + peopleCon.getPeople().getBirth());
            if (!App.worldCor) {
                System.out.println("\n");
                System.out.println("cached: " + peopleCon.getTimestamp());
            }
            response.setFound(true);
            response.setPlanetUid(peopleCon.getPeople().getHomeworld());
            return response;
        }

        return response;
    }

    public void storePlanet(Homeworld homeworld, Integer uid)
            throws JsonGenerationException, JsonMappingException, IOException {
        ObjectMapper mapper = new ObjectMapper();

        Map<Integer, WorldContainer> worldMap = new TreeMap<Integer, WorldContainer>();
        TypeReference<Map<Integer, WorldContainer>> typeRef = new TypeReference<Map<Integer, WorldContainer>>() {
        };
        try {
            worldMap = mapper.readValue(new File("app\\src\\main\\resources\\cache\\homeworld.json"), typeRef);
        } catch (Exception e1) {

        }
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        WorldContainer wc = new WorldContainer(homeworld, timestamp);
        worldMap.put(uid, wc);
        mapper.writeValue(new File("app\\src\\main\\resources\\cache\\homeworld.json"), worldMap);
    }

    public Boolean readPlanet(String planetUid) {
        ObjectMapper mapper = new ObjectMapper();

        Map<String, WorldContainer> worldMap = new TreeMap<String, WorldContainer>(String.CASE_INSENSITIVE_ORDER);
        TypeReference<Map<String, WorldContainer>> typeRef = new TypeReference<Map<String, WorldContainer>>() {
        };
        try {
            worldMap = mapper.readValue(new File("app\\src\\main\\resources\\cache\\homeworld.json"), typeRef);
        } catch (Exception e1) {
            return false;
        }
        WorldContainer homeCon = new WorldContainer();
        homeCon = worldMap.get(planetUid.toLowerCase());
        if (homeCon != null) {
            System.out.println("\n");
            System.out.println("Homeworld");
            System.out.println("-------------");
            System.out.println("Name: " + homeCon.getHomeworld().getName());
            System.out.println("Population: " + homeCon.getHomeworld().getPop());
            double i = Double.parseDouble(homeCon.getHomeworld().getOrb_period()) / 365;
            double j = Double.parseDouble(homeCon.getHomeworld().getRot_period()) / 24;
            DecimalFormat df2 = new DecimalFormat("#.##");
            System.out.println("On " + homeCon.getHomeworld().getName() + ", 1 year on earth is " + df2.format(i)
                    + " years and 1 day " + df2.format(j) + "days");
            System.out.println("\n");

            System.out.println("cached: " + homeCon.getTimestamp());

            return true;
        }

        return false;
    }

}
