import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

class Writer implements Writable {
    private Map<String, Integer> map = new HashMap<String, Integer>();
    private double wordCounter = 0;

    void insertWord(StringBuilder str) {
        String str1 = str.toString();
        if (map.containsKey(str1))
            map.put(str1, map.get(str1) + 1);
        else
            map.put(str1, 1);
        wordCounter++;
    }
    private HashMap<String, Integer> sortByValue(HashMap<String, Integer> hm) {
        // creating list from elements of HashMap
        List<Map.Entry<String, Integer> > list = new LinkedList<Map.Entry<String, Integer> >(hm.entrySet());
        // sorting list
        list.sort(new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });

        HashMap<String, Integer> ha = new LinkedHashMap<String, Integer>();
        for(Map.Entry<String, Integer> me : list) {
            ha.put(me.getKey(), me.getValue());
        }
        return ha;
    }
    public void writeText(File file) {

        try {
            FileWriter writer = new FileWriter(file);
            Map<String, Integer> map2 = sortByValue((HashMap<String, Integer>) map);
            for (String name: map2.keySet()) {
                String key = name.toString();
                String value = map2.get(name).toString();
                double value2 = (double) map2.get(name);
                value2 = value2 / wordCounter;
                writer.append(key).append(String.valueOf('\t')).append(String.valueOf('\t'));
                writer.append(value).append(String.valueOf('\t')).append(String.valueOf('\t'));
                writer.append(Double.toString(value2)).append(String.valueOf('%')).append(String.valueOf('\n'));
                writer.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}