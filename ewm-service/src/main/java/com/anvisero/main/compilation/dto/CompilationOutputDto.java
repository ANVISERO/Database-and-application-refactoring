package com.anvisero.main.compilation.dto;

import com.anvisero.main.event.dto.EventShortOutputDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public final class CompilationOutputDto {
    private List<EventShortOutputDto> events;

    private Boolean pinned;

    private String title;

    private Long id;
}
