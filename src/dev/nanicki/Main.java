package dev.nanicki;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        int[] T = new int[12];
        Scanner scanner = new Scanner(System.in);
        // Given T = [2, −3, 3, 1, 10, 8, 2, 5, 13, −5, 3, −18]:
        for (int i = 0; i < T.length; i++){
           T[i] = scanner.nextInt();
        }

        System.out.println((solution(T)));
    }

    public static String solution(int[] T) {
        String str = "";
        int N = T.length/4;
        int[] Winter = Arrays.copyOfRange(T, 0, N-1);
        int[] Spring = Arrays.copyOfRange(T, N, N*2-1);
        int[] Summer = Arrays.copyOfRange(T, N*2, N*3-1);
        int[] Autumn = Arrays.copyOfRange(T, N*3, T.length);

        int WinterAmplitude = getAmplitude(Winter);
        int SpringAmplitude = getAmplitude(Spring);
        int SummerAmplitude = getAmplitude(Summer);
        int AutumnAmplitude = getAmplitude(Autumn);

        Map<Integer, String> hashMap = new HashMap<>();
        hashMap.put(WinterAmplitude, "WINTER");
        hashMap.put(SpringAmplitude, "SPRING");
        hashMap.put(SummerAmplitude, "SUMMER");
        hashMap.put(AutumnAmplitude, "AUTUMN");


        int max = Math.max(WinterAmplitude, Math.max(SpringAmplitude, Math.max(SummerAmplitude, AutumnAmplitude)));

        return  hashMap.get(max);
        // write your code in Java SE 8
    }

    public static int getAmplitude(int[] T){
        int amplitude;
        amplitude = maxValue(T) - minValue(T);
        return  amplitude;
    }

    public static int maxValue(int[] T){
        Arrays.sort(T);
        int max = T[T.length - 1];
        return max;
    }

    public static int minValue(int[] T){
        int min = T[0];
        for (int i = 0; i < T.length; i++) {
            if (T[i] < T[0]) {
                min = T[i];
            }
        }
        return min;
    }
}
