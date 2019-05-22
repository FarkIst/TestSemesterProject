import { put, takeEvery, call } from 'redux-saga/effects';
import { hideLoading, showLoading } from 'react-redux-loading-bar';

import * as actions from './actions';
import { getUsers } from './services';
import { userConstants } from './types';

const testData = [
  { id: 33, name: 'Seanoboyo' },
  { id: 34, name: 'Bingo' },
  { id: 35, name: 'Nadim' },
  { id: 36, name: 'Dingo' },
  { id: 37, name: 'Oyster' },
];

/**
 * Retrieves users
 * [ { User } ]
 */
function* fetchUsers(action) {
  try {
    yield put(showLoading());
    // const data = yield call(getUsers);
    const data = testData;
    yield put(actions.usersSuccess(testData));
  } catch (e) {
    yield put(actions.usersFailure(data(e.message)));
  } finally {
    yield put(hideLoading());
  }
}

/**
 * Sets up a list of watchers waiting for request to be dispatched and then calls a matching function
 */
export default function* userSaga() {
  yield takeEvery('USERS_REQUEST', fetchUsers);
}
