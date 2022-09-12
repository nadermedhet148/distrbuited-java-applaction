package com.javadist.teams.infrastructure.dao;

import com.javadist.teams.infrastructure.model.Team;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TeamDao extends CrudRepository<Team, Long> {
}
