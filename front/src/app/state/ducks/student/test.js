import configureStore from 'redux-mock-store';
import { studentConstants } from './types';

import reducer from './reducers';
import * as actions from './actions';
import sagas from './sagas';
import services from './services';
import selectors from './selectors';

const mockStore = configureStore();
const store = mockStore();

/**
 * Test modules' reducers
 */
describe('reducer', () => {
  /**
   * Tests that the initial state is returned if no action type is dispatched
   */
  it('should return the initial state', () => {
    expect(reducer(undefined, {})).toEqual({
      students: [],
    });
  });
  it('should return correct state value when studentsuccess is called', () => {
    expect(
      reducer(undefined, {
        type: studentConstants.STUDENTS_SUCCESS,
        students: [
          {
            id: '123456',
            title: 'Student1',
          },
        ],
      }),
    ).toEqual({
      students: [
        {
          id: '123456',
          title: 'Student1',
        },
      ],
      updating: false,
    });
  });
  it('should return correct state value when studentsRequest is called', () => {
    expect(
      reducer(undefined, {
        type: studentConstants.STUDENTS_REQUEST,
      }),
    ).toEqual({
      students: [],
      updating: true,
    });
  });
  it('should return correct state value when studentsFailure is called', () => {
    expect(
      reducer(undefined, {
        type: studentConstants.STUDENTS_FAILURE,
      }),
    ).toEqual({
      students: [],
      updating: false,
      error: true,
    });
  });
});

/**
 * Test modules' actions
 */
describe('actions', () => {
  beforeEach(() => {
    // Runs before each test in the suite
    store.clearActions();
  });
  it('studentRequest Action should dispatch correct payload and action', () => {
    const expected = [
      {
        type: studentConstants.STUDENTS_REQUEST,
      },
    ];
    store.dispatch(actions.studentsRequest());
    expect(store.getActions()).toEqual(expected);
  });
  it('studentSuccess Action should dispatch correct payload and action', () => {
    const studentList = {
      students: [
        {
          id: '123456',
          title: 'Student1',
        },
      ],
    };
    const expected = [
      {
        students: studentList,
        type: studentConstants.STUDENTS_SUCCESS,
      },
    ];
    store.dispatch(actions.studentsSuccess(studentList));
    expect(store.getActions()).toEqual(expected);
  });
  it('studentFailure Action should dispatch correct payload and action', () => {
    const expected = [
      {
        type: studentConstants.STUDENTS_FAILURE,
      },
    ];
    store.dispatch(actions.studentsFailure());
    expect(store.getActions()).toEqual(expected);
  });
});

/**
 * Test modules' services
 */
describe('services', () => {});

/**
 * Test modules' sagas
 */
describe('sagas', () => {});

/**
 * Test modules' selectors
 */
describe('selectors', () => {});
