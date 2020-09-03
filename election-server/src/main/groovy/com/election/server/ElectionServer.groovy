package com.election.server

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import java.rmi.RemoteException
import java.rmi.registry.LocateRegistry
import java.rmi.registry.Registry
import java.rmi.server.UnicastRemoteObject

/*
 * Runs the server application.
 *
 * @param String[] args     the command arguments.
 * @catch RemoteException   if 'args' contains no context element.
 */
@SpringBootApplication
class ElectionServer {

  static void main(String[] args) {
    SpringApplication.run(ElectionServer, args)

    try {
      // Export the object stub.
      PrintingInterface stub = (PrintingInterface) UnicastRemoteObject.exportObject(implementation, 0)
      Registry registry = LocateRegistry.getRegistry()
      // Set the string to use in order to lookup the remote class.
      registry.rebind('Election', stub)
      // Catch
    } catch (RemoteException e) {
      LOGGER.log('context', e)
      return
    }
  }

}
