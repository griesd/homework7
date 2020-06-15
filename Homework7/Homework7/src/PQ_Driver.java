import java.util.Random;
public class PQ_Driver {
    private Priority_Queue test = new Priority_Queue();
    private static final int MAGIC = 200;


    public static void main(String[] args) {
        PQ_Driver tester = new PQ_Driver();
        tester.getArray().createPQ(tester.populateArray());
        System.out.println();
        System.out.println(tester.getArray());


        System.out.println(tester.getArray());
        while(!tester.getArray().isEmpty()){
            System.out.print(tester.getArray().removeMaxValue());
            System.out.print(" ");

        }



    }

    /**
     * populates an array
     * @return
     */
    public Integer[] populateArray(){
        Integer [] list = new Integer[MAGIC];
        for(int i = 0; i <= MAGIC - 1;i++){
            list[i] = randomInt();
        }
        for (int i = 0; i <= MAGIC - 1; i++) {
            System.out.print(list[i] + " ");
        }
        return list;
    }

    /**
     * returns a random int
     * @return
     */
    private Integer randomInt(){
        Random rng = new Random();
        return rng.nextInt(500);
    }

    public Priority_Queue getArray(){
        return test;
    }
}

