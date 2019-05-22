import { teachingstaffConstants } from './types';
import { updateObject } from '../../../shared/helpers/objectHelper';

/**
 * Sets the initial state in the store before it is set by a successful action
 */
const initialState = { teachingstaff: [] };

/**
 * Dispatch request is being processed
 * @return initial state and updating is set to true
 */
const teachingstaffRequest = (state, action) =>
  updateObject(state, { teachingstaff: [], updating: true });

/**
 * Action for successful users dispatch
 * No exceptions were caught during the dispatch
 * @return the existing state and the fetched list of users updating completed and is set to false
 */
const teachingstaffSuccess = (state, action) =>
  updateObject(state, { teachingstaff: action.teachingstaff, updating: false });

/**
 * Exception was caught during dispatch
 * @return the existing state, error is set to true and updating set to false
 */
const teachingstaffFailure = (state, action) =>
  updateObject(state, { teachingstaff: [], error: true, updating: false });

/**
 * Sends data to the store according to which action is called
 */
const reducer = (state = initialState, action) => {
  switch (action.type) {
    case teachingstaffConstants.TEACHINGSTAFF_REQUEST:
      return teachingstaffRequest(state, action);
    case teachingstaffConstants.TEACHINGSTAFF_SUCCESS:
      return teachingstaffSuccess(state, action);
    case teachingstaffConstants.TEACHINGSTAFF_FAILURE:
      return teachingstaffFailure(state, action);
    default:
      return state;
  }
};

export default reducer;
