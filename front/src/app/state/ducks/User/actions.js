import { userConstants } from './types';

/**
 * action called upon request api call
 */
export const usersRequest = () => ({
  type: userConstants.USERS_REQUEST,
});

/**
 * action called up successful api call
 * @param [ { User } ]
 * @return [ { User } ]
 */
export const usersSuccess = users => ({
  type: userConstants.USERS_SUCCESS,
  users,
});

/**
 * action called upon exception returned upon API call
 * @param Error
 * @return Error
 */
export const usersFailure = err => ({
  type: userConstants.USERS_FAILURE,
  error: err,
});
