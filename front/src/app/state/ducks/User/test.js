import { userConstants } from './types';
import reducer from './reducers';
import * as actions from './actions';
import sagas from './sagas';
import * as services from './services';
import selectors from './selectors';
const fetchMock = require('fetch-mock');

import configureStore from 'redux-mock-store';

const mockStore = configureStore();
const store = mockStore();

/**
 * Test modules' reducers
 */
describe('reducer', () => {
  it('should return the initial state', () => {
    expect(reducer(undefined, {})).toEqual({
      users: [],
    });
  });
  it('should return correct state value when usersSuccess is called', () => {
    expect(
      reducer(undefined, {
        type: userConstants.USERS_SUCCESS,
        users: [
          {
            id: '123456',
            title: 'User1',
          },
        ],
      }),
    ).toEqual({
      users: [
        {
          id: '123456',
          title: 'User1',
        },
      ],
      updating: false,
    });
  });
  it('should return correct state value whenusersRequest is called', () => {
    expect(
      reducer(undefined, {
        type: userConstants.USERS_REQUEST,
      }),
    ).toEqual({
      users: [],
      updating: true,
    });
  });
  it('should return correct state value when usersFailure is called', () => {
    expect(
      reducer(undefined, {
        type: userConstants.USERS_FAILURE,
      }),
    ).toEqual({
      users: [],
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
  it('usersRequest Action should dispatch correct payload and action', () => {
    const expected = [
      {
        type: userConstants.USERS_REQUEST,
      },
    ];
    store.dispatch(actions.usersRequest());
    expect(store.getActions()).toEqual(expected);
  });
  it('usersSuccess Action should dispatch correct payload and action', () => {
    const users = {
      users: [
        {
          id: '123456',
          title: 'User1',
        },
      ],
    };
    const expected = [
      {
        users: users,
        type: userConstants.USERS_SUCCESS,
      },
    ];
    store.dispatch(actions.usersSuccess(users));
    expect(store.getActions()).toEqual(expected);
  });
  it('usersFailure Action should dispatch correct payload and action', () => {
    const expected = [
      {
        type: userConstants.USERS_FAILURE,
      },
    ];
    store.dispatch(actions.usersFailure());
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
