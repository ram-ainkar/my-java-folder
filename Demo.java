
import java.util.Arrays;
import java.util.List;

public class Demo {

    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(3, 4, 5, 6, 8);
        int result = nums.stream()
                .filter(n -> n % 2 == 0)
                .map(n -> n * 2)
                .reduce(0, (c, n) -> c + n);
        System.out.println(result);

    }

}