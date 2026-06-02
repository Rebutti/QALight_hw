package aqa_hw_21.dto;

public class CategoryDto {
    private int id;
    private String name;

    public CategoryDto(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public CategoryDto(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CategoryDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
