import MyApp from './MyApp';
import { connect } from 'react-redux';
import { withRouter } from 'react-router-dom';

const mapStateToProps = state => {
  const { users } = state.user;
  return {
    user: users,
  };
};

const connectedApp = withRouter(connect(mapStateToProps)(MyApp));

export default connectedApp;
