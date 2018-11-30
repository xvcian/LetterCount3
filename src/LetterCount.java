
import java.io.*;
import java.util.Comparator;
import java.util.Formatter;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;


public class LetterCount {
    public static void main(String[] args) {
        LetterCount();
    }

    public static void LetterCount() {
        Map<Character, Integer> map = new HashMap< >();
        BufferedReader fin = null;
        try {
            File fileSrc=new File("/home/lulu/hamlet.txt.html");
            fin = new BufferedReader(new FileReader(fileSrc));
            fin.lines()
                    .parallel()
                    .flatMapToInt(s -> s.toLowerCase().chars())
                    .filter(value -> value>='a'&&value<='z'||value>='A'&&value<='Z')
                    .forEach(value ->{
                        if (map.containsKey((char)value))
                            map.put((char) value,map.get((char)value)+1);
                        else
                            map.put((char) value,1);

                    });
            map.entrySet().stream()
                    .sorted(Comparator.comparing(Map.Entry::getValue))
                    .forEach(e-> System.out.println(e.getKey()+" "+e.getValue()));

        }catch (FileNotFoundException f) {
            System.out.println(f.getMessage());
        }finally {
            if (fin != null)
                try {
                    fin.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }

    }


}
