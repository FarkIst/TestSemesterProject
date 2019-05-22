import * as React from 'react';
import { Box, Tab, Tabs, Text, Image } from 'grommet';

import { UserList, TeacherList, StudentList } from '~/app/units';

class Home extends React.Component {
  render() {
    return (
      <Tabs height="medium" flex="grow" alignSelf="center">
        <Tab title="Users">
          <Box margin="small" pad="small">
            <UserList />
          </Box>
        </Tab>
        <Tab title="Students">
          <Box margin="small" pad="small">
            <StudentList />
          </Box>
        </Tab>
        <Tab title="Teachers">
          <Box margin="small" pad="small">
            <TeacherList />
          </Box>
        </Tab>
      </Tabs>
    );
  }
}

export default Home;
