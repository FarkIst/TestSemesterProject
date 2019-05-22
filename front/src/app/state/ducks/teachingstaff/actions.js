import { teachingstaffConstants } from './types';

/**
 * action called upon request api call
 */
export const teachingstaffRequest = () => ({
  type: teachingstaffConstants.TEACHINGSTAFF_REQUEST,
});

/**
 * action called up successful api call
 * @param [ { Teachingstaff } ]
 * @return [ { Teachingstaff } ]
 */
export const teachingstaffSuccess = teachingstaff => ({
  type: teachingstaffConstants.TEACHINGSTAFF_SUCCESS,
  teachingstaff,
});

/**
 * action called upon exception returned upon API call
 * @param Error
 * @return Error
 */
export const teachingstaffFailure = err => ({
  type: teachingstaffConstants.TEACHINGSTAFF_FAILURE,
  error: err,
});
