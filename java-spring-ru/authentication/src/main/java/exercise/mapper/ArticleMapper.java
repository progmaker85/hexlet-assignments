package exercise.mapper;

import exercise.dto.ArticleCreateDTO;
import exercise.dto.ArticleDTO;
import exercise.dto.ArticleUpdateDTO;
import exercise.model.Article;
import org.mapstruct.*;

@Mapper(
        uses = {JsonNullableMapper.class},
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public abstract class ArticleMapper {

    public abstract Article map(ArticleCreateDTO dto);

    @Mapping(source = "author.name", target = "author")
    public abstract ArticleDTO map(Article model);

    public abstract void update(ArticleUpdateDTO dto, @MappingTarget Article model);
}
