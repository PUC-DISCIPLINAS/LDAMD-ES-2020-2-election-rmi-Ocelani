package com.election.middleware.servant.VoteListServant

import java.rmi.*
import java.rmi.server.UnicastRemoteObject

/**
 * VoteListServant.
 *
 * @class VoteServant
 * @param String candidateId      the version of the candidate id.
 * @param Vector<Vote> voteList   the candidate vote list.
 */
class VoteListServant extends UnicastRemoteObject implements Vote {

	private Vector<Vote> voteList;
	private int candidateId;

	public VoteListServant() throws RemoteException {
		voteList = new Vector<Vote>();
		candidateId = 0;
	}

	public Vote newVote(GraphicalObject g) throws RemoteException {
		candidateId++;
		Vote s = new VoteServant(g, candidateId);
		voteList.addElement(s);
		return s;
	}

	public Vector<Vote> allVotes() throws RemoteException {
		return voteList;
	}

	public int getCandidateIdVersion() throws RemoteException {
		return candidateId;
	}

}
