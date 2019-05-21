import { userConstants } from './types';
import { updateObject } from '../../../shared/helpers/objectHelper';

/**
 * Sets the initial state in the store before it is set by a successful action
 */
const initialState = {};

/**
 * Dispatch request is being processed
 * @return initial state and updating is set to true
 */
const usersRequest = (state, action) => updateObject(state, { updating: true });

/**
 * Action for successful users dispatch
 * No exceptions were caught during the dispatch
 * @return the existing state and the fetched list of users updating completed and is set to false
 */
const usersSuccess = (state, action) =>
  updateObject(state, { users: action.usersSuccess, updating: false });

/**
 * Exception was caught during dispatch
 * @return the existing state, error is set to true and updating set to false
 */
const usersFailure = (state, action) =>
  updateObject(state, { error: true, updating: false });

/**
 * Sends data to the store according to which action is called
 */
const reducer = (state = initialState, action) => {
  switch (action.type) {
    case userConstants.usersRequest:
      return usersRequest(state, action);
    case userConstants.usersSuccess:
      return usersSuccess(state, action);
    case userConstants.usersFailure:
      return usersFailure(state, action);
    default:
      return state;
  }
};

export default reducer;
