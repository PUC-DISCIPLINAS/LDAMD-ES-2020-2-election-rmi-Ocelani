package com.election.middleware.vote

import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;

/*
 * @class VoteServant
 * @param String candidateName    the vote candidate name.
 * @param String id               the vote id.
 */
@SuppressWarnings("serial")
public class VoteServant extends UnicastRemoteObject implements Vote {
  private String id;
	private String candidateName;

  // TODO: implement MD5 method.
  // ! **RF.03** - The **electorId** must be a **MD5 hash** provided by **electorName**.
  public String setId(String id) throws RemoteException {
      this.id = electorName;
      return this.id;
  }

  public String getId() throws RemoteException {
      return this.id;
  }

  public String setCandidateName(String candidateName) throws RemoteException {
    this.candidateName = candidateName;
    return this;
  }

  public String getCandidateName() throws RemoteException {
      return this.candidateName;
  }

  public String toString() {
      return "ID: '" + this.id + "', vote: '" + this.vote + "'";
  }

}
