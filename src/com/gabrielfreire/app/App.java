package com.gabrielfreire.app;

/**
 * Created by Gabriel Freire on 10/04/2017.
 */
public class App {

    public static void main(String[] args) {
        //test code
        float[][] trainingData = new float[][]{
                new float[]{(float) 0, 1, (float) 0.88700},
                new float[]{(float) 0.5, 0, (float) 0.20540},
                new float[]{(float) 1, 0, (float) 0.53718},
                new float[]{(float) 0, 1, (float) 0.74456},
                new float[]{(float) 0.5, 0, (float) 0.08728},
                new float[]{(float) 1, 0, (float) 0.68661},
        };
        float[][] trainingResultsOR = new float[][]{new float[]{0}, new float[]{1}, new float[]{1}, new float[]{1}}; //OR
        float[][] trainingResultsAND = new float[][]{new float[]{0}, new float[]{0}, new float[]{0}, new float[]{1}}; //AND
        float[][] trainingResultsXOR = new float[][]{
                new float[]{(float)0.08721},
                new float[]{(float)0.38691},
                new float[]{(float)0.26973},
                new float[]{0},
                new float[]{(float)0.81090},
                new float[]{1}
        };
        BackpropagationNeuralNetwork backpropagationNeuralNetwork = new BackpropagationNeuralNetwork(3, 3, 1);

        for(int iteration = 0; iteration < NeuralNetConstants.ITERATIONS; iteration++){
            for(int i = 0; i < trainingResultsXOR.length; i++){
                backpropagationNeuralNetwork.train(trainingData[i], trainingResultsXOR[i], NeuralNetConstants.LEARNING_RATE, NeuralNetConstants.MOMENTUM);
            }
            System.out.println();
            int count = 0;
            for(int i = 0; i < trainingResultsXOR.length; i++){
                float[] t = trainingData[i];
                float result = backpropagationNeuralNetwork.run(t)[0];
                count++;
                System.out.println("Num of iterations: " + (iteration + 1));
                System.out.printf("Data ke %d, X1=%.1f, X2=%.1f, X3=%f --> OUTPUT=%f : TARGET=%f : GALAT=%f \n",count, t[0], t[1], t[2], result, trainingResultsXOR[i][0], Math.abs(result - trainingResultsXOR[i][0]) );
                if(count>5){
                    count = 0;
                }
            }
        }
    }
}
