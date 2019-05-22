import { put, takeEvery, call } from 'redux-saga/effects';
import { hideLoading, showLoading } from 'react-redux-loading-bar';

import * as actions from './actions';
import { getStudents } from './services';
import { studentConstants } from './types';

const testData = [
  { id: 33, name: 'STUDOSeanoboyo' },
  { id: 34, name: 'Bingo' },
  { id: 35, name: 'Nadim' },
  { id: 36, name: 'Dingo' },
  { id: 37, name: 'Oyster' },
];

/**
 * Retrieves users
 * [ { User } ]
 */
function* fetchStudents(action) {
  try {
    yield put(showLoading());
    // const data = yield call(getStudents);
    yield put(actions.studentsSuccess(testData));
  } catch (e) {
    // yield put(actions.studentsFailure(data(e.message));
  } finally {
    yield put(hideLoading());
  }
}

/**
 * Sets up a list of watchers waiting for request to be dispatched and then calls a matching function
 */
export default function* flowStepSaga() {
  yield takeEvery('STUDENTS_REQUEST', fetchStudents);
}
