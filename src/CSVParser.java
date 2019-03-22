import java.io.*;
import java.util.*;

public class CSVParser implements InterfaceReader, InterfaceWriter {
    private Map<String, Integer> map = new HashMap<String, Integer>();
    double wordCounter = 0;
    private Map<String, Integer> map2 = new HashMap<String, Integer>();

    public void readWord(File file) {
        InputStreamReader reader = null;
        int i;
        StringBuilder buff = new StringBuilder();

        try {
            reader = new InputStreamReader(new FileInputStream(file));
            while (((i = reader.read()) != - 1)) {
                if (Character.isLetterOrDigit(i)) {
                    while (Character.isLetterOrDigit(i)) {
                        buff.append((char)i);
                        i = reader.read();
                    }
                    insertWord(buff);
                    buff.delete(0, buff.length());
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
//        return buff.toString();
    }
    public void insertWord(StringBuilder str) {
        String str1 = str.toString();
        if (map.containsKey(str1))
            map.put(str1, map.get(str1) + 1);
        else
            map.put(str1, 1);
        wordCounter++;
    }
    public void printMap(File file) {

        try {
            FileWriter writer = new FileWriter(file);
            map2 = sortByValue((HashMap<String, Integer>) map);
            for (String name: map2.keySet()) {
                String key = name.toString();
                String value = map2.get(name).toString();
                Double value2 = (double)map2.get(name);
                value2 = value2 / wordCounter;
                writer.append(key +'\t');
                writer.append(value + '\t');
                writer.append(Double.toString(value2) + '\n');
                writer.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static HashMap<String, Integer> sortByValue(HashMap<String, Integer> hm) {
        // creating list from elements of HashMap
        List<Map.Entry<String, Integer> > list = new LinkedList<Map.Entry<String, Integer> >(hm.entrySet());
        // sorting list
        Collections.sort(list, new Comparator<Map.Entry<String, Integer> >() {
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

}

