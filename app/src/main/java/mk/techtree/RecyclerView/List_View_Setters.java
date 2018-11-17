package mk.techtree.RecyclerView;

public class List_View_Setters {

    private String name_project;
    private String description;
    private String code;
    private String image;
    private String things;
    private String build;
    private String funtionality;



    public List_View_Setters(String name_project, String description, String code,
                             String image,String things,String build,String funtionality) {
        this.name_project = name_project;
        this.description = description;
        this.code = code;
        this.image = image;
        this.things=things;
        this.build=build;
        this.funtionality=funtionality;

    }

    public String getThings() {
        return things;
    }

    public void setThings(String things) {
        this.things = things;
    }

    public String getBuild() {
        return build;
    }

    public void setBuild(String build) {
        this.build = build;
    }

    public String getFuntionality() {
        return funtionality;
    }

    public void setFuntionality(String funtionality) {
        this.funtionality = funtionality;
    }

    public String getName_project() {
        return name_project;
    }

    public void setName_project(String name_project) {
        this.name_project = name_project;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
