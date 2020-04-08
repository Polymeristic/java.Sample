import java.text.DecimalFormat;
import java.util.Scanner;


public class LyndaConditionals {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            if (i == 5) {
                continue;
            }

            System.out.println(i);
        }
    }
}
