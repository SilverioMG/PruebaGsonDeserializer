package net.atopecode.pruebagsondeserializer;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.annotations.JsonAdapter;

public class Application {

    public static void main(String[] args){
        ModelBase model1 = new Model1("nombre", "apellidos", "campo1");
        JsonObject model1Json = model1.toJson();

        ModelBase model = ModelBase.fromJson(model1Json);
        JsonObject modelJson = model.toJson();
        System.out.println(modelJson.toString());

        ModelCollection modelCollection = new ModelCollection();
        modelCollection.add(
                new Model1("nombre1", "apellidos1", "campo1")
        );
        modelCollection.add(
                new Model1("nombre2", "apellido2", "campo2")
        );
        modelCollection.add(
                new ModelBase("nombre", "apellidos")
        );

        JsonObject json = modelCollection.toJson();
        modelCollection = ModelCollection.fromJson(json);
        System.out.println(modelCollection.toString());
//        JsonObject json = new JsonObject();
//        JsonArray models = new JsonArray();
//        models.add(new ModelBase("nombre", "apellidos").toJson());
//        json.add("models", models);
//        ModelCollection modelCollection = ModelCollection.fromJson(json);
    }
}
