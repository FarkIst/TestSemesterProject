import { put, takeEvery, call } from 'redux-saga/effects';
import { hideLoading, showLoading } from 'react-redux-loading-bar';

import * as actions from './actions';
import { getStudents } from './services';
import { studentConstants } from './types';

/**
 * Retrieves users
 * [ { User } ]
 */
function* fetchStudents(action) {
  try {
    yield put(showLoading());
    const data = yield call(getStudents);
    yield put(data.students);
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
  yield takeEvery(studentConstants.STUDENTS_REQUEST, fetchStudents);
}
