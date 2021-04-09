package br.com.avexadoFarm.infrastructure.search.annotation;

import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import java.lang.reflect.Field;
import java.util.Locale;

@Component
@RequestScope
public class SearchPredicate {

    public BooleanExpression getPredicate(Object object) {
        SearchEntity entity = object.getClass().getAnnotation(SearchEntity.class);
        PathBuilder<?> pathBuilder = new PathBuilder<>(entity.getClass(), entity.value().getSimpleName().toLowerCase());

        Field[] fields = object.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            try {
                Object valor = field.get(object);
                if (valor != null){
                    SearchParam searchParam = field.getAnnotation(SearchParam.class);
                    String param = searchParam.property();
                    StringPath path = pathBuilder.getString(param);
                    return path.containsIgnoreCase(valor.toString());
                }
            } catch (IllegalArgumentException | IllegalAccessException e) {
                throw new IllegalArgumentException();
            }
        }
        return Expressions.asBoolean(true).isTrue();
    }

}
