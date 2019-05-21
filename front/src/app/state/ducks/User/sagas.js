import { put, takeEvery, call } from 'redux-saga/effects';
import { hideLoading, showLoading } from 'react-redux-loading-bar';

import * as actions from './actions';
import { getUsers } from './services';
import { userConstants } from './types';

/**
 * Retrieves users
 * [ { User } ]
 */
function* fetchUsers(action) {
  try {
    yield put(showLoading());
    const data = yield call(getUsers);
    yield put(data.users);
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
  yield takeEvery(userConstants.USERS_REQUEST, fetchUsers);
}
