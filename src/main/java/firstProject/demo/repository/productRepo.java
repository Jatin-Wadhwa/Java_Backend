package firstProject.demo.repository;


import firstProject.demo.model.productModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface productRepo extends JpaRepository<productModel, Long> {
}