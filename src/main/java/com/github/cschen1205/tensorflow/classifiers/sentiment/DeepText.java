package com.github.cschen1205.tensorflow.classifiers.sentiment;

import com.github.cschen1205.tensorflow.classifiers.sentiment.models.BidirectionalLstmSentimentClassifier;
import com.github.cschen1205.tensorflow.classifiers.sentiment.models.Sentiment;
import com.github.cschen1205.tensorflow.classifiers.sentiment.utils.ResourceUtils;

import java.io.IOException;

public class DeepText {
    private BidirectionalLstmSentimentClassifier classifier = new BidirectionalLstmSentimentClassifier();

    public DeepText() {
        try {
            classifier.load_model(ResourceUtils.getInputStream("tf_models/bidirectional_lstm_softmax.pb"));
            classifier.load_vocab(ResourceUtils.getInputStream("tf_models/bidirectional_lstm_softmax.csv"));
        }catch(IOException ex) {
            ex.printStackTrace();
        }
    }

    public Sentiment predictSentiment(String doc) {
        float[] ratings = classifier.predict(doc);
        Sentiment result = new Sentiment();
        result.setPositiveProb(ratings[0]);
        result.setNegativeProb(ratings[1]);
        result.setPositive(result.getPositiveProb() >= result.getNegativeProb());
        result.setSentence(doc);
        return result;
    }
}
