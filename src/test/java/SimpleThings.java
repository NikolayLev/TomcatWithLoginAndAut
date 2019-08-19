import org.junit.Test;

public class SimpleThings {
    @Test
    public void parseInt(){
        String i = "11";
        String b = "22";
        int z = Integer.parseInt(i);
        int x;
        try {
            x=Integer.parseInt(b);

        }catch (NumberFormatException ex){
            System.err.println(b+" не числовое значение, цена назначена и равна 0");
            x=0;
        }
        System.out.println(x);


    }
}
