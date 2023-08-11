public class Task3 {
  public static void main(String[] args) throws Exception {
    int[] array = {3,2,4,1,5};
    int temp = 0;

    for (int i = 0; i < array.length-1; i++) {
      for (int j = 1; j < array.length; j++) {
        if (array[j] < array[j - 1]) {
          temp = array[j];
          array[j] = array[j - 1];
          array[j - 1] = temp;
        }
      }
    }
    
    for (int index : array) {
      System.out.print(index + " ");
    }
  }
}
