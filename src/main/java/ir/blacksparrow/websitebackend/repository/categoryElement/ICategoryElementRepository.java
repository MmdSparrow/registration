package ir.blacksparrow.websitebackend.repository.categoryElement;

import ir.blacksparrow.websitebackend.dataModel.CategoryElementEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryElementRepository extends JpaRepository<CategoryElementEntity, Long> {
}
