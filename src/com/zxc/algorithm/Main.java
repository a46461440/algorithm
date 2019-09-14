import java.util.*;

public class Main {

    private static void setBackOne(int[] as, int[] bs, int r) {
        List<Integer[]> result = new ArrayList();
        for (int i = 0; i < as.length; i++) {
            int min = Integer.MAX_VALUE;
            boolean flag = true;
            for (int j = 0; j < bs.length; j++) {
                if (bs[j] > as[i]) {
                    int jl = bs[j] - as[i];
                    if (jl < min) {
                        min = jl;
                    }
                    if (jl <= r) {
                        flag = false;
                        result.add(new Integer[]{as[i], bs[j]});
                    }
                }
            }
            if (flag && min != Integer.MAX_VALUE) {
                result.add(new Integer[]{as[i], min});
            }
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        int[] as = new int[]{1, 3, 5};
        int[] bs = new int[]{2, 4, 6};
        setBackOne(as, bs, 1);
    }

}