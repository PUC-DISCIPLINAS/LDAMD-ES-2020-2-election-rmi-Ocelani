package com.election.exporter.ElectionImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.lob.DefaultLobHandler;
import org.springframework.jdbc.support.lob.LobCreator;
import org.springframework.jdbc.support.lob.LobHandler;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @class ElectionImpl
 */
@Repository
public class ElectionImpl implements VoteListInterface {

    private static final Logger log = LoggerFactory.getLogger(ElectionImpl.class);

    @Autowired
    @Qualifier("jdbc")
    private JdbcTemplate jdbc;

    private LobHandler lobHandler;
    private LobCreator lobCreator;
    private Lock dongleRegisterLock;

    @PostConstruct
    private void init() {
        lobHandler = new DefaultLobHandler();
        lobCreator = lobHandler.getLobCreator();
        dongleRegisterLock = new ReentrantLock();
    }

    @Override
    @Transactional("pgsqlTxManager")
    public boolean create(Vote v) {
        //TODO
        return false;
    }

    @Override
    public VoteList newVote(Vote v) {
        log.info("Getting vote data for id: {}", v.id);
        String sqlId = "SELECT id, candidateId FROM vote WHERE id = ?";

        return jdbc.queryForObject(sql, (rs, i) -> new Vote()
                .setId(rs.getString("id"))
                .setCandidateId(rs.getString("candidateId"))
        , id);
    }

    @Override
    public List<Vote> getAll() {
        log.info("Getting vote list");
        String sql = "SELECT id, FROM vote";
        return jdbc.query(sql, (rs, i) -> new Vote()
                .setId(rs.getString("id"))
                .setName(rs.getString("name")));
    }
}
