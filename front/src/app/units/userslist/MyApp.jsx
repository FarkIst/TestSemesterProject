import React, { Component } from 'react';
import PropTypes from 'prop-types';

import { EntityTable } from '~/app/shared/components';
const COLUMNS = [
  {
    property: 'id',
    label: 'id',
    dataScope: 'row',
    format: datum => <strong>{datum.id}</strong>,
  },
  {
    property: 'name',
    label: 'name',
  },
];

export class MyApp extends Component {
  componentDidMount() {
    const { dispatch } = this.props;
    dispatch({
      type: 'USERS_REQUEST',
    });
  }

  render() {
    const { user, updating } = this.props;
    console.log(user);
    return updating ? (
      <Div> Loading </Div>
    ) : (
      <EntityTable COLUMNS={COLUMNS} DATA={user} title={'UsersList'} />
    );
  }
}
MyApp.propTypes = {
  dispatch: PropTypes.func,
  user: PropTypes.oneOfType(PropTypes.object, PropTypes.array),
};

export default MyApp;
