package ca.Listeners;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
 
public class DummyDB {
    private int totalCountries;
    private String data = "Afghanistan, Albania, Zimbabwe";
    private List countries;
    public DummyDB() {
        countries = new ArrayList();
        StringTokenizer st = new StringTokenizer(data, ",");
 
        while(st.hasMoreTokens()) {
            countries.add(st.nextToken().trim());
        }
        totalCountries = countries.size();
    }
 
    public List getData(String query) {
        String country = null;
        query = query.toLowerCase();
        List matched = new ArrayList();
        for(int i=0; i<totalCountries; i++) {
            country = (String)countries.get(i);
           country =  country.toLowerCase();
            if(country.startsWith(query)) {
                matched.add(countries.get(i));
            }
        }
        return matched;
    }
}
