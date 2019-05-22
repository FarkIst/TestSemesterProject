import { studentConstants } from './types';
import { updateObject } from '../../../shared/helpers/objectHelper';

/**
 * Sets the initial state in the store before it is set by a successful action
 */
const initialState = { students: [] };

/**
 * Dispatch request is being processed
 * @return initial state and updating is set to true
 */
const studentsRequest = (state, action) =>
  updateObject(state, { students: [], updating: true });

/**
 * Action for successful users dispatch
 * No exceptions were caught during the dispatch
 * @return the existing state and the fetched list of users updating completed and is set to false
 */
const studentsSuccess = (state, action) =>
  updateObject(state, { students: action.students, updating: false });

/**
 * Exception was caught during dispatch
 * @return the existing state, error is set to true and updating set to false
 */
const studentsFailure = (state, action) =>
  updateObject(state, { students: [], error: true, updating: false });

/**
 * Sends data to the store according to which action is called
 */
const reducer = (state = initialState, action) => {
  switch (action.type) {
    case studentConstants.STUDENTS_REQUEST:
      return studentsRequest(state, action);
    case studentConstants.STUDENTS_SUCCESS:
      return studentsSuccess(state, action);
    case studentConstants.STUDENTS_FAILURE:
      return studentsFailure(state, action);
    default:
      return state;
  }
};

export default reducer;
