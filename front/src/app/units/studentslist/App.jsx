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

export class App extends Component {
  componentDidMount() {
    const { dispatch } = this.props;
    dispatch({
      type: 'STUDENTS_REQUEST',
    });
  }

  render() {
    const { student, updating } = this.props;
    return updating ? (
      <Div> Loading </Div>
    ) : (
      <EntityTable COLUMNS={COLUMNS} DATA={student} title={'StudentsList'} />
    );
  }
}
App.propTypes = {
  dispatch: PropTypes.func,
  student: PropTypes.oneOfType(PropTypes.object, PropTypes.array),
};

export default App;
