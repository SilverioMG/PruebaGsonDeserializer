package net.atopecode.pruebagsondeserializer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.annotations.JsonAdapter;

//@JsonAdapter(ModelDeserializer.class)
public class ModelBase {

    private String nombre;
    private String apellidos;

    public ModelBase(){

    }

    public ModelBase(String nombre, String apellidos) {
        this.nombre = nombre;
        this.apellidos = apellidos;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public JsonObject toJson(){
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(ModelBase.class, new ModelSerializer())
                .serializeNulls()
                .create();
        return gson.toJsonTree(this).getAsJsonObject();
    }

    public static ModelBase fromJson(JsonObject json){
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(ModelBase.class, new ModelDeserializer())
                .serializeNulls()
                .create();
        return gson.fromJson(json, ModelBase.class);
    }
}
