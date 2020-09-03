package com.election.middleware.vote

/*
 * @interface Vote
 * @param String candidateName    the vote candidate name.
 * @param String id               the vote id.
 */
interface VoteList extends Remote {

  	Shape newShape(GraphicalObject g) throws RemoteException;
    Vector<Vote> allShapes() throws RemoteException;

    String setId(String id);
    String getId();
    String setCandidateName(String candidateName);
    String getCandidateName();

}
