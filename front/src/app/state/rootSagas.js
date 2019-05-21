import { all } from 'redux-saga/effects';
import user from './ducks/user/sagas';

/**;
 * Calls into action all the saga watcher
 */
export default function* rootSaga() {
  yield all([user]);
}
