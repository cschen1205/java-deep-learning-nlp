package com.github.cschen1205.tensorflow.classifiers.sentiment.models;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Sentiment {
    private boolean positive;
    private double positiveProb;
    private double negativeProb;
    private String sentence;

    @Override
    public String toString() {
        return JSON.toJSONString(this, SerializerFeature.PrettyFormat);
    }
}
