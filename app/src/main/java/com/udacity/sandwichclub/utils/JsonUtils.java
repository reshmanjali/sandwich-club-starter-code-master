package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {

       Sandwich sandwichObject=new Sandwich();
        try {
            JSONObject myJsonObject=new JSONObject(json);
            JSONObject nameObject=myJsonObject.getJSONObject("name");
            String mainNameString=nameObject.getString("mainName");
            JSONArray alsoKnownJsonArray=nameObject.getJSONArray("alsoKnownAs");
            List<String> alsoKnownList=new ArrayList<>();
            for(int i=0;i<alsoKnownJsonArray.length();i++)
                alsoKnownList.add(alsoKnownJsonArray.getString(i));
            String placeOfOriginString=myJsonObject.getString("placeOfOrigin");
            String descString=myJsonObject.getString("description");
            String imageString=myJsonObject.getString("image");
            JSONArray ingredientsJsonArray=myJsonObject.getJSONArray("ingredients");
            List<String> ingredientsList=new ArrayList<>();
            for(int i=0;i<ingredientsJsonArray.length();i++)
                ingredientsList.add(ingredientsJsonArray.getString(i));
            sandwichObject=new Sandwich(mainNameString,alsoKnownList,placeOfOriginString,descString,imageString,ingredientsList);
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
        return sandwichObject;
    }
}
