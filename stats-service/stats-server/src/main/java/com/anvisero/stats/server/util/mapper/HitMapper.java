package com.anvisero.stats.server.util.mapper;

import com.anvisero.stats.dto.model.HitDto;
import com.anvisero.stats.server.model.App;
import com.anvisero.stats.server.model.Hit;

public class HitMapper {
    public static Hit toHit(final HitDto hitDto, final App app) {
        return Hit.builder()
                .app(app)
                .uri(hitDto.getUri())
                .ip(hitDto.getIp())
                .timestamp(hitDto.getTimestamp())
                .build();
    }

    public static HitDto toHitDto(final Hit hit, final String appName) {
        return HitDto.builder()
                .uri(hit.getUri())
                .app(appName)
                .ip(hit.getIp())
                .timestamp(hit.getTimestamp())
                .build();
    }
}
