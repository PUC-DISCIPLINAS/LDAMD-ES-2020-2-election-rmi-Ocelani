package com.election.server

import java.rmi.RemoteException

/**
 * Extracts the args from the input arguments.
 *
 * Precondition: 'args' should contain at least one element.
 *
 * @param  String str         the message arguments from the client.
 * @return String str.length  the message arguments from the client.
 * @throws RemoteException    if 'str' contains no element.
 */
public interface Election implements Election {

  @Override
  int echoMessage(String str) throws RemoteException {
    LOGGER.log( 'Got a message from the client: ' + str )

    return str.length()
  }

}
