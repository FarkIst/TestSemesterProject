import reducer from './reducers';
import * as actions from './actions';
import sagas from './sagas';
import services from './services';
import selectors from './selectors';
import { teachingstaffConstants } from './types';

import configureStore from 'redux-mock-store';

const mockStore = configureStore();
const store = mockStore();

/**
 * Test modules' reducers
 */
describe('reducer', () => {
  it('should return the initial state when no action is called', () => {
    expect(reducer(undefined, {})).toEqual({
      teachingstaff: [],
    });
  });
  it('should return correct state value when teachingstaffSuccess is called', () => {
    expect(
      reducer(undefined, {
        type: teachingstaffConstants.TEACHINGSTAFF_SUCCESS,
        teachingstaff: [
          {
            id: '123456',
            title: 'Teacher1',
          },
        ],
      }),
    ).toEqual({
      teachingstaff: [
        {
          id: '123456',
          title: 'Teacher1',
        },
      ],
      updating: false,
    });
  });
  it('should return correct state value when teachingstaffRequest is called', () => {
    expect(
      reducer(undefined, {
        type: teachingstaffConstants.TEACHINGSTAFF_REQUEST,
      }),
    ).toEqual({
      teachingstaff: [],
      updating: true,
    });
  });
  it('should return correct state value when teachingstaffFailure is called', () => {
    expect(
      reducer(undefined, {
        type: teachingstaffConstants.TEACHINGSTAFF_FAILURE,
      }),
    ).toEqual({
      teachingstaff: [],
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
  it('teachingstaffRequest Action should dispatch correct payload and action', () => {
    const expected = [
      {
        type: teachingstaffConstants.TEACHINGSTAFF_FAILURE,
      },
    ];
    store.dispatch(actions.teachingstaffFailure());
    expect(store.getActions()).toEqual(expected);
  });
  it('teachingstaffRequest Action should dispatch correct payload and action', () => {
    const expected = [
      {
        type: teachingstaffConstants.TEACHINGSTAFF_REQUEST,
      },
    ];
    store.dispatch(actions.teachingstaffRequest());
    expect(store.getActions()).toEqual(expected);
  });
  it('teachingstaffSuccess Action should dispatch correct payload and action', () => {
    const teachingStaff = {
      teachingstaff: [
        {
          id: '123456',
          title: 'Teacher1',
        },
      ],
    };
    const expected = [
      {
        teachingstaff: teachingStaff,
        type: teachingstaffConstants.TEACHINGSTAFF_SUCCESS,
      },
    ];
    store.dispatch(actions.teachingstaffSuccess(teachingStaff));
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
