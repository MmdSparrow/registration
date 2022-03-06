package ir.blacksparrow.websitebackend.repository;

import lombok.Data;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class ParentRepository {
    private final ModelMapper modelMapper=new ModelMapper();

    protected <S, T> List<T> mapList(List<S> source, Class<T> targetClass) {
        return source
                .stream()
                .map(element -> modelMapper.map(element, targetClass))
                .collect(Collectors.toList());

    }
}
