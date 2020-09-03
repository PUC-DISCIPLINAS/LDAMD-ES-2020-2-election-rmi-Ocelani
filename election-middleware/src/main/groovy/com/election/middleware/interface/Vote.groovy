package com.election.middleware.Vote

/**
 * Vote.
 *
 * @interface Vote
 * @param String candidateName    the vote candidate name.
 * @param String id               the vote id.
 */
interface Vote extends Remote {

  String setId(String id);
  String getId();

  String setCandidateName(String candidateName);
  String getCandidateName();

}
