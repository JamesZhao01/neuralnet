import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * This class represents the main class for the CNN
 */
public class NeuralNet {

    /**
     * n = the number of "value" layers in the CNN
     * n = 1(input layer) + 1(output layer) + the number of hidden layers
     */
    int n;

    private double[][] aLayers;

    private double[][][] wLayers;

    private double[] biases;

    private int[] layerSizes;

    public NeuralNet(int n, int[] layerSizes) {
        if(n < 3) {
            throw new RuntimeException("n cannot be less than 3!");
        }
        if(layerSizes.length != n) {
            throw new RuntimeException("The layer sizes array != n");
        }
        this.n = n;
        this.layerSizes = layerSizes;
        aLayers = new double[n][];
        wLayers = new double[n-1][][];
        biases = new double[n-1];
        initializeLayers(n, layerSizes);
    }


    private void initializeLayers(int n, int[] layerSizes){
        for(int i = 0; i < n; i++){
            int layerSizeAtI = layerSizes[i];
            if(layerSizeAtI < 1) {
                throw new RuntimeException("invalid layer size: " + layerSizeAtI);
            }
            aLayers[i] = new double[layerSizeAtI];
            if(i != 0) {
                wLayers[i - 1] = new double[layerSizes[i - 1]][layerSizeAtI];
            }
        }
    }

    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder();
        for(int i = n - 1; i >= 0; i--) {
            if(i != n - 1) {
                builder.append(String.format("[w%d: %d x %d, a%d: %d], ", i, wLayers[i].length,  wLayers[i][0].length, i, aLayers[i].length));
            } else {
                builder.append(String.format("[a%d: %d], ", i, aLayers[i].length));
            }
        }
        return String.format("Neural Network info: %s", builder.toString());
    }
}
