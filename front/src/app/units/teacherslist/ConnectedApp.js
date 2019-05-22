import { connect } from 'react-redux';
import { withRouter } from 'react-router-dom';
import App from './App';

const mapStateToProps = state => {
  const { teachingstaff } = state.teachingstaff;
  return {
    teachingstaff: teachingstaff,
  };
};

const connectedApp = withRouter(connect(mapStateToProps)(App));

export default connectedApp;
