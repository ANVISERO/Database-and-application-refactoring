package com.anvisero.stats.server.reporitory;

import com.anvisero.stats.dto.model.StatsDto;
import com.anvisero.stats.server.model.Hit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface StatsRepository extends JpaRepository<Hit, Long> {

    @Query("SELECT new com.anvisero.stats.dto.model.StatsDto(a.name, h.uri, COUNT(h.ip) AS hits) " +
            "FROM Hit AS h, App AS a " +
            "WHERE h.timestamp BETWEEN :start AND :end " +
            "GROUP BY a.name, h.uri " +
            "ORDER BY hits DESC")
    List<StatsDto> findAllStatsInPeriodOfTime(@Param("start") final LocalDateTime start,
                                              @Param("end") final LocalDateTime end);

    @Query("SELECT new com.anvisero.stats.dto.model.StatsDto(a.name, h.uri, COUNT(h.ip) AS hits) " +
            "FROM Hit AS h, App AS a " +
            "WHERE h.uri IN :uris AND h.timestamp BETWEEN :start AND :end " +
            "GROUP BY a.name, h.uri " +
            "ORDER BY hits DESC")
    List<StatsDto> findAllStatsInPeriodOfTimeByUris(@Param("start") final LocalDateTime start,
                                                    @Param("end") final LocalDateTime end,
                                                    @Param("uris") final List<String> uris);


    @Query("SELECT new com.anvisero.stats.dto.model.StatsDto(a.name, h.uri, COUNT(DISTINCT h.ip) AS hits) " +
            "FROM Hit AS h, App AS a " +
            "WHERE h.timestamp BETWEEN :start AND :end " +
            "GROUP BY a.name, h.uri " +
            "ORDER BY hits DESC")
    List<StatsDto> findAllStatsInPeriodOfTimeByUniqueIp(@Param("start") final LocalDateTime start,
                                                        @Param("end") final LocalDateTime end);


    @Query("SELECT new com.anvisero.stats.dto.model.StatsDto(a.name, h.uri, COUNT(DISTINCT h.ip) AS hits) " +
            "FROM Hit AS h, App AS a " +
            "WHERE h.uri IN :uris AND h.timestamp BETWEEN :start AND :end " +
            "GROUP BY a.name, h.uri " +
            "ORDER BY hits DESC")
    List<StatsDto> findAllStatsInPeriodOfTimeByUniqueIpAndByUris(@Param("start") final LocalDateTime start,
                                                                 @Param("end") final LocalDateTime end,
                                                                 @Param("uris") final List<String> uris);
}
