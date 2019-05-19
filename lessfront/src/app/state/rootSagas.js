import { all } from 'redux-saga/effects';

/**
 * Calls into action all the saga watcher
 */
export default function* rootSaga() {
  yield all([]);
}
