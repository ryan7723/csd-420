//Official example from https://google.github.io/gson/UserGuide.html#object-examples

import com.google.gson.Gson;

class BagOfPrimitives {
    private int value1 = 1;
    private String value2 = "abc";
    private transient int value3 = 3;
    BagOfPrimitives() {
        // no-args constructor
    }
}

// Serialization
BagOfPrimitives obj = new BagOfPrimitives();
Gson gson = new Gson();
String json = gson.toJson(obj);

// ==> {"value1":1,"value2":"abc"}