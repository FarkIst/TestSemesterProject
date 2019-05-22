import { all, fork } from 'redux-saga/effects';
import user from './ducks/User/sagas';
import student from './ducks/student/sagas';
import teachingstaff from './ducks/teachingstaff/sagas';
/**;
 * Calls into action all the saga watcher
 */
export default function* rootSaga() {
  yield all([fork(user), fork(teachingstaff), fork(student)]);
}
