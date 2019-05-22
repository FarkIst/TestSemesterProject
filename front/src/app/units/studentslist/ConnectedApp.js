import { connect } from 'react-redux';
import { withRouter } from 'react-router-dom';
import App from './App';

const mapStateToProps = state => {
  const { students } = state.student;
  return {
    student: students,
  };
};

const connectedApp = withRouter(connect(mapStateToProps)(App));

export default connectedApp;
