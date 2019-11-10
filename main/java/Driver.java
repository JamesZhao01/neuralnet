public class Driver {
    public static void main(String[] args) {
        NeuralNet neuralNet = new NeuralNet(4, new int[]{3, 5, 3, 2});
        System.out.print(neuralNet.toString());

    }
}
