package firstProject.demo.model;

import jakarta.persistence.*;


@Entity
@Table(name = "products")
public class productModel{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String email;

    public productModel(){}
    public productModel( String name,String email){
        this.name=name;
        this.email=email;
    }


    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}