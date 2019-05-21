require('es6-promise').polyfill();
require('isomorphic-fetch');

const getUsers = () => {
  fetch(process.env.API + 'users').then(function(response) {
    if (response.status >= 400) {
      throw new Error('Bad request');
    }
    return response.json();
  });
};

export { getUsers };
