package ir.blacksparrow.websitebackend.repository.category;

import ir.blacksparrow.websitebackend.dataModel.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ICategoryRepository extends JpaRepository<CategoryEntity, Long> {
    @Query(value = "SELECT *" +
            " FROM DGS_CATEGORY" +
            " WHERE (?1 is null or CODE = ?1) " +
            " and (?2 is null or TITLE = ?2)"
            , nativeQuery = true)
    List<CategoryEntity> search(String code, String title);
}
