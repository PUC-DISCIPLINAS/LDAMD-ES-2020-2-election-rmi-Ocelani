package com.nomad.srgp.rmi

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @author Otávio Celani
 */
public interface PersonInterface {
  public boolean create(Person p);
  public Person getBasicInfo(String id);
  public String getName(String id);
  public List<Person> getAll();
}

package com.bdb.rmiclient.compute;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Compute extends Remote {
    <T> T executeTask(Task<T> t) throws RemoteException;
}
