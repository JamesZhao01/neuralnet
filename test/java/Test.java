import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;
import org.nd4j.linalg.factory.Nd4jBackend;

public class Test {
    @org.junit.jupiter.api.Test
    public void test(){
        INDArray arr = Nd4j.ones(3, 3);
        System.out.println(arr);
    }
}
