
import java.util.ArrayList;
import java.util.List;

public class Result {
    public List<String> items;

    public Result(List<Integer> result) {
        if (result != null) {
            items = new ArrayList<>();
            for (Integer res : result) {
                items.add(res.toString());
            }
        }
    }
}