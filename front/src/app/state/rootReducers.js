import { combineReducers } from 'redux';
import user from './ducks/User/reducers';
import student from './ducks/student/reducers';
import teachingstaff from './ducks/teachingstaff/reducers';

export default combineReducers({ user, student, teachingstaff });
