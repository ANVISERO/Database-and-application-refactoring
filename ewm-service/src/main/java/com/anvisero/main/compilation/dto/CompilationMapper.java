package com.anvisero.main.compilation.dto;

import com.anvisero.main.compilation.model.Compilation;
import com.anvisero.main.event.dto.EventMapper;
import com.anvisero.main.event.model.Event;
import lombok.experimental.UtilityClass;

import java.util.List;
import java.util.stream.Collectors;

@UtilityClass
public class CompilationMapper {

    public Compilation compilationInputDtoToCompilation(final CompilationInputDto compilationInputDto,
                                                        final List<Event> events) {
        return Compilation.builder()
                .pinned(compilationInputDto.getPinned() != null ? compilationInputDto.getPinned() : false)
                .title(compilationInputDto.getTitle())
                .events(events)
                .build();
    }

    public CompilationOutputDto compilationToCompilationOutputDto(final Compilation compilation) {
        return CompilationOutputDto.builder()
                .pinned(compilation.getPinned())
                .title(compilation.getTitle())
                .id(compilation.getId())
                .events(compilation.getEvents().stream()
                        .map(EventMapper::eventToEventShortOutputDto)
                        .collect(Collectors.toList()))
                .build();
    }

    public Compilation updateCompilation(final CompilationInputDto compilationInputDto,
                                         final Compilation compilation, final List<Event> events) {
        return Compilation.builder()
                .title(compilationInputDto.getTitle() != null
                        ? compilationInputDto.getTitle() : compilation.getTitle())
                .pinned(compilationInputDto.getPinned() != null
                        ? compilationInputDto.getPinned() : compilation.getPinned())
                .id(compilation.getId())
                .events(events)
                .build();
    }
}
