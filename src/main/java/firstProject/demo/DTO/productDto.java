package firstProject.demo.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class productDto {

    @NotBlank(message="Name is mandatory")
    @Size(min = 2,max = 50,message = "Name must be between 2-50 characters")
    private String name;

    @Email
    private String email;

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name=name;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email=email;
    }

}
