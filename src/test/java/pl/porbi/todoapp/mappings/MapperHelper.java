package pl.porbi.todoapp.mappings;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;

public class MapperHelper {
    public static Mapper getMapper() {
        return DozerBeanMapperBuilder.create()
                /*.withMappingFiles()*/
                .build();
    }
}
