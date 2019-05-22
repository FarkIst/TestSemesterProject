import { put, takeEvery, call } from 'redux-saga/effects';
import { hideLoading, showLoading } from 'react-redux-loading-bar';

import * as actions from './actions';
import { getTeachingstaff } from './services';
import { teachingstaffConstants } from './types';

/**
 * Retrieves users
 * [ { User } ]
 */
function* fetchTeachingstaff(action) {
  try {
    yield put(showLoading());
    const data = yield call(getTeachingstaff);
    yield put(data.teachingstaff);
  } catch (e) {
    yield put(data(e.message));
  } finally {
    yield put(hideLoading());
  }
}

/**
 * Sets up a list of watchers waiting for request to be dispatched and then calls a matching function
 */
export default function* flowStepSaga() {
  yield takeEvery(
    teachingstaffConstants.TEACHINGSTAFF_REQUEST,
    fetchTeachingstaff,
  );
}
