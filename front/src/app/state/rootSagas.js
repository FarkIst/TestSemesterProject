import { all } from 'redux-saga/effects';
import user from './ducks/user/sagas';
import student from './ducks/student/sagas';
import teachingstaff from './ducks/teachingstaff/sagas';
/**;
 * Calls into action all the saga watcher
 */
export default function* rootSaga() {
  yield all([user, student, teachingstaff]);
}
