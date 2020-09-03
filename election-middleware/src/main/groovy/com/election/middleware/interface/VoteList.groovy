package com.election.middleware.interface.VoteList

/**
 * VoteList.
 *
 * @interface Vote
 */
interface VoteList extends Remote {

  Vote newVote(String candidateName) throws RemoteException;

  Vector<Vote> allVotes() throws RemoteException;

  String getCandidateVersion() throws RemoteException;

}
