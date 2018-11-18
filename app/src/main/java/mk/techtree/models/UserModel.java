package mk.techtree.models;

import com.google.gson.annotations.SerializedName;

public class UserModel {

    @SerializedName("id")
    public String fbID;

    @SerializedName("email")
    public String email;

    @SerializedName("name")
    public String name;

    @SerializedName("picture")
    public String picture;
}
