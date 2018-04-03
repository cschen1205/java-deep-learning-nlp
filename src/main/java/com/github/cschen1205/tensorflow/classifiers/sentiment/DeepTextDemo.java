package com.github.cschen1205.tensorflow.classifiers.sentiment;
import com.github.cschen1205.tensorflow.classifiers.sentiment.models.Sentiment;
import com.github.cschen1205.tensorflow.classifiers.sentiment.utils.ResourceUtils;

import java.io.IOException;
import java.util.List;

public class DeepTextDemo {
    public static void main(String[] args) throws IOException {
        DeepText classifier = new DeepText();

        List<String> lines = ResourceUtils.getLines("data/umich-sentiment-train.txt");

        for(String line : lines){
            String label = line.split("\t")[0];
            String text = line.split("\t")[1];
            Sentiment sentiment = classifier.predictSentiment(text);
            System.out.println("Actual: " + label);
            System.out.println("Predicted: " + sentiment);

        }
    }
}
