import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//binary number
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner=new Scanner(System.in);

        int n = scanner.nextInt();
        String[] group=Integer.toBinaryString(n).split("0");
        int max = 0;
        for(String s : group){
            if(0 < s.length()){
                max = s.length();
            }
        }
        System.out.println(max);
    }
}
