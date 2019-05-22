import { put, takeEvery, call } from 'redux-saga/effects';
import { hideLoading, showLoading } from 'react-redux-loading-bar';

import * as actions from './actions';
import { getTeachingstaff } from './services';
import { teachingstaffConstants } from './types';

const testData = [
  { id: 33, name: 'TEACHASeanoboyo' },
  { id: 34, name: 'Bingo' },
  { id: 35, name: 'Nadim' },
  { id: 36, name: 'Dingo' },
  { id: 37, name: 'Oyster' },
];

/**
 * Retrieves users
 * [ { User } ]
 */
function* fetchTeachingstaff(action) {
  try {
    yield put(showLoading());
    //    const data = yield call(getTeachingstaff);
    yield put(actions.teachingstaffSuccess(testData));
  } catch (e) {
    // yield put(actions.teachingstaffFailure(data(e.message)));
  } finally {
    yield put(hideLoading());
  }
}

/**
 * Sets up a list of watchers waiting for request to be dispatched and then calls a matching function
 */
export default function* teacherSaga() {
  yield takeEvery('TEACHINGSTAFF_REQUEST', fetchTeachingstaff);
}
