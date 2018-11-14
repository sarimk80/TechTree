package mk.techtree.RecyclerView;

public class List_View_Setters {

    private String name_project;
    private String description;
    private String code;
    private String image;


    public List_View_Setters(String name_project, String description, String code, String image) {
        this.name_project = name_project;
        this.description = description;
        this.code = code;
        this.image = image;

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
