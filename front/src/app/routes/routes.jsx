import * as React from 'react';
import { Route, Switch } from 'react-router';
import { Home } from '../pages';

export const RootRoutes = () => (
  <Switch>
    <Route exact path="/" component={Home} />
    <Route render={() => <div>404 page </div>} />
  </Switch>
);
