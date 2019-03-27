import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

class Writer implements Writable {
    private Map<String, Integer> wordsChart = new HashMap<String, Integer>();
    private double wordCounter = 0;

    void insertWord(StringBuilder str) {
        String str1 = str.toString();
        if (wordsChart.containsKey(str1))
            wordsChart.put(str1, wordsChart.get(str1) + 1);
        else
            wordsChart.put(str1, 1);
        wordCounter++;
    }
    private HashMap<String, Integer> sortByValue(HashMap<String, Integer> hm) {
        List<Map.Entry<String, Integer> > list = new LinkedList<Map.Entry<String, Integer> >(hm.entrySet());
        list.sort((o1, o2) -> (o2.getValue()).compareTo(o1.getValue()));
        HashMap<String, Integer> sortedChart = new LinkedHashMap<String, Integer>();
        for(Map.Entry<String, Integer> me : list) {
            sortedChart.put(me.getKey(), me.getValue());
        }
        return sortedChart;
    }
    public void writeText(File file) {

        try {
            FileWriter writer = new FileWriter(file);
            Map<String, Integer> sortedChart = sortByValue((HashMap<String, Integer>) wordsChart);
            for (String name: sortedChart.keySet()) {
                String word = name.toString();
                String numberOfWords = sortedChart.get(name).toString();
                double wordPercent = (double)sortedChart.get(name);
                wordPercent = wordPercent / wordCounter;
                writer.append(word).append(String.valueOf('\t')).append(String.valueOf('\t'));
                writer.append(numberOfWords).append(String.valueOf('\t')).append(String.valueOf('\t'));
                writer.append(Double.toString(wordPercent)).append(String.valueOf('%')).append(String.valueOf('\n'));
                writer.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}