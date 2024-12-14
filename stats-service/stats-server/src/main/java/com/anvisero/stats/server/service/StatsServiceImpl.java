package com.anvisero.stats.server.service;

import com.anvisero.stats.dto.model.HitDto;
import com.anvisero.stats.dto.model.StatsDto;
import com.anvisero.stats.server.model.App;
import com.anvisero.stats.server.model.Hit;
import com.anvisero.stats.server.reporitory.AppRepository;
import com.anvisero.stats.server.reporitory.StatsRepository;
import com.anvisero.stats.server.util.mapper.HitMapper;
import com.anvisero.stats.server.util.validator.DateValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static com.anvisero.stats.server.util.validator.DateValidator.validateDateNotInFuture;


@Service
@RequiredArgsConstructor
public class StatsServiceImpl implements StatsService {
    private final StatsRepository statsRepository;
    private final AppRepository appRepository;

    @Override
    @Transactional
    public HitDto hit(final HitDto hitDto) {
        validateDateNotInFuture(hitDto.getTimestamp());
        String appName = hitDto.getApp();
        Optional<App> appOptional = appRepository.findAppByName(appName);
        App app = appOptional.orElseGet(() -> appRepository.save(App.builder().name(hitDto.getApp()).build()));
        Hit hit = HitMapper.toHit(hitDto, app);
        Hit savedHit = statsRepository.save(hit);
        return HitMapper.toHitDto(savedHit, app.getName());
    }

    @Override
    @Transactional(readOnly = true)
    public List<StatsDto> getStats(final LocalDateTime start, final LocalDateTime end,
                                   final List<String> uris, final Boolean unique) {
        DateValidator.validateStartAndEndDate(start, end);
        List<StatsDto> statsDtos;
        if (uris == null) {
            if (unique) {
                statsDtos = statsRepository.findAllStatsInPeriodOfTimeByUniqueIp(start, end);
            } else {
                statsDtos = statsRepository.findAllStatsInPeriodOfTime(start, end);
            }
        } else {
            if (unique) {
                statsDtos = statsRepository.findAllStatsInPeriodOfTimeByUniqueIpAndByUris(start, end, uris);
            } else {
                statsDtos = statsRepository.findAllStatsInPeriodOfTimeByUris(start, end, uris);
            }
        }
        return statsDtos;
    }
}
