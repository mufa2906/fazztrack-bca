import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Example {
  public static void listExample(){

    List<String> arr1 = new ArrayList<String>(Arrays.asList("satu","dua"));
    List<String> arr2 = new ArrayList<String>(Arrays.asList("tiga","empat"));

    List<List<String>> arr3 = new ArrayList<>();
    arr3.add(arr1);
    arr3.add(arr2);
    System.out.println(arr3);
  }
  
  public static void mapExample() {
    Map<String, Map<String,Object>> map = new HashMap<>();
    HashMap<String, HashMap<String, Integer>> data = new HashMap<>();

    // Membuat HashMap yang akan disimpan di dalam HashMap utama
    HashMap<String, Integer> innerData1 = new HashMap<>();
    innerData1.put("Nilai1", 100);
    innerData1.put("Nilai2", 200);

    HashMap<String, Integer> innerData2 = new HashMap<>();
    innerData2.put("Nilai1", 300);
    innerData2.put("Nilai2", 400);

    // Menambahkan HashMap yang bersarang ke dalam HashMap utama
    data.put("Data1", innerData1);
    data.put("Data2", innerData2);

    System.out.println(data);
  }

  public static void setExample(){
    Set<String> data = new HashSet<>();
    data.add("a");
    data.add("b");
    data.add("c");
    System.out.println(data);
  }

  public static void main(String[] args) throws Exception{
    setExample();
    listExample();
    mapExample();
  }
}
