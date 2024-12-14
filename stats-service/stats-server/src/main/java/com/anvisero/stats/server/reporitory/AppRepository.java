package com.anvisero.stats.server.reporitory;

import com.anvisero.stats.server.model.App;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AppRepository extends JpaRepository<App, Long> {
    Optional<App> findAppByName(final String name);
}
