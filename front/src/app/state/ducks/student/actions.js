import { studentConstants } from './types';

/**
 * action called upon request api call
 */
export const studentsRequest = () => ({
  type: studentConstants.STUDENTS_REQUEST,
});

/**
 * action called up successful api call
 * @param [ { Student } ]
 * @return [ { Student } ]
 */
export const studentsSuccess = students => ({
  type: studentConstants.STUDENTS_SUCCESS,
  students,
});

/**
 * action called upon exception returned upon API call
 * @param Error
 * @return Error
 */
export const studentsFailure = err => ({
  type: studentConstants.STUDENTS_FAILURE,
  error: err,
});
