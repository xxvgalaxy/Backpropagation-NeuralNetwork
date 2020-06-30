package com.gabrielfreire.app;

/**
 * Created by Gabriel Freire on 10/04/2017.
 */
public class App {

    public static void main(String[] args) {
        //test code
        float[][] trainingData = new float[][]{
                new float[]{(float) 0, 1, 1},
                new float[]{(float) 0.5, 0, (float) 0.147700815},
                new float[]{(float) 1, 0, (float) 0.562572759},
                new float[]{(float) 0, 1, (float) 0.821885914},
                new float[]{(float) 0.5, 0, 0},
                new float[]{(float) 1, 0, (float) 0.749417928},
        };
        float[][] trainingResultsOR = new float[][]{new float[]{0}, new float[]{1}, new float[]{1}, new float[]{1}}; //OR
        float[][] trainingResultsAND = new float[][]{new float[]{0}, new float[]{0}, new float[]{0}, new float[]{1}}; //AND
        float[][] trainingResultsXOR = new float[][]{new float[]{0}, new float[]{1}, new float[]{1}, new float[]{0}}; //XOR
        BackpropagationNeuralNetwork backpropagationNeuralNetwork = new BackpropagationNeuralNetwork(3, 3, 1);

        for(int iteration = 0; iteration < NeuralNetConstants.ITERATIONS; iteration++){
            for(int i = 0; i < trainingResultsXOR.length; i++){
                backpropagationNeuralNetwork.train(trainingData[i], trainingResultsXOR[i], NeuralNetConstants.LEARNING_RATE, NeuralNetConstants.MOMENTUM);
            }
            System.out.println();
            for(int i = 0; i < trainingResultsXOR.length; i++){
                float[] t = trainingData[i];
                System.out.println("Num of iterations: " + (iteration + 1));
                System.out.printf("%.1f, %.1f, %.1f --> %.3f\n", t[0], t[1], t[2], backpropagationNeuralNetwork.run(t)[0]);
            }
        }
    }
}
